package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.extensions.domain.*;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import cn.ibizlab.core.ou.filter.SysEmployeeSearchContext;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;
import cn.ibizlab.core.ou.service.ISysDepartmentService;
import cn.ibizlab.core.ou.service.ISysEmployeeService;
import cn.ibizlab.core.ou.service.ISysOrganizationService;
import cn.ibizlab.util.domain.DTOBase;
import cn.ibizlab.util.domain.EntityBase;
import cn.ibizlab.util.filter.QueryWrapperContext;
import cn.ibizlab.util.filter.SearchContextBase;
import cn.ibizlab.util.helper.DataObject;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class OUCoreResource
{


    @Autowired
    private OUCoreService ouCoreService;

    @Autowired
    private ISysEmployeeService iibzEmployeeService;


    @Autowired
    private ISysOrganizationService iibzOrganizationService;


    @Autowired
    private ISysDepartmentService iibzDepartmentService;

    @GetMapping(value={"/ibzemployees/{userId}/oumaps","/sysemployees/{userId}/oumaps"})
    public ResponseEntity<Map<String, Set<String>>> getOUMapsByUserId(@PathVariable("userId") String userId)
    {
        SysEmployee emp=iibzEmployeeService.get(userId);
        String orgid="nullorgid";
        if(!StringUtils.isEmpty(emp.getOrgid()))
            orgid=emp.getOrgid();
        String deptid="nulldeptid";
        if(!StringUtils.isEmpty(emp.getMdeptid()))
            deptid=emp.getMdeptid();
        return ResponseEntity.ok(this.getMaps(orgid,deptid));
    }

    @GetMapping(value={"/ibzdepartments/{deptId}/emp","/sysdepartments/{deptId}/emp"})
    public ResponseEntity<Map> getEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getEmpByDept(deptId);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzdepartments/{deptId}/fatheremp","/sysdepartments/{deptId}/fatheremp"})
    public ResponseEntity<Map> getFatherEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getParentEmpByDept(deptId,false);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzdepartments/{deptId}/parentemp","/sysdepartments/{deptId}/parentemp"})
    public ResponseEntity<Map> getParentEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getParentEmpByDept(deptId,true);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzdepartments/{deptId}/subemp","/sysdepartments/{deptId}/subemp"})
    public ResponseEntity<Map> getSubEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getSubEmpByDept(deptId);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }


    @GetMapping(value={"/ibzorganizations/{orgId}/emp","/sysorganizations/{orgId}/emp"})
    public ResponseEntity<Map> getEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getEmpByOrg(orgId);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzorganizations/{orgId}/fatheremp","/sysorganizations/{orgId}/fatheremp"})
    public ResponseEntity<Map> getFatherEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getParentEmpByOrg(orgId,false);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzorganizations/{orgId}/parentemp","/sysorganizations/{orgId}/parentemp"})
    public ResponseEntity<Map> getParentEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getParentEmpByOrg(orgId,true);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzorganizations/{orgId}/subemp","/sysorganizations/{orgId}/subemp"})
    public ResponseEntity<Map> getSubEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<SysEmployee> list=ouCoreService.getSubEmpByOrg(orgId);
        for(SysEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping(value={"/ibzorganizations/picker","/sysorganizations/picker"})
    public ResponseEntity<List<OrgNode>> getPicker()
    {
        List<OrgNode> list=ouCoreService.getOrgNode("alls");
        return ResponseEntity.ok(list);
    }

    @GetMapping(value={"/ibzorganizations/{orgId}/ibzdepartments/picker","/sysorganizations/{orgId}/sysdepartments/picker"})
    public ResponseEntity<List<DeptNode>> getOrgDeptPicker(@PathVariable("orgId") String orgId)
    {
        List<DeptNode> list=ouCoreService.getDeptNode(orgId);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value={"/ibzorganizations/{orgId}/suborg/picker","/sysorganizations/{orgId}/suborg/picker"})
    public ResponseEntity<List<OrgNode>> getSubOrgPicker(@PathVariable("orgId") String orgId)
    {
        List<OrgNode> list=ouCoreService.getOrgNode(orgId);
        return ResponseEntity.ok(list);
    }

    @GetMapping(value={"/ibzorganizations/{orgId}/suborg/ibzdepartments/picker","/sysorganizations/{orgId}/suborg/sysdepartments/picker"})
    public ResponseEntity<List<DeptNode>> getSubOrgDeptPicker(@PathVariable("orgId") String orgId)
    {
        List<DeptNode> list=ouCoreService.getOrgDeptNode(orgId);
        return ResponseEntity.ok(list);
    }


    @GetMapping(value={"/ibzorganizations/{orgId}/ibzemployees/picker","/sysorganizations/{orgId}/sysemployees/picker"})
    public ResponseEntity<List<EmpNode>> getEmpPicker(@PathVariable("orgId") String orgId)
    {
        List<EmpNode> list=ouCoreService.getEmpNode(orgId);
        return ResponseEntity.ok(list);
    }


    private Map<String, Set<String>> getMaps(String orgid,String deptid)
    {
        Map<String, Set<String>> map=new LinkedHashMap<>();
        OrgMap storemap=ouCoreService.getOrgModel(orgid);
        map.put("parentorg",storemap.getParent());
        map.put("suborg",storemap.getSub());
        map.put("fatherorg",storemap.getFather());

        DeptMap storedeptmap=ouCoreService.getDeptModel(deptid);
        map.put("parentdept",storedeptmap.getParent());
        map.put("subdept",storedeptmap.getSub());
        map.put("fatherdept",storedeptmap.getFather());
        return map;
    }



    @RequestMapping(method = {RequestMethod.GET}, value = {"/dictionarys/catalogs/Ibzou{catalog}","/dictionarys/codelist/Ibzou{catalog}"})
    public ResponseEntity<JSONObject> getCodeList(@PathVariable("catalog") String catalog, SearchContextBase context) {
        return ResponseEntity.status(HttpStatus.OK).body(getItems("Ibzou"+catalog,context));
    }


    @RequestMapping(method = {RequestMethod.GET}, value = {"/dictionarys/catalogs/Ibzou{code}/options","/dictionarys/codelist/Ibzou{code}/items"})
    public ResponseEntity<List> getCodeItems(@PathVariable("code") String code, SearchContextBase context) {
        return ResponseEntity.status(HttpStatus.OK).body((List) getItems("Ibzou"+code,context).get("items"));
    }


    @RequestMapping(method = {RequestMethod.POST}, value = {"/dictionarys/catalogs/Ibzou{catalog}","/dictionarys/codelist/Ibzou{catalog}"})
    public ResponseEntity<JSONObject> codeList(@PathVariable("catalog") String catalog,@RequestBody(required = false) SearchContextBase context) {
        return ResponseEntity.status(HttpStatus.OK).body(getItems("Ibzou"+catalog,context));
    }


    @RequestMapping(method = {RequestMethod.POST}, value = {"/dictionarys/catalogs/Ibzou{code}/options","/dictionarys/codelist/Ibzou{code}/items"})
    public ResponseEntity<List> codeItems(@PathVariable("code") String code,@RequestBody(required = false) SearchContextBase context) {
        return ResponseEntity.status(HttpStatus.OK).body((List) getItems("Ibzou"+code,context).get("items"));
    }


    public JSONObject getItems(String catalog, SearchContextBase context) {

        QueryWrapperContext searchContext=null;
        if("IbzouOrg".equalsIgnoreCase(catalog))
        {
            if(context!=null)
                searchContext=JSON.toJavaObject((JSONObject)JSON.toJSON(context.getParams()),SysOrganizationSearchContext.class);

        }
        else if("IbzouDept".equalsIgnoreCase(catalog)||"IbzouOrgSector".equalsIgnoreCase(catalog))
        {
            if(context!=null)
                searchContext=JSON.toJavaObject((JSONObject)JSON.toJSON(context),SysDepartmentSearchContext.class);
        }
        else if("IbzouUser".equalsIgnoreCase(catalog)||"IbzouOperator".equalsIgnoreCase(catalog)||"IbzouEmp".equalsIgnoreCase(catalog)||"IbzouPerson".equalsIgnoreCase(catalog))
        {
            if(context!=null)
                searchContext=JSON.toJavaObject((JSONObject)JSON.toJSON(context),SysEmployeeSearchContext.class);
        }

        if(searchContext==null||StringUtils.isEmpty(searchContext.getSelectCond().getSqlSegment()))
            return ouCoreService.getItems(catalog);
        else
            return ouCoreService.getItems(catalog,searchContext);


    }


}
