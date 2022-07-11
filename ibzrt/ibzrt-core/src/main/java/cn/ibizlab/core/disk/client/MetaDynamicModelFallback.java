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
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.filter.MetaDynamicModelSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[MetaDynamicModel] 服务对象接口
 */
@Component
public class MetaDynamicModelFallback implements MetaDynamicModelFeignClient {

    public MetaDynamicModel create(MetaDynamicModel metadynamicmodel) {
        return null;
    }
    public Boolean createBatch(List<MetaDynamicModel> metadynamicmodels) {
        return false;
    }

    public MetaDynamicModel get(String configid) {
        return null;
    }


    public Boolean remove(String configid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public MetaDynamicModel update(String configid, MetaDynamicModel metadynamicmodel) {
        return null;
    }
    public Boolean updateBatch(List<MetaDynamicModel> metadynamicmodels) {
        return false;
    }


    public Boolean checkKey(MetaDynamicModel metadynamicmodel) {
        return false;
    }


    public Page<MetaDynamicModel> searchDefault(MetaDynamicModelSearchContext context) {
        return null;
    }


    public Page<MetaDynamicModel> searchDynaInst(MetaDynamicModelSearchContext context) {
        return null;
    }


    public MetaDynamicModel getDraft(MetaDynamicModel entity){
        return null;
    }



    public MetaDynamicModel init( String configid, MetaDynamicModel metadynamicmodel) {
        return null;
    }

    public MetaDynamicModel publish( String configid, MetaDynamicModel metadynamicmodel) {
        return null;
    }

    public Object saveEntity(MetaDynamicModel metadynamicmodel) {
        return null;
    }

    public Boolean save(MetaDynamicModel metadynamicmodel) {
        return false;
    }
    public Boolean saveBatch(List<MetaDynamicModel> metadynamicmodels) {
        return false;
    }

    public Page<MetaDynamicModel> select() {
        return null;
    }

}
