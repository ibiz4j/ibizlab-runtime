package cn.ibizlab.core.ou.extensions.service;

import cn.ibizlab.core.ou.extensions.domain.DeptMap;
import cn.ibizlab.core.ou.extensions.domain.OrgMap;
import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.service.IIBZDepartmentService;
import cn.ibizlab.core.ou.service.IIBZOrganizationService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
public class OUModelService
{

	@Autowired
	private IIBZOrganizationService iibzOrganizationService;

	@Autowired
	private IIBZDepartmentService iibzDepartmentService;

	private Map<String, OrgMap> orgmap=null;


	private Object lockOrg=new Object();

	//@Cacheable( value="ibzou-model",key = "'orgmap'")
	public  Map<String, OrgMap> getOrgModel()
	{
		if(orgmap!=null)
			return orgmap;
		synchronized(lockOrg)
		{
			if(orgmap!=null)
				return orgmap;
			Map<String, OrgMap> store=new LinkedHashMap<>();
			List<IBZOrganization> listOrg=iibzOrganizationService.list(new QueryWrapper<IBZOrganization>().orderByAsc("showorder","orgcode"));
			for(IBZOrganization org:listOrg)
			{
				OrgMap map=new OrgMap();
				map.setOrg(org);
				store.put(org.getOrgid(),map);
			}

			for(IBZOrganization org:listOrg)
			{
				loopOrg(org,store);
				if(!StringUtils.isEmpty(org.getParentorgid())) {
					if (store.containsKey(org.getParentorgid())) {
						store.get(org.getParentorgid()).getChildren().add(org.getOrgid());
					}
				}

			}

			for(IBZOrganization org:listOrg)
			{
				for(String sub:store.get(org.getOrgid()).getSub())
				{
					if(!org.getOrgid().equals(sub))
						store.get(sub).getParent().add(org.getOrgid());
				}
			}

			orgmap=store;
		}

		return orgmap;
	}

	public void loopOrg(IBZOrganization org,Map<String, OrgMap> store)
	{
		if(!StringUtils.isEmpty(org.getParentorgid()))
		{
			if(store.containsKey(org.getParentorgid()))
			{
				store.get(org.getParentorgid()).getSub().add(org.getOrgid());
				loopOrg(store.get(org.getParentorgid()).getOrg(),store);
			}
		}

	}



	private Map<String, DeptMap> deptmap=null;

	private Object lockDept=new Object();

	//@Cacheable( value="ibzou-model",key = "'deptmap'")
	public  Map<String, DeptMap> getDeptModel(Map<String, OrgMap> orgstore)
	{
		if(deptmap!=null)
			return deptmap;
		synchronized(lockDept)
		{
			if(deptmap!=null)
				return deptmap;
			if(orgstore==null)
				orgstore=this.getOrgModel();
			Map<String, DeptMap> store=new LinkedHashMap<>();
			Map<String, Set<String>> bcmap=new HashMap<>();

			List<IBZDepartment> listDept=iibzDepartmentService.list(new QueryWrapper<IBZDepartment>().orderByAsc("showorder","deptcode"));
			for(IBZDepartment dept:listDept)
			{
				DeptMap map=new DeptMap();
				map.setDept(dept);
				store.put(dept.getDeptid(),map);

				String bc=dept.getBcode();
				if(!StringUtils.isEmpty(bc))
				{
					bc=bc.replace(";",",").replace("；",",").replace("，",",");
					String[] bcs=bc.split(",");
					for(String strbc:bcs)
					{
						strbc=strbc.trim();
						if(!StringUtils.isEmpty(strbc))
						{
							if(!bcmap.containsKey(strbc))
							{
								Set<String> bcset=new HashSet<>();
								bcmap.put(strbc,bcset);
							}
							bcmap.get(strbc).add(dept.getDeptid()+":"+dept.getOrgid());
						}
					}

				}

			}

			for(IBZDepartment dept:listDept)
			{
				loopDept(dept,store);
				if(!StringUtils.isEmpty(dept.getParentdeptid())) {
					if (store.containsKey(dept.getParentdeptid())) {
						store.get(dept.getParentdeptid()).getChildren().add(dept.getDeptid());
					}
				}
			}

			for(IBZDepartment dept:listDept)
			{
				for(String sub:store.get(dept.getDeptid()).getSub())
				{
					if(!dept.getDeptid().equals(sub))
						store.get(sub).getParent().add(dept.getDeptid());
				}
			}

			for(IBZDepartment dept:listDept)
			{
				String orgid=dept.getOrgid();
				if(StringUtils.isEmpty(orgid)||(!orgstore.containsKey(orgid)))
					continue;

				String bc=dept.getBcode();
				if(!StringUtils.isEmpty(bc))
				{
					bc = bc.replace(";", ",").replace("；", ",").replace("，", ",");
					String[] bcs = bc.split(",");
					for (String strbc : bcs)
					{
						strbc = strbc.trim();
						if (!StringUtils.isEmpty(strbc))
						{
							if(bcmap.containsKey(strbc))
							{
								Set<String> bcset=bcmap.get(strbc);
								for(String bcstring:bcset)
								{
									String[] bcstringarr=bcstring.split(":");
									if(bcstringarr.length==2)
									{
										String bcdept=bcstringarr[0];
										String bcorg=bcstringarr[1];
										for(String porg:orgstore.get(orgid).getParent())
										{
											if(bcorg.equals(porg))
												store.get(dept.getDeptid()).getParent().add(bcdept);
										}
										for(String sorg:orgstore.get(orgid).getSub())
										{
											if(bcorg.equals(sorg))
												store.get(dept.getDeptid()).getSub().add(bcdept);
										}
									}
								}
							}
						}
					}
				}
			}

			deptmap=store;
		}

		return deptmap;
	}

	public void loopDept(IBZDepartment dept,Map<String,DeptMap> store)
	{
		if(!StringUtils.isEmpty(dept.getParentdeptid()))
		{
			if(store.containsKey(dept.getParentdeptid()))
			{
				store.get(dept.getParentdeptid()).getSub().add(dept.getDeptid());
				loopDept(store.get(dept.getParentdeptid()).getDept(),store);
			}
		}

	}


	//@CacheEvict( value="ibzou-model",allEntries = true)
	public synchronized void refreshModel()
	{

		synchronized (lockDept)
		{
			this.deptmap = null;
		}
		synchronized (lockOrg)
		{
			this.orgmap = null;
		}
	}

}
