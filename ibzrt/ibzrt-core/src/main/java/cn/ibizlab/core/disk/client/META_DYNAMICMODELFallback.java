package cn.ibizlab.core.disk.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.disk.domain.META_DYNAMICMODEL;
import cn.ibizlab.core.disk.filter.META_DYNAMICMODELSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[META_DYNAMICMODEL] 服务对象接口
 */
@Component
public class META_DYNAMICMODELFallback implements META_DYNAMICMODELFeignClient {

    public Page<META_DYNAMICMODEL> select() {
        return null;
    }

    public META_DYNAMICMODEL create(META_DYNAMICMODEL meta_dynamicmodel) {
        return null;
    }
    public Boolean createBatch(List<META_DYNAMICMODEL> meta_dynamicmodels) {
        return false;
    }

    public META_DYNAMICMODEL update(String configid, META_DYNAMICMODEL meta_dynamicmodel) {
        return null;
    }
    public Boolean updateBatch(List<META_DYNAMICMODEL> meta_dynamicmodels) {
        return false;
    }


    public Boolean remove(String configid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public META_DYNAMICMODEL get(String configid) {
        return null;
    }


    public META_DYNAMICMODEL getDraft(META_DYNAMICMODEL entity){
        return null;
    }



    public Boolean checkKey(META_DYNAMICMODEL meta_dynamicmodel) {
        return false;
    }


    public META_DYNAMICMODEL init( String configid, META_DYNAMICMODEL meta_dynamicmodel) {
        return null;
    }

    public META_DYNAMICMODEL publish( String configid, META_DYNAMICMODEL meta_dynamicmodel) {
        return null;
    }

    public Object saveEntity(META_DYNAMICMODEL meta_dynamicmodel) {
        return null;
    }

    public Boolean save(META_DYNAMICMODEL meta_dynamicmodel) {
        return false;
    }
    public Boolean saveBatch(List<META_DYNAMICMODEL> meta_dynamicmodels) {
        return false;
    }

    public Page<META_DYNAMICMODEL> searchDefault(META_DYNAMICMODELSearchContext context) {
        return null;
    }


    public Page<META_DYNAMICMODEL> searchDynaInst(META_DYNAMICMODELSearchContext context) {
        return null;
    }


}
