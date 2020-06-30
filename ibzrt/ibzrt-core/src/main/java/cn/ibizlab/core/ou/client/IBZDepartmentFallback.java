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
import org.springframework.stereotype.Component;

/**
 * 实体[IBZDepartment] 服务对象接口
 */
@Component
public class IBZDepartmentFallback implements IBZDepartmentFeignClient{

    public Page<IBZDepartment> select(){
            return null;
     }

    public IBZDepartment create(IBZDepartment ibzdepartment){
            return null;
     }
    public Boolean createBatch(List<IBZDepartment> ibzdepartments){
            return false;
     }

    public IBZDepartment update(String deptid, IBZDepartment ibzdepartment){
            return null;
     }
    public Boolean updateBatch(List<IBZDepartment> ibzdepartments){
            return false;
     }


    public Boolean remove(String deptid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public IBZDepartment get(String deptid){
            return null;
     }


    public IBZDepartment getDraft(){
            return null;
    }



    public Boolean checkKey(IBZDepartment ibzdepartment){
            return false;
     }


    public Boolean save(IBZDepartment ibzdepartment){
            return false;
     }
    public Boolean saveBatch(List<IBZDepartment> ibzdepartments){
            return false;
     }

    public Page<IBZDepartment> searchDefault(IBZDepartmentSearchContext context){
            return null;
     }


}
