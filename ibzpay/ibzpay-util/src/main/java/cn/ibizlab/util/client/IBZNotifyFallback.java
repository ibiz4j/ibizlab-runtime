package cn.ibizlab.util.client;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class IBZNotifyFallback implements IBZNotifyFeignClient {

	@Override
	public Boolean SendMsg(JSONObject msg) {
		return null;
	}

	@Override
	public Boolean createMsgTemplate(JSONObject template) {
		return null;
	}
}
