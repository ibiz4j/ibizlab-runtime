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
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysRolePermission] 服务对象接口
 */
@Component
public class SysRolePermissionFallback implements SysRolePermissionFeignClient {

    public Page<SysRolePermission> select() {
        return null;
    }

    public SysRolePermission create(SysRolePermission sysrolepermission) {
        return null;
    }
    public Boolean createBatch(List<SysRolePermission> sysrolepermissions) {
        return false;
    }

    public SysRolePermission update(String rolepermissionid, SysRolePermission sysrolepermission) {
        return null;
    }
    public Boolean updateBatch(List<SysRolePermission> sysrolepermissions) {
        return false;
    }


    public Boolean remove(String rolepermissionid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysRolePermission get(String rolepermissionid) {
        return null;
    }


    public SysRolePermission getDraft(){
        return null;
    }



    public Boolean checkKey(SysRolePermission sysrolepermission) {
        return false;
    }


    public Boolean save(SysRolePermission sysrolepermission) {
        return false;
    }
    public Boolean saveBatch(List<SysRolePermission> sysrolepermissions) {
        return false;
    }

    public Page<SysRolePermission> searchDefault(SysRolePermissionSearchContext context) {
        return null;
    }


}
