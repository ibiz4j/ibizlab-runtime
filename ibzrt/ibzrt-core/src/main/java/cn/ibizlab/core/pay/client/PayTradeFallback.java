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
import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.filter.PayTradeSearchContext;
import org.springframework.stereotype.Component;

/**
 * 实体[PayTrade] 服务对象接口
 */
@Component
public class PayTradeFallback implements PayTradeFeignClient {

    public PayTrade create(PayTrade paytrade) {
        return null;
    }
    public Boolean createBatch(List<PayTrade> paytrades) {
        return false;
    }

    public PayTrade get(String trade_id) {
        return null;
    }


    public Boolean remove(String trade_id) {
        return false;
    }
    public Boolean removeBatch(Collection<String> idList) {
        return false;
    }

    public PayTrade update(String trade_id, PayTrade paytrade) {
        return null;
    }
    public Boolean updateBatch(List<PayTrade> paytrades) {
        return false;
    }


    public Boolean checkKey(PayTrade paytrade) {
        return false;
    }


    public Page<PayTrade> searchDefault(PayTradeSearchContext context) {
        return null;
    }


    public PayTrade getDraft(PayTrade entity){
        return null;
    }



    public Object saveEntity(PayTrade paytrade) {
        return null;
    }

    public Boolean save(PayTrade paytrade) {
        return false;
    }
    public Boolean saveBatch(List<PayTrade> paytrades) {
        return false;
    }

    public Page<PayTrade> select() {
        return null;
    }

}
