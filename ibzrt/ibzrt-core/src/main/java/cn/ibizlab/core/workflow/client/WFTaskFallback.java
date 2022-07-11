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
import cn.ibizlab.core.workflow.domain.WFTask;
import cn.ibizlab.core.workflow.filter.WFTaskSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFTask] 服务对象接口
 */
@Component
public class WFTaskFallback implements WFTaskFeignClient {

    public WFTask create(WFTask wftask) {
        return null;
    }
    public Boolean createBatch(List<WFTask> wftasks) {
        return false;
    }

    public WFTask get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFTask update(String id, WFTask wftask) {
        return null;
    }
    public Boolean updateBatch(List<WFTask> wftasks) {
        return false;
    }


    public Boolean checkKey(WFTask wftask) {
        return false;
    }


    public Page<WFTask> searchDefault(WFTaskSearchContext context) {
        return null;
    }


    public WFTask getDraft(WFTask entity){
        return null;
    }



    public Object saveEntity(WFTask wftask) {
        return null;
    }

    public Boolean save(WFTask wftask) {
        return false;
    }
    public Boolean saveBatch(List<WFTask> wftasks) {
        return false;
    }

    public Page<WFTask> select() {
        return null;
    }

}
