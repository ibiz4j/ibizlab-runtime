package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.extensions.domain.*;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.ou.service.ISysDepartmentService;
import cn.ibizlab.core.ou.service.ISysEmployeeService;
import cn.ibizlab.core.ou.service.ISysOrganizationService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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



    @Cacheable( value="ibzou-model",key = "'catalog:'+#p0")
    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/catalogs/Ibzou{catalog}")
    public ResponseEntity<JSONObject> getCatalog(@PathVariable("catalog") String catalog) {
        return ResponseEntity.status(HttpStatus.OK).body(getItems("Ibzou"+catalog));
    }

    @Cacheable( value="ibzou-model",key = "'codelist:'+#p0")
    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/codelist/Ibzou{catalog}")
    public ResponseEntity<JSONObject> getCodeList(@PathVariable("catalog") String catalog) {
        return ResponseEntity.status(HttpStatus.OK).body(getItems("Ibzou"+catalog));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/catalogs/Ibzou{code}/options")
    public ResponseEntity<List> getOptions(@PathVariable("code") String code) {
        return ResponseEntity.status(HttpStatus.OK).body((List) getItems("Ibzou"+code).get("items"));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/dictionarys/codelist/Ibzou{code}/items")
    public ResponseEntity<List> getCodeItems(@PathVariable("code") String code) {
        return ResponseEntity.status(HttpStatus.OK).body((List) getItems("Ibzou"+code).get("items"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dictionarys/catalogs/Ibzou{code}/options")
    public ResponseEntity<List> getOptions(@PathVariable("code") String code,@RequestBody List<String> values) {
        return ResponseEntity.status(HttpStatus.OK).body((List) getItems("Ibzou"+code,values).get("items"));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/dictionarys/codelist/Ibzou{code}/items")
    public ResponseEntity<List> getCodeItems(@PathVariable("code") String code, @RequestBody List<String> values) {
        return ResponseEntity.status(HttpStatus.OK).body((List) getItems("Ibzou"+code,values).get("items"));
    }

    public JSONObject getItems(String catalog) {
        return getItems(catalog,null);
    }
    public JSONObject getItems(String catalog,List<String> values) {
        JSONObject jo=new JSONObject();
        jo.put("srfkey",catalog);
        jo.put("emptytext","");
        List<JSONObject> list=new ArrayList<>();

        if("IbzouOrg".equalsIgnoreCase(catalog))
        {
            LambdaQueryWrapper<SysOrganization> queryWrapper = Wrappers.<SysOrganization>lambdaQuery();
            if(!ObjectUtils.isEmpty(values))
                queryWrapper.in(SysOrganization::getOrgid,values);
            queryWrapper.orderByAsc(SysOrganization::getShoworder);
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
            LambdaQueryWrapper<SysDepartment> queryWrapper = Wrappers.<SysDepartment>lambdaQuery();
            if(!ObjectUtils.isEmpty(values))
                queryWrapper.in(SysDepartment::getDeptid,values);
            queryWrapper.orderByAsc(SysDepartment::getShoworder);
            iibzDepartmentService.list(queryWrapper).forEach(item -> {
                JSONObject option=new JSONObject();
                option.put("id",item.getDeptid());
                option.put("value",item.getDeptid());
                option.put("label",item.getDeptname());
                option.put("text",item.getDeptname());
                list.add(option);
            });
        }
        else if("IbzouUser".equalsIgnoreCase(catalog)||"IbzouOperator".equalsIgnoreCase(catalog)||"IbzouEmp".equalsIgnoreCase(catalog)||"IbzouPerson".equalsIgnoreCase(catalog))
        {
            LambdaQueryWrapper<SysEmployee> queryWrapper = Wrappers.<SysEmployee>lambdaQuery();
            if(!ObjectUtils.isEmpty(values))
                queryWrapper.in(SysEmployee::getUserid,values);
            queryWrapper.orderByAsc(SysEmployee::getShoworder);
            iibzEmployeeService.list(queryWrapper).forEach(item -> {
                JSONObject option=new JSONObject();
                option.put("id",item.getUserid());
                option.put("value",item.getUserid());
                option.put("label",item.getPersonname());
                option.put("text",item.getPersonname());
                list.add(option);
            });
        }


        jo.put("items",list);

        return jo;
    }



}
