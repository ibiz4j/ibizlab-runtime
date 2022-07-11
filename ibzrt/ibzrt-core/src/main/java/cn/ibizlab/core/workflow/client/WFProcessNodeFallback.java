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
import cn.ibizlab.core.workflow.domain.WFProcessNode;
import cn.ibizlab.core.workflow.filter.WFProcessNodeSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFProcessNode] 服务对象接口
 */
@Component
public class WFProcessNodeFallback implements WFProcessNodeFeignClient {

    public WFProcessNode create(WFProcessNode wfprocessnode) {
        return null;
    }
    public Boolean createBatch(List<WFProcessNode> wfprocessnodes) {
        return false;
    }

    public WFProcessNode get(String usertaskid) {
        return null;
    }


    public Boolean remove(String usertaskid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFProcessNode update(String usertaskid, WFProcessNode wfprocessnode) {
        return null;
    }
    public Boolean updateBatch(List<WFProcessNode> wfprocessnodes) {
        return false;
    }


    public Boolean checkKey(WFProcessNode wfprocessnode) {
        return false;
    }


    public Page<WFProcessNode> searchDefault(WFProcessNodeSearchContext context) {
        return null;
    }


    public WFProcessNode getDraft(WFProcessNode entity){
        return null;
    }



    public Object saveEntity(WFProcessNode wfprocessnode) {
        return null;
    }

    public Boolean save(WFProcessNode wfprocessnode) {
        return false;
    }
    public Boolean saveBatch(List<WFProcessNode> wfprocessnodes) {
        return false;
    }

    public Page<WFProcessNode> select() {
        return null;
    }

}
