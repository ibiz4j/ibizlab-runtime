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
import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.filter.IBZDepartmentSearchContext;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[IBZDepartment] 服务对象接口
 */
@FeignClient(value = "ibzou-api", contextId = "IBZDepartment", fallback = IBZDepartmentFallback.class)
public interface IBZDepartmentFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/select")
    Page<IBZDepartment> select();


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/save")
    Boolean save(@RequestBody IBZDepartment ibzdepartment);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/save")
    Boolean saveBatch(@RequestBody List<IBZDepartment> ibzdepartments);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/{deptid}")
    IBZDepartment get(@PathVariable("deptid") String deptid);


    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/{deptid}")
    Boolean remove(@PathVariable("deptid") String deptid);

    @RequestMapping(method = RequestMethod.DELETE, value = "/ibzdepartments/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/checkkey")
    Boolean checkKey(@RequestBody IBZDepartment ibzdepartment);


    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/{deptid}")
    IBZDepartment update(@PathVariable("deptid") String deptid,@RequestBody IBZDepartment ibzdepartment);

    @RequestMapping(method = RequestMethod.PUT, value = "/ibzdepartments/batch")
    Boolean updateBatch(@RequestBody List<IBZDepartment> ibzdepartments);


    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments")
    IBZDepartment create(@RequestBody IBZDepartment ibzdepartment);

    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/batch")
    Boolean createBatch(@RequestBody List<IBZDepartment> ibzdepartments);


    @RequestMapping(method = RequestMethod.GET, value = "/ibzdepartments/getdraft")
    IBZDepartment getDraft();



    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/searchcurdept")
    Page<IBZDepartment> searchCurDept(@RequestBody IBZDepartmentSearchContext context);



    @RequestMapping(method = RequestMethod.POST, value = "/ibzdepartments/searchdefault")
    Page<IBZDepartment> searchDefault(@RequestBody IBZDepartmentSearchContext context);


}
