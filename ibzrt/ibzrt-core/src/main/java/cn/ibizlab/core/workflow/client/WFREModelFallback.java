package cn.ibizlab.core.workflow.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.workflow.domain.WFREModel;
import cn.ibizlab.core.workflow.filter.WFREModelSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFREModel] 服务对象接口
 */
@Component
public class WFREModelFallback implements WFREModelFeignClient {

    public WFREModel create(WFREModel wfremodel) {
        return null;
    }
    public Boolean createBatch(List<WFREModel> wfremodels) {
        return false;
    }

    public WFREModel get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFREModel update(String id, WFREModel wfremodel) {
        return null;
    }
    public Boolean updateBatch(List<WFREModel> wfremodels) {
        return false;
    }


    public Boolean checkKey(WFREModel wfremodel) {
        return false;
    }


    public Page<WFREModel> searchDefault(WFREModelSearchContext context) {
        return null;
    }


    public WFREModel getDraft(WFREModel entity){
        return null;
    }



    public Object saveEntity(WFREModel wfremodel) {
        return null;
    }

    public Boolean save(WFREModel wfremodel) {
        return false;
    }
    public Boolean saveBatch(List<WFREModel> wfremodels) {
        return false;
    }

    public Page<WFREModel> select() {
        return null;
    }

}
