package cn.ibizlab.util.client;

import cn.ibizlab.util.domain.PayTrade;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "${ibiz.ref.service.pay:ibzpay-api}",contextId = "pay",fallback = IBZPayFallback.class)
public interface IBZPayFeignClient
{
	@RequestMapping(method = RequestMethod.POST,value = "/pay/trade/precreate")
	JSONObject preCreate(@RequestBody PayTrade trade);

	@RequestMapping(method = RequestMethod.POST,value = "/pay/trade/query")
	JSONObject query(@RequestBody PayTrade trade);

	@RequestMapping(method = RequestMethod.POST,value = "/pay/trade/cancel")
	JSONObject cancel(@RequestBody PayTrade trade);

	@RequestMapping(method = RequestMethod.POST,value = "/pay/trade/pagepay")
	String pagePay(@RequestBody PayTrade trade);
}
