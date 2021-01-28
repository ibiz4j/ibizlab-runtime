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
import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysRole] 服务对象接口
 */
@Component
public class SysRoleFallback implements SysRoleFeignClient {

    public Page<SysRole> select() {
        return null;
    }

    public SysRole create(SysRole sysrole) {
        return null;
    }
    public Boolean createBatch(List<SysRole> sysroles) {
        return false;
    }

    public SysRole update(String roleid, SysRole sysrole) {
        return null;
    }
    public Boolean updateBatch(List<SysRole> sysroles) {
        return false;
    }


    public Boolean remove(String roleid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysRole get(String roleid) {
        return null;
    }


    public SysRole getDraft(SysRole entity){
        return null;
    }



    public Boolean checkKey(SysRole sysrole) {
        return false;
    }


    public Boolean save(SysRole sysrole) {
        return false;
    }
    public Boolean saveBatch(List<SysRole> sysroles) {
        return false;
    }

    public Page<SysRole> searchDefault(SysRoleSearchContext context) {
        return null;
    }


}
