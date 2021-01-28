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
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[PayTrade] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzpay-api:ibzpay-api}", contextId = "PayTrade", fallback = PayTradeFallback.class)
public interface PayTradeFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/paytrades/select")
    Page<PayTrade> select();


    @RequestMapping(method = RequestMethod.POST, value = "/paytrades")
    PayTrade create(@RequestBody PayTrade paytrade);

    @RequestMapping(method = RequestMethod.POST, value = "/paytrades/batch")
    Boolean createBatch(@RequestBody List<PayTrade> paytrades);


    @RequestMapping(method = RequestMethod.PUT, value = "/paytrades/{trade_id}")
    PayTrade update(@PathVariable("trade_id") String trade_id,@RequestBody PayTrade paytrade);

    @RequestMapping(method = RequestMethod.PUT, value = "/paytrades/batch")
    Boolean updateBatch(@RequestBody List<PayTrade> paytrades);


    @RequestMapping(method = RequestMethod.DELETE, value = "/paytrades/{trade_id}")
    Boolean remove(@PathVariable("trade_id") String trade_id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/paytrades/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/paytrades/{trade_id}")
    PayTrade get(@PathVariable("trade_id") String trade_id);


    @RequestMapping(method = RequestMethod.GET, value = "/paytrades/getdraft")
    PayTrade getDraft(PayTrade entity);


    @RequestMapping(method = RequestMethod.POST, value = "/paytrades/checkkey")
    Boolean checkKey(@RequestBody PayTrade paytrade);


    @RequestMapping(method = RequestMethod.POST, value = "/paytrades/save")
    Boolean save(@RequestBody PayTrade paytrade);

    @RequestMapping(method = RequestMethod.POST, value = "/paytrades/savebatch")
    Boolean saveBatch(@RequestBody List<PayTrade> paytrades);



    @RequestMapping(method = RequestMethod.POST, value = "/paytrades/searchdefault")
    Page<PayTrade> searchDefault(@RequestBody PayTradeSearchContext context);


}
