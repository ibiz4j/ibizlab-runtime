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
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 实体[PayOpenAccess] 服务对象接口
 */
@FeignClient(value = "${ibiz.ref.service.ibzpay-api:ibzpay-api}", contextId = "PayOpenAccess", fallback = PayOpenAccessFallback.class)
public interface PayOpenAccessFeignClient {

    @RequestMapping(method = RequestMethod.GET, value = "/payopenaccesses/select")
    Page<PayOpenAccess> select();


    @RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses")
    PayOpenAccess create(@RequestBody PayOpenAccess payopenaccess);

    @RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/batch")
    Boolean createBatch(@RequestBody List<PayOpenAccess> payopenaccesses);


    @RequestMapping(method = RequestMethod.PUT, value = "/payopenaccesses/{id}")
    PayOpenAccess update(@PathVariable("id") String id,@RequestBody PayOpenAccess payopenaccess);

    @RequestMapping(method = RequestMethod.PUT, value = "/payopenaccesses/batch")
    Boolean updateBatch(@RequestBody List<PayOpenAccess> payopenaccesses);


    @RequestMapping(method = RequestMethod.DELETE, value = "/payopenaccesses/{id}")
    Boolean remove(@PathVariable("id") String id);

    @RequestMapping(method = RequestMethod.DELETE, value = "/payopenaccesses/batch}")
    Boolean removeBatch(@RequestBody Collection<String> idList);


    @RequestMapping(method = RequestMethod.GET, value = "/payopenaccesses/{id}")
    PayOpenAccess get(@PathVariable("id") String id);


    @RequestMapping(method = RequestMethod.GET, value = "/payopenaccesses/getdraft")
    PayOpenAccess getDraft(PayOpenAccess entity);


    @RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/checkkey")
    Boolean checkKey(@RequestBody PayOpenAccess payopenaccess);


    @RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/save")
    Object saveEntity(@RequestBody PayOpenAccess payopenaccess);

    default Boolean save(@RequestBody PayOpenAccess payopenaccess) { return saveEntity(payopenaccess)!=null; }

    @RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/savebatch")
    Boolean saveBatch(@RequestBody List<PayOpenAccess> payopenaccesses);



    @RequestMapping(method = RequestMethod.POST, value = "/payopenaccesses/searchdefault")
    Page<PayOpenAccess> searchDefault(@RequestBody PayOpenAccessSearchContext context);


}
