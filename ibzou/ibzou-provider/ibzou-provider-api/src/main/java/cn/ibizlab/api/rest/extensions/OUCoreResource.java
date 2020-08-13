package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.extensions.domain.*;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.service.IIBZDepartmentService;
import cn.ibizlab.core.ou.service.IIBZEmployeeService;
import cn.ibizlab.core.ou.service.IIBZOrganizationService;
import com.alibaba.fastjson.JSONArray;
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

import java.sql.Wrapper;
import java.util.*;

@RestController
public class OUCoreResource
{


    @Autowired
    private OUCoreService ouCoreService;

    @Autowired
    private IIBZEmployeeService iibzEmployeeService;


    @Autowired
    private IIBZOrganizationService iibzOrganizationService;


    @Autowired
    private IIBZDepartmentService iibzDepartmentService;

    @GetMapping("/ibzemployees/{userId}/oumaps")
    public ResponseEntity<Map<String, Set<String>>> getOUMapsByUserId(@PathVariable("userId") String userId)
    {
        IBZEmployee emp=iibzEmployeeService.get(userId);
        String orgid="nullorgid";
        if(!StringUtils.isEmpty(emp.getOrgid()))
            orgid=emp.getOrgid();
        String deptid="nulldeptid";
        if(!StringUtils.isEmpty(emp.getMdeptid()))
            deptid=emp.getMdeptid();
        return ResponseEntity.ok(this.getMaps(orgid,deptid));
    }

    @GetMapping("/ibzdepartments/{deptId}/emp")
    public ResponseEntity<Map> getEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getEmpByDept(deptId);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzdepartments/{deptId}/fatheremp")
    public ResponseEntity<Map> getFatherEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getParentEmpByDept(deptId,false);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzdepartments/{deptId}/parentemp")
    public ResponseEntity<Map> getParentEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getParentEmpByDept(deptId,true);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzdepartments/{deptId}/subemp")
    public ResponseEntity<Map> getSubEmpByDept(@PathVariable("deptId") String deptId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getSubEmpByDept(deptId);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }


    @GetMapping("/ibzorganizations/{orgId}/emp")
    public ResponseEntity<Map> getEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getEmpByOrg(orgId);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzorganizations/{orgId}/fatheremp")
    public ResponseEntity<Map> getFatherEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getParentEmpByOrg(orgId,false);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzorganizations/{orgId}/parentemp")
    public ResponseEntity<Map> getParentEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getParentEmpByOrg(orgId,true);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzorganizations/{orgId}/subemp")
    public ResponseEntity<Map> getSubEmpByOrg(@PathVariable("orgId") String orgId)
    {
        Map map=new LinkedHashMap<>();
        List<IBZEmployee> list=ouCoreService.getSubEmpByOrg(orgId);
        for(IBZEmployee emp:list)
            map.put(emp.getUserid(),emp);
        return ResponseEntity.ok(map);
    }

    @GetMapping("/ibzorganizations/picker")
    public ResponseEntity<List<OrgNode>> getPicker()
    {
        List<OrgNode> list=ouCoreService.getOrgNode("alls");
        return ResponseEntity.ok(list);
    }

    @GetMapping("/ibzorganizations/{orgId}/ibzdepartments/picker")
    public ResponseEntity<List<DeptNode>> getOrgDeptPicker(@PathVariable("orgId") String orgId)
    {
        List<DeptNode> list=ouCoreService.getDeptNode(orgId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/ibzorganizations/{orgId}/suborg/picker")
    public ResponseEntity<List<OrgNode>> getSubOrgPicker(@PathVariable("orgId") String orgId)
    {
        List<OrgNode> list=ouCoreService.getOrgNode(orgId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/ibzorganizations/{orgId}/suborg/ibzdepartments/picker")
    public ResponseEntity<List<DeptNode>> getSubOrgDeptPicker(@PathVariable("orgId") String orgId)
    {
        List<DeptNode> list=ouCoreService.getOrgDeptNode(orgId);
        return ResponseEntity.ok(list);
    }


    @GetMapping("/ibzorganizations/{orgId}/ibzemployees/picker")
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
            LambdaQueryWrapper<IBZOrganization> queryWrapper = Wrappers.<IBZOrganization>lambdaQuery();
            if(!ObjectUtils.isEmpty(values))
                queryWrapper.in(IBZOrganization::getOrgid,values);
            queryWrapper.orderByAsc(IBZOrganization::getShoworder);
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
            LambdaQueryWrapper<IBZDepartment> queryWrapper = Wrappers.<IBZDepartment>lambdaQuery();
            if(!ObjectUtils.isEmpty(values))
                queryWrapper.in(IBZDepartment::getDeptid,values);
            queryWrapper.orderByAsc(IBZDepartment::getShoworder);
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
            LambdaQueryWrapper<IBZEmployee> queryWrapper = Wrappers.<IBZEmployee>lambdaQuery();
            if(!ObjectUtils.isEmpty(values))
                queryWrapper.in(IBZEmployee::getUserid,values);
            queryWrapper.orderByAsc(IBZEmployee::getShoworder);
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
