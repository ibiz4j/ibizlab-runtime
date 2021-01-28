package cn.ibizlab.util.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@FeignClient(value = "${ibiz.ref.service.lite:ibzlite-api}",contextId = "lite",fallback = IBZLiteFallback.class)
public interface IBZLiteFeignClient
{
	/**
	 * 同步系统资模型到lite
	 * @param system 系统模型信息
	 * @return
	 */
	@PostMapping("/lite/syncsysmodel")
	Boolean syncSysModel(@RequestBody JSONObject system);

}
