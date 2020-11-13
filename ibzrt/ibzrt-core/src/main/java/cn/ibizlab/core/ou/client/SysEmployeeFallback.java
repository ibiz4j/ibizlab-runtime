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
import cn.ibizlab.core.ou.domain.SysEmployee;
import cn.ibizlab.core.ou.filter.SysEmployeeSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysEmployee] 服务对象接口
 */
@Component
public class SysEmployeeFallback implements SysEmployeeFeignClient {

    public Page<SysEmployee> select() {
        return null;
    }

    public SysEmployee create(SysEmployee sysemployee) {
        return null;
    }
    public Boolean createBatch(List<SysEmployee> sysemployees) {
        return false;
    }

    public SysEmployee update(String userid, SysEmployee sysemployee) {
        return null;
    }
    public Boolean updateBatch(List<SysEmployee> sysemployees) {
        return false;
    }


    public Boolean remove(String userid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysEmployee get(String userid) {
        return null;
    }


    public SysEmployee getDraft(){
        return null;
    }



    public Boolean checkKey(SysEmployee sysemployee) {
        return false;
    }


    public SysEmployee initPwd( String userid, SysEmployee sysemployee) {
        return null;
    }

    public Boolean save(SysEmployee sysemployee) {
        return false;
    }
    public Boolean saveBatch(List<SysEmployee> sysemployees) {
        return false;
    }

    public Page<SysEmployee> searchDefault(SysEmployeeSearchContext context) {
        return null;
    }


}
