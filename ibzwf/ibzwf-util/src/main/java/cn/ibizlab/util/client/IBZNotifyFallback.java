package cn.ibizlab.util.client;

import cn.ibizlab.util.domain.MsgBody;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;

@Component
public class IBZNotifyFallback implements IBZNotifyFeignClient {

	@Override
	public Boolean sendMsg(MsgBody msg) {
		return null;
	}

	@Override
	public Boolean createMsgTemplate(JSONObject template) {
		return null;
	}

	@Override
	public Boolean sendDingTalkLinkMsg(MsgBody msg) {
		return null;
	}

	@Override
	public String createDingTalkWorkRecord(MsgBody msg) {
		return null;
	}

	@Override
	public Boolean finishDingTalkWorkRecord(String msgId) {
		return null;
	}
}
