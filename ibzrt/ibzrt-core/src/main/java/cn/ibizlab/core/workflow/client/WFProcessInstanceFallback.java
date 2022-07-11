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
import cn.ibizlab.core.workflow.domain.WFProcessInstance;
import cn.ibizlab.core.workflow.filter.WFProcessInstanceSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFProcessInstance] 服务对象接口
 */
@Component
public class WFProcessInstanceFallback implements WFProcessInstanceFeignClient {

    public WFProcessInstance create(WFProcessInstance wfprocessinstance) {
        return null;
    }
    public Boolean createBatch(List<WFProcessInstance> wfprocessinstances) {
        return false;
    }

    public WFProcessInstance get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFProcessInstance update(String id, WFProcessInstance wfprocessinstance) {
        return null;
    }
    public Boolean updateBatch(List<WFProcessInstance> wfprocessinstances) {
        return false;
    }


    public Boolean checkKey(WFProcessInstance wfprocessinstance) {
        return false;
    }


    public Page<WFProcessInstance> searchDefault(WFProcessInstanceSearchContext context) {
        return null;
    }


    public WFProcessInstance getDraft(WFProcessInstance entity){
        return null;
    }



    public Object saveEntity(WFProcessInstance wfprocessinstance) {
        return null;
    }

    public Boolean save(WFProcessInstance wfprocessinstance) {
        return false;
    }
    public Boolean saveBatch(List<WFProcessInstance> wfprocessinstances) {
        return false;
    }

    public Page<WFProcessInstance> select() {
        return null;
    }

}
