package cn.ibizlab.core.pay.client;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.core.pay.filter.PayOpenAccessSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[PayOpenAccess] 服务对象接口
 */
@Component
public class PayOpenAccessFallback implements PayOpenAccessFeignClient {

    public PayOpenAccess create(PayOpenAccess payopenaccess) {
        return null;
    }
    public Boolean createBatch(List<PayOpenAccess> payopenaccesses) {
        return false;
    }

    public PayOpenAccess get(String id) {
        return null;
    }


    public Boolean remove(String id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public PayOpenAccess update(String id, PayOpenAccess payopenaccess) {
        return null;
    }
    public Boolean updateBatch(List<PayOpenAccess> payopenaccesses) {
        return false;
    }


    public Boolean checkKey(PayOpenAccess payopenaccess) {
        return false;
    }


    public Page<PayOpenAccess> searchDefault(PayOpenAccessSearchContext context) {
        return null;
    }


    public PayOpenAccess getDraft(PayOpenAccess entity){
        return null;
    }



    public Object saveEntity(PayOpenAccess payopenaccess) {
        return null;
    }

    public Boolean save(PayOpenAccess payopenaccess) {
        return false;
    }
    public Boolean saveBatch(List<PayOpenAccess> payopenaccesses) {
        return false;
    }

    public Page<PayOpenAccess> select() {
        return null;
    }

}
