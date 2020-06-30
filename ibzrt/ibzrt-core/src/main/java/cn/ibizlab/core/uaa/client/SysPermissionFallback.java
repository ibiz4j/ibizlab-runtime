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
import cn.ibizlab.core.uaa.domain.SysPermission;
import cn.ibizlab.core.uaa.filter.SysPermissionSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysPermission] 服务对象接口
 */
@Component
public class SysPermissionFallback implements SysPermissionFeignClient{

    public Page<SysPermission> select(){
            return null;
     }

    public SysPermission create(SysPermission syspermission){
            return null;
     }
    public Boolean createBatch(List<SysPermission> syspermissions){
            return false;
     }

    public SysPermission update(String permissionid, SysPermission syspermission){
            return null;
     }
    public Boolean updateBatch(List<SysPermission> syspermissions){
            return false;
     }


    public Boolean remove(String permissionid){
            return false;
     }
    public Boolean removeBatch(Collection<String> idList){
            return false;
     }

    public SysPermission get(String permissionid){
            return null;
     }


    public SysPermission getDraft(){
            return null;
    }



    public Boolean checkKey(SysPermission syspermission){
            return false;
     }


    public Boolean save(SysPermission syspermission){
            return false;
     }
    public Boolean saveBatch(List<SysPermission> syspermissions){
            return false;
     }

    public Page<SysPermission> searchDefault(SysPermissionSearchContext context){
            return null;
     }


}
