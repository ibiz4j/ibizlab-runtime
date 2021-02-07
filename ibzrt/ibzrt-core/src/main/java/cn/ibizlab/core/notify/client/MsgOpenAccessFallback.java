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
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.filter.MsgOpenAccessSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[MsgOpenAccess] 服务对象接口
 */
@Component
public class MsgOpenAccessFallback implements MsgOpenAccessFeignClient {

    public Page<MsgOpenAccess> select() {
        return null;
    }

    public MsgOpenAccess create(MsgOpenAccess msgopenaccess) {
        return null;
    }
    public Boolean createBatch(List<MsgOpenAccess> msgopenaccesses) {
        return false;
    }

    public MsgOpenAccess update(String id, MsgOpenAccess msgopenaccess) {
        return null;
    }
    public Boolean updateBatch(List<MsgOpenAccess> msgopenaccesses) {
        return false;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public MsgOpenAccess get(String id) {
        return null;
    }


    public MsgOpenAccess getDraft(MsgOpenAccess entity){
        return null;
    }



    public Boolean checkKey(MsgOpenAccess msgopenaccess) {
        return false;
    }


    public Object saveEntity(MsgOpenAccess msgopenaccess) {
        return null;
    }

    public Boolean save(MsgOpenAccess msgopenaccess) {
        return false;
    }
    public Boolean saveBatch(List<MsgOpenAccess> msgopenaccesses) {
        return false;
    }

    public Page<MsgOpenAccess> searchDefault(MsgOpenAccessSearchContext context) {
        return null;
    }


}
