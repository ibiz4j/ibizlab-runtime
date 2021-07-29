package cn.ibizlab.util.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "${ibiz.ref.service.rt:ibizrt4ebsx}" ,contextId = "rt" , fallback = IBZRTProxyFallback.class)
public interface IBZRTProxyFeignClient
{

	@GetMapping("/uaa/dynamodel")
	String getDynaModelId(@RequestHeader("srforgid") String orgId , @RequestHeader("srfsystemid") String systemId);

	@GetMapping("/uaa/{module}/{moduletag}/dynamodel")
	String getDynaModelId(@PathVariable("module") String module , @PathVariable("moduletag") String moduleTag , @RequestHeader("srforgid") String orgId , @RequestHeader("srfsystemid") String systemId);

}
