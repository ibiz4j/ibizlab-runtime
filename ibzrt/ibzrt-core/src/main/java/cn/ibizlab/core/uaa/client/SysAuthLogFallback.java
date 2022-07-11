package cn.ibizlab.core.uaa.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.uaa.domain.SysAuthLog;
import cn.ibizlab.core.uaa.filter.SysAuthLogSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysAuthLog] 服务对象接口
 */
@Component
public class SysAuthLogFallback implements SysAuthLogFeignClient {

    public SysAuthLog create(SysAuthLog sysauthlog) {
        return null;
    }
    public Boolean createBatch(List<SysAuthLog> sysauthlogs) {
        return false;
    }

    public SysAuthLog get(String logid) {
        return null;
    }


    public Boolean remove(String logid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysAuthLog update(String logid, SysAuthLog sysauthlog) {
        return null;
    }
    public Boolean updateBatch(List<SysAuthLog> sysauthlogs) {
        return false;
    }


    public Boolean checkKey(SysAuthLog sysauthlog) {
        return false;
    }


    public Page<SysAuthLog> searchDefault(SysAuthLogSearchContext context) {
        return null;
    }


    public SysAuthLog getDraft(SysAuthLog entity){
        return null;
    }



    public Object saveEntity(SysAuthLog sysauthlog) {
        return null;
    }

    public Boolean save(SysAuthLog sysauthlog) {
        return false;
    }
    public Boolean saveBatch(List<SysAuthLog> sysauthlogs) {
        return false;
    }

    public Page<SysAuthLog> select() {
        return null;
    }

}
