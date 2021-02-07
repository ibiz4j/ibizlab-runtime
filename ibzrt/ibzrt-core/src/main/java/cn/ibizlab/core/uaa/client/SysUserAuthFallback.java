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
import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.filter.SysUserAuthSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysUserAuth] 服务对象接口
 */
@Component
public class SysUserAuthFallback implements SysUserAuthFeignClient {

    public Page<SysUserAuth> select() {
        return null;
    }

    public SysUserAuth create(SysUserAuth sysuserauth) {
        return null;
    }
    public Boolean createBatch(List<SysUserAuth> sysuserauths) {
        return false;
    }

    public SysUserAuth update(String id, SysUserAuth sysuserauth) {
        return null;
    }
    public Boolean updateBatch(List<SysUserAuth> sysuserauths) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysUserAuth get(String id) {
        return null;
    }


    public SysUserAuth getDraft(SysUserAuth entity){
        return null;
    }



    public Boolean checkKey(SysUserAuth sysuserauth) {
        return false;
    }


    public Object saveEntity(SysUserAuth sysuserauth) {
        return null;
    }

    public Boolean save(SysUserAuth sysuserauth) {
        return false;
    }
    public Boolean saveBatch(List<SysUserAuth> sysuserauths) {
        return false;
    }

    public Page<SysUserAuth> searchDefault(SysUserAuthSearchContext context) {
        return null;
    }


}
