package cn.ibizlab.core.dict.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.dict.domain.DictCatalog;
import cn.ibizlab.core.dict.filter.DictCatalogSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[DictCatalog] 服务对象接口
 */
@Component
public class DictCatalogFallback implements DictCatalogFeignClient {

    public Page<DictCatalog> select() {
        return null;
    }

    public DictCatalog create(DictCatalog dictcatalog) {
        return null;
    }
    public Boolean createBatch(List<DictCatalog> dictcatalogs) {
        return false;
    }

    public DictCatalog update(String id, DictCatalog dictcatalog) {
        return null;
    }
    public Boolean updateBatch(List<DictCatalog> dictcatalogs) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public DictCatalog get(String id) {
        return null;
    }


    public DictCatalog getDraft(){
        return null;
    }



    public Boolean checkKey(DictCatalog dictcatalog) {
        return false;
    }


    public Boolean save(DictCatalog dictcatalog) {
        return false;
    }
    public Boolean saveBatch(List<DictCatalog> dictcatalogs) {
        return false;
    }

    public Page<DictCatalog> searchDefault(DictCatalogSearchContext context) {
        return null;
    }


}
