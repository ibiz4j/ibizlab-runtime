package cn.ibizlab.core.ou.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[SysDepartment] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzou-api:ibzou-api}", contextId = "SysDepartment", fallback = SysDepartmentFallback.class)
public interface SysDepartmentFeignClient {

    @RequestMapping(method = RequestMethod.POST, value = "/sysdepartments")
    SysDepartment create(@RequestBody SysDepartment sysdepartment);

    @RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/batch")
    Boolean createBatch(@RequestBody List<SysDepartment> sysdepartments);


    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/{deptid}")
    SysDepartment get(@PathVariable("deptid") String deptid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/{deptid}")
    Boolean remove(@PathVariable("deptid") String deptid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/sysdepartments/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/{deptid}")
    SysDepartment update(@PathVariable("deptid") String deptid,@RequestBody SysDepartment sysdepartment);

    @RequestMapping(method = RequestMethod.PUT, value = "/sysdepartments/batch")
    Boolean updateBatch(@RequestBody List<SysDepartment> sysdepartments);


    @RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/checkkey")
    Boolean checkKey(@RequestBody SysDepartment sysdepartment);



    @RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/searchdefault")
    Page<SysDepartment> searchDefault(@RequestBody SysDepartmentSearchContext context);


    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/getdraft")
    SysDepartment getDraft(SysDepartment entity);


    @RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/save")
    Object saveEntity(@RequestBody SysDepartment sysdepartment);

    default Boolean save(@RequestBody SysDepartment sysdepartment) { return saveEntity(sysdepartment)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/sysdepartments/savebatch")
    Boolean saveBatch(@RequestBody List<SysDepartment> sysdepartments);


    @RequestMapping(method = RequestMethod.GET, value = "/sysdepartments/select")
    Page<SysDepartment> select();


}
