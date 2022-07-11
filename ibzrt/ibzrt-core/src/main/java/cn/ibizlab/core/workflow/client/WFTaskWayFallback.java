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
import cn.ibizlab.core.workflow.domain.WFTaskWay;
import cn.ibizlab.core.workflow.filter.WFTaskWaySearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFTaskWay] 服务对象接口
 */
@Component
public class WFTaskWayFallback implements WFTaskWayFeignClient {

    public WFTaskWay create(WFTaskWay wftaskway) {
        return null;
    }
    public Boolean createBatch(List<WFTaskWay> wftaskways) {
        return false;
    }

    public WFTaskWay get(String sequenceflowid) {
        return null;
    }


    public Boolean remove(String sequenceflowid) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFTaskWay update(String sequenceflowid, WFTaskWay wftaskway) {
        return null;
    }
    public Boolean updateBatch(List<WFTaskWay> wftaskways) {
        return false;
    }


    public Boolean checkKey(WFTaskWay wftaskway) {
        return false;
    }


    public Page<WFTaskWay> searchDefault(WFTaskWaySearchContext context) {
        return null;
    }


    public WFTaskWay getDraft(WFTaskWay entity){
        return null;
    }



    public Object saveEntity(WFTaskWay wftaskway) {
        return null;
    }

    public Boolean save(WFTaskWay wftaskway) {
        return false;
    }
    public Boolean saveBatch(List<WFTaskWay> wftaskways) {
        return false;
    }

    public Page<WFTaskWay> select() {
        return null;
    }

}
