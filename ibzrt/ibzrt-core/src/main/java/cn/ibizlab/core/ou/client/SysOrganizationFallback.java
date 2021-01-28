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
import cn.ibizlab.core.ou.domain.SysOrganization;
import cn.ibizlab.core.ou.filter.SysOrganizationSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[SysOrganization] 服务对象接口
 */
@Component
public class SysOrganizationFallback implements SysOrganizationFeignClient {

    public Page<SysOrganization> select() {
        return null;
    }

    public SysOrganization create(SysOrganization sysorganization) {
        return null;
    }
    public Boolean createBatch(List<SysOrganization> sysorganizations) {
        return false;
    }

    public SysOrganization update(String orgid, SysOrganization sysorganization) {
        return null;
    }
    public Boolean updateBatch(List<SysOrganization> sysorganizations) {
        return false;
    }


    public Boolean remove(String orgid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public SysOrganization get(String orgid) {
        return null;
    }


    public SysOrganization getDraft(SysOrganization entity){
        return null;
    }



    public Boolean checkKey(SysOrganization sysorganization) {
        return false;
    }


    public Boolean save(SysOrganization sysorganization) {
        return false;
    }
    public Boolean saveBatch(List<SysOrganization> sysorganizations) {
        return false;
    }

    public Page<SysOrganization> searchDefault(SysOrganizationSearchContext context) {
        return null;
    }


}
