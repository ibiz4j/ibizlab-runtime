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
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysApp] 服务对象接口
 */
@Component
public class SysAppFallback implements SysAppFeignClient {

    public SysApp create(SysApp sysapp) {
        return null;
    }
    public Boolean createBatch(List<SysApp> sysapps) {
        return false;
    }

    public SysApp get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysApp update(String id, SysApp sysapp) {
        return null;
    }
    public Boolean updateBatch(List<SysApp> sysapps) {
        return false;
    }


    public Boolean checkKey(SysApp sysapp) {
        return false;
    }


    public Page<SysApp> searchDefault(SysAppSearchContext context) {
        return null;
    }


    public SysApp getDraft(SysApp entity){
        return null;
    }



    public Object saveEntity(SysApp sysapp) {
        return null;
    }

    public Boolean save(SysApp sysapp) {
        return false;
    }
    public Boolean saveBatch(List<SysApp> sysapps) {
        return false;
    }

    public Page<SysApp> select() {
        return null;
    }

}
