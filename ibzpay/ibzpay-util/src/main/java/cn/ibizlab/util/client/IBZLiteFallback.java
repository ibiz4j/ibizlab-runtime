package cn.ibizlab.util.client;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Map;

@Component
public class IBZLiteFallback implements IBZLiteFeignClient {

	@Override
	public Boolean syncSysModel(JSONObject system) {
		return null;
	}

}
