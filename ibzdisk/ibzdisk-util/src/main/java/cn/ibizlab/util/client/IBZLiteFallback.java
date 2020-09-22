package cn.ibizlab.util.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class IBZLiteFallback implements IBZLiteFeignClient {

	@Override
	public Boolean syncSysModel(JSONObject system) {
		return null;
	}
}
