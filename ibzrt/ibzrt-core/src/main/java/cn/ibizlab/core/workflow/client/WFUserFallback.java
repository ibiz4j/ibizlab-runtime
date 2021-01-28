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
import cn.ibizlab.core.workflow.domain.WFUser;
import cn.ibizlab.core.workflow.filter.WFUserSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[WFUser] 服务对象接口
 */
@Component
public class WFUserFallback implements WFUserFeignClient {

    public Page<WFUser> select() {
        return null;
    }

    public WFUser create(WFUser wfuser) {
        return null;
    }
    public Boolean createBatch(List<WFUser> wfusers) {
        return false;
    }

    public WFUser update(String id, WFUser wfuser) {
        return null;
    }
    public Boolean updateBatch(List<WFUser> wfusers) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public WFUser get(String id) {
        return null;
    }


    public WFUser getDraft(WFUser entity){
        return null;
    }



    public Boolean checkKey(WFUser wfuser) {
        return false;
    }


    public Boolean save(WFUser wfuser) {
        return false;
    }
    public Boolean saveBatch(List<WFUser> wfusers) {
        return false;
    }

    public Page<WFUser> searchDefault(WFUserSearchContext context) {
        return null;
    }


}
