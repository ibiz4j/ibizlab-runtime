package cn.ibizlab.core.notify.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[MsgBody] 服务对象接口
 */
@Component
public class MsgBodyFallback implements MsgBodyFeignClient {

    public Page<MsgBody> select() {
        return null;
    }

    public MsgBody create(MsgBody msgbody) {
        return null;
    }
    public Boolean createBatch(List<MsgBody> msgbodies) {
        return false;
    }

    public MsgBody update(String msg_id, MsgBody msgbody) {
        return null;
    }
    public Boolean updateBatch(List<MsgBody> msgbodies) {
        return false;
    }


    public Boolean remove(String msg_id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public MsgBody get(String msg_id) {
        return null;
    }


    public MsgBody getDraft(MsgBody entity){
        return null;
    }



    public Boolean checkKey(MsgBody msgbody) {
        return false;
    }


    public Object saveEntity(MsgBody msgbody) {
        return null;
    }

    public Boolean save(MsgBody msgbody) {
        return false;
    }
    public Boolean saveBatch(List<MsgBody> msgbodies) {
        return false;
    }

    public Page<MsgBody> searchDefault(MsgBodySearchContext context) {
        return null;
    }


}
