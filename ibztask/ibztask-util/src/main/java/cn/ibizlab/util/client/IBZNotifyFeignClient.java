package cn.ibizlab.util.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "${ibiz.ref.service.notify:ibznotify-api}",fallback = IBZNotifyFallback.class)
public interface IBZNotifyFeignClient
{
	@RequestMapping(method = RequestMethod.POST,value = "/SendMsg")
	Boolean SendMsg(@RequestBody JSONObject msg);

	@RequestMapping(method = RequestMethod.POST,value = "/createMsgTemplate")
	Boolean createMsgTemplate(@RequestBody JSONObject template);
}
