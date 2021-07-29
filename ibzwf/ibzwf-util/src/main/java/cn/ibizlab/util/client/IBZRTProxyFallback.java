package cn.ibizlab.util.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class IBZRTProxyFallback implements IBZRTProxyFeignClient {


	@Override
	public String getDynaModelId(String orgId, String systemId) {
		return null;
	}

	@Override
	public String getDynaModelId(String module, String moduleTag, String orgId, String systemId) {
		return null;
	}
}
