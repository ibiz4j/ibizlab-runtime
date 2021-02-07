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
import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.filter.SysOpenAccessSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysOpenAccess] 服务对象接口
 */
@Component
public class SysOpenAccessFallback implements SysOpenAccessFeignClient {

    public Page<SysOpenAccess> select() {
        return null;
    }

    public SysOpenAccess create(SysOpenAccess sysopenaccess) {
        return null;
    }
    public Boolean createBatch(List<SysOpenAccess> sysopenaccesses) {
        return false;
    }

    public SysOpenAccess update(String id, SysOpenAccess sysopenaccess) {
        return null;
    }
    public Boolean updateBatch(List<SysOpenAccess> sysopenaccesses) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysOpenAccess get(String id) {
        return null;
    }


    public SysOpenAccess getDraft(SysOpenAccess entity){
        return null;
    }



    public Boolean checkKey(SysOpenAccess sysopenaccess) {
        return false;
    }


    public Object saveEntity(SysOpenAccess sysopenaccess) {
        return null;
    }

    public Boolean save(SysOpenAccess sysopenaccess) {
        return false;
    }
    public Boolean saveBatch(List<SysOpenAccess> sysopenaccesses) {
        return false;
    }

    public Page<SysOpenAccess> searchDefault(SysOpenAccessSearchContext context) {
        return null;
    }


}
