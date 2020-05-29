package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.ou.extensions.domain.*;
import cn.ibizlab.core.ou.extensions.service.OUCoreService;
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.service.IIBZEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
public class OUCoreResource
{


    @Autowired
    private OUCoreService ouCoreService;

    @Autowired
    private IIBZEmployeeService iibzEmployeeService;

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


}
