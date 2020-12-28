package cn.ibizlab.core.ou.extensions.service;

import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.extensions.domain.*;
import cn.ibizlab.core.ou.extensions.mapping.SysDept2NodeMapping;
import cn.ibizlab.core.ou.extensions.mapping.SysEmp2NodeMapping;
import cn.ibizlab.core.ou.extensions.mapping.SysOrg2NodeMapping;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import cn.ibizlab.core.ou.filter.SysEmployeeSearchContext;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;
import cn.ibizlab.core.ou.service.ISysDepartmentService;
import cn.ibizlab.core.ou.service.ISysEmployeeService;
import cn.ibizlab.core.ou.service.ISysOrganizationService;
import cn.ibizlab.util.filter.QueryWrapperContext;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class OUCoreService
{


	@Autowired
	@Lazy
	private OUModelService ouModelService;

	@Autowired
	@Lazy
	private ISysEmployeeService iibzEmployeeService;


	public List<SysEmployee> getEmpByOrg(String orgid)
	{
		if(StringUtils.isEmpty(orgid) || "nullorgid".equals(orgid))
			return new ArrayList<>();
		return iibzEmployeeService.list(new QueryWrapper<SysEmployee>().eq("orgid",orgid).orderByAsc("showorder"));
	}

	public List<SysEmployee> getEmpByDept(String deptid)
	{
		if(StringUtils.isEmpty(deptid) || "nulldeptid".equals(deptid))
			return new ArrayList<>();
		return iibzEmployeeService.list(new QueryWrapper<SysEmployee>().eq("mdeptid",deptid).orderByAsc("showorder"));
	}

	public List<SysEmployee> getSubEmpByOrg(String orgid)
	{
		if(StringUtils.isEmpty(orgid) || "nullorgid".equals(orgid))
			return new ArrayList<>();
		Map<String, OrgMap> store=ouModelService.getOrgModel();
		OrgMap orgmodel=this.getOrgModel(orgid);
		if(orgmodel.getSub().size()==store.size())
			return iibzEmployeeService.list();
		return iibzEmployeeService.list(new QueryWrapper<SysEmployee>().in("orgid",orgmodel.getSub()));
	}

	public List<SysEmployee> getSubEmpByDept(String deptid)
	{
		if(StringUtils.isEmpty(deptid) || "nulldeptid".equals(deptid))
			return new ArrayList<>();
		DeptMap deptmodel=this.getDeptModel(deptid);
		return iibzEmployeeService.list(new QueryWrapper<SysEmployee>().in("mdeptid",deptmodel.getSub()));
	}

	public List<SysEmployee> getParentEmpByOrg(String orgid,boolean bRecurrence)
	{
		if(StringUtils.isEmpty(orgid) || "nullorgid".equals(orgid))
			return new ArrayList<>();
		OrgMap orgmodel=this.getOrgModel(orgid);
		List<String> parent=new ArrayList<>();
		for(String str:orgmodel.getParent())
		{
			parent.add(str);
			if(!bRecurrence)
				break;
		}
		if(parent.size()==0)
			return new ArrayList<>();
		return iibzEmployeeService.list(new QueryWrapper<SysEmployee>().in("orgid",parent));
	}

	public List<SysEmployee> getParentEmpByDept(String deptid,boolean bRecurrence)
	{
		if(StringUtils.isEmpty(deptid) || "nulldeptid".equals(deptid))
			return new ArrayList<>();
		DeptMap deptmodel=this.getDeptModel(deptid);
		List<String> parent=new ArrayList<>();
		for(String str:deptmodel.getParent())
		{
			parent.add(str);
			if(!bRecurrence)
				break;
		}
		if(parent.size()==0)
			return new ArrayList<>();
		return iibzEmployeeService.list(new QueryWrapper<SysEmployee>().in("mdeptid",parent));
	}

	public OrgMap getOrgModel(String orgid)
	{
		Map<String, OrgMap> store=ouModelService.getOrgModel();
		if(store.containsKey(orgid))
		{
			OrgMap map = store.get(orgid);
			return map;
		}
		else
		{
			OrgMap map = new OrgMap();
			map.setOrgid(orgid);
			return map;
		}
	}

	public DeptMap getDeptModel(String deptid)
	{
		Map<String, DeptMap> store=ouModelService.getDeptModel(ouModelService.getOrgModel());
		if(store.containsKey(deptid))
		{
			DeptMap map = store.get(deptid);
			return map;
		}
		else
		{
			DeptMap map = new DeptMap();
			map.setDeptid(deptid);
			return map;
		}
	}


	@Autowired
	private SysOrg2NodeMapping org2NodeMapping;

	public List<OrgNode> getOrgNode(String root)
	{
		if(StringUtils.isEmpty(root))
			root="alls";


		List<OrgNode> list=new ArrayList<>();
		Map<String,OrgMap> store=ouModelService.getOrgModel();

		if(root.equals("alls"))
		{
			int rootcnt=0;
			String tmp="";
			for(OrgMap map:store.values()) {
				SysOrganization org = map.getOrg();
				if(StringUtils.isEmpty(org.getParentorgid())) {
					rootcnt++;
					tmp=org.getOrgid();
				}
			}
			if(rootcnt==1)
				root=tmp;
		}

		for(OrgMap map:store.values())
		{
			SysOrganization org=map.getOrg();
			String parent=org.getParentorgid();
			if(StringUtils.isEmpty(parent))
				parent="alls";
			if(parent.equals(root)||root.equals(org.getOrgid()))
			{
				OrgNode node=org2NodeMapping.toDto(org);
				node.getFilter().addAll(map.getParent());
				node.getFilter().add(node.getOrgid());
				if(root.equals(org.getOrgid())) {
					list.add(0,node);
				}
				else {
					looporg(node, store);
					list.add(node);
				}
			}
		}
		return list;
	}

	private void looporg(OrgNode node,Map<String,OrgMap> store)
	{
		Set<String> children=store.get(node.getOrgid()).getChildren();
		for(String child:children)
		{
			OrgMap childMap=store.get(child);
			OrgNode sub=org2NodeMapping.toDto(childMap.getOrg());
			sub.getFilter().addAll(childMap.getParent());
			sub.getFilter().add(sub.getOrgid());
			node.getChildren().add(sub);
			looporg(sub,store);
		}
	}


	@Autowired
	private SysDept2NodeMapping dept2NodeMapping;

	public List<DeptNode> getDeptNode(String orgid)
	{
		List<DeptNode> list=new ArrayList<>();
		if(StringUtils.isEmpty(orgid))
			return list;

		Map<String,DeptMap> store=ouModelService.getDeptModel(ouModelService.getOrgModel());
		for(DeptMap map:store.values())
		{
			SysDepartment dept=map.getDept();
			if(StringUtils.isEmpty(dept.getParentdeptid())&&orgid.equals(dept.getOrgid()))
			{
				DeptNode node=dept2NodeMapping.toDto(dept);
				loopdept(node,store);
				list.add(node);
			}
		}
		return list;
	}


	public List<DeptNode> getOrgDeptNode(String orgid)
	{
		List<DeptNode> list=new ArrayList<>();
		if(StringUtils.isEmpty(orgid))
			orgid="alls";

		Map<String,DeptNode> parentNode=new HashMap<>();

		List<OrgNode> listOrg=getOrgNode(orgid);
		for(OrgNode org:listOrg)
		{
			DeptNode node = changeOrgNode2DeptNode(org,parentNode);
			list.add(node);
		}

		Map<String,DeptMap> store=ouModelService.getDeptModel(ouModelService.getOrgModel());
		for(DeptMap map:store.values())
		{
			SysDepartment dept=map.getDept();
			if(StringUtils.isEmpty(dept.getParentdeptid()))
			{
				DeptNode node=dept2NodeMapping.toDto(dept);
				if(parentNode.containsKey(dept.getOrgid())) {
					node.setFilter(parentNode.get(dept.getOrgid()).getFilter());
					parentNode.get(dept.getOrgid()).getChildren().add(node);
					loopdept(node,store);
				}

			}
		}
		return list;
	}

	private void loopdept(DeptNode node,Map<String,DeptMap> store)
	{
		Set<String> children=store.get(node.getDeptid()).getChildren();
		for(String child:children)
		{
			DeptMap childMap=store.get(child);
			DeptNode sub=dept2NodeMapping.toDto(childMap.getDept());
			sub.setFilter(node.getFilter());
			node.getChildren().add(sub);
			loopdept(sub,store);
		}
	}

	private DeptNode  changeOrgNode2DeptNode(OrgNode orgnode,Map<String,DeptNode> parentNode)
	{
		DeptNode node = new DeptNode();
		node.setDeptid(orgnode.getOrgid());
		node.setDeptname(orgnode.getOrgname());
		node.setFilter(orgnode.getFilter());
		node.setDisabled(true);
		parentNode.put(orgnode.getOrgid(),node);
		for(OrgNode org:orgnode.getChildren())
		{
			node.getChildren().add(changeOrgNode2DeptNode(org,parentNode));
		}
		return node;
	}


	@Autowired
	private SysEmp2NodeMapping emp2NodeMapping;

	public List<EmpNode> getEmpNode(String orgid)
	{
		List<EmpNode> listemp=new ArrayList<>();
		List<String> list=new ArrayList<>();
		if(StringUtils.isEmpty(orgid))
			return listemp;

		Map<String,DeptMap> store=ouModelService.getDeptModel(ouModelService.getOrgModel());
		for(DeptMap map:store.values())
		{
			SysDepartment dept=map.getDept();
			if(StringUtils.isEmpty(dept.getParentdeptid())&&orgid.equals(dept.getOrgid()))
			{
				list.add(dept.getDeptid());
				loopdept(dept.getDeptid(),store,list);
			}
		}

		LinkedHashMap<String,List<EmpNode>> empmap=new LinkedHashMap<>();
		for(String deptid:list)
		{
			empmap.put(deptid,new ArrayList<>());
		}

		for(EmpNode node:emp2NodeMapping.toDto(this.getEmpByOrg(orgid)))
		{
			if(empmap.containsKey(node.getMdeptid()))
				empmap.get(node.getMdeptid()).add(node);
		}

		for(String deptid:list)
		{
			listemp.addAll(empmap.get(deptid));
		}


		return listemp;
	}

	private void loopdept(String node,Map<String,DeptMap> store,List<String> list)
	{
		Set<String> children=store.get(node).getChildren();
		for(String child:children)
		{
			list.add(child);
			loopdept(child,store,list);
		}
	}

	@Autowired
	private ISysOrganizationService iibzOrganizationService;

	@Autowired
	private ISysDepartmentService iibzDepartmentService;

	@Cacheable( value="ibzou-model",key = "'catalog:'+#p0")
	public JSONObject getItems(String catalog) {
		return getItems(catalog,null);
	}
	public JSONObject getItems(String catalog, QueryWrapperContext context) {
		JSONObject jo=new JSONObject();
		jo.put("srfkey",catalog);
		jo.put("emptytext","");
		List<JSONObject> list=new ArrayList<>();

		if("IbzouOrg".equalsIgnoreCase(catalog))
		{
			QueryWrapper<SysOrganization> queryWrapper = context==null? Wrappers.query():context.getSelectCond();
			queryWrapper.orderByAsc("showorder");
			iibzOrganizationService.list(queryWrapper).forEach(item -> {
				JSONObject option=new JSONObject();
				option.put("id",item.getOrgid());
				option.put("value",item.getOrgid());
				option.put("label",item.getOrgname());
				option.put("text",item.getOrgname());
				list.add(option);
			});
		}
		else if("IbzouDept".equalsIgnoreCase(catalog)||"IbzouOrgSector".equalsIgnoreCase(catalog))
		{
			QueryWrapper<SysDepartment> queryWrapper = context==null? Wrappers.query():context.getSelectCond();
			queryWrapper.orderByAsc("showorder");
			iibzDepartmentService.list(queryWrapper).forEach(item -> {
				JSONObject option=new JSONObject();
				option.put("id",item.getDeptid());
				option.put("value",item.getDeptid());
				option.put("label",item.getDeptname());
				option.put("text",item.getDeptname());
				option.put("filter",item.getOrgid());
				list.add(option);
			});
		}
		else if("IbzouUser".equalsIgnoreCase(catalog)||"IbzouOperator".equalsIgnoreCase(catalog)||"IbzouEmp".equalsIgnoreCase(catalog)||"IbzouPerson".equalsIgnoreCase(catalog))
		{
			QueryWrapper<SysEmployee> queryWrapper = context==null? Wrappers.query():context.getSelectCond();
			queryWrapper.orderByAsc("showorder");
			iibzEmployeeService.list(queryWrapper).forEach(item -> {
				JSONObject option=new JSONObject();
				option.put("id",item.getUserid());
				option.put("value",item.getUserid());
				option.put("label",item.getPersonname());
				option.put("text",item.getPersonname());
				option.put("code", item.getUsercode());
				option.put("name", item.getUsername());
				option.put("filter",item.getOrgid());
				list.add(option);
			});
		}


		jo.put("items",list);

		return jo;
	}

}
