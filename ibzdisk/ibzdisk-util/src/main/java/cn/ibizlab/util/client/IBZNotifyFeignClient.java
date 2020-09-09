package cn.ibizlab.util.client;

import cn.ibizlab.util.domain.MsgBody;
import com.alibaba.fastjson.JSONObject;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(value = "${ibiz.ref.service.notify:ibznotify-api}",contextId = "notify",fallback = IBZNotifyFallback.class)
public interface IBZNotifyFeignClient
{
	@RequestMapping(method = RequestMethod.POST,value = "/notify/sendmsg")
	Boolean sendMsg(@RequestBody MsgBody msg);

	@RequestMapping(method = RequestMethod.POST,value = "/notify/createmsgtempl")
	Boolean createMsgTemplate(@RequestBody JSONObject template);

	@RequestMapping(method = RequestMethod.POST,value = "/notify/dingtalk/sendlinkmsg")
	Boolean sendDingTalkLinkMsg(@RequestBody MsgBody msg);

	@RequestMapping(method = RequestMethod.POST,value = "/notify/dingtalk/createworkrecord")
	String createDingTalkWorkRecord(@RequestBody MsgBody msg);

	@RequestMapping(method = RequestMethod.POST,value = "/notify/dingtalk/finishworkrecord/{msgid}")
	Boolean finishDingTalkWorkRecord(@PathVariable("msgid") String msgId);
}
