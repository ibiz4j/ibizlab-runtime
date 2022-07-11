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
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysPSSystem] 服务对象接口
 */
@Component
public class SysPSSystemFallback implements SysPSSystemFeignClient {

    public SysPSSystem create(SysPSSystem syspssystem) {
        return null;
    }
    public Boolean createBatch(List<SysPSSystem> syspssystems) {
        return false;
    }

    public SysPSSystem get(String pssystemid) {
        return null;
    }


    public Boolean remove(String pssystemid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysPSSystem update(String pssystemid, SysPSSystem syspssystem) {
        return null;
    }
    public Boolean updateBatch(List<SysPSSystem> syspssystems) {
        return false;
    }


    public Boolean checkKey(SysPSSystem syspssystem) {
        return false;
    }


    public Page<SysPSSystem> searchDefault(SysPSSystemSearchContext context) {
        return null;
    }


    public Page<SysPSSystem> searchPick(SysPSSystemSearchContext context) {
        return null;
    }


    public SysPSSystem getDraft(SysPSSystem entity){
        return null;
    }



    public Object saveEntity(SysPSSystem syspssystem) {
        return null;
    }

    public Boolean save(SysPSSystem syspssystem) {
        return false;
    }
    public Boolean saveBatch(List<SysPSSystem> syspssystems) {
        return false;
    }

    public Page<SysPSSystem> select() {
        return null;
    }

}
