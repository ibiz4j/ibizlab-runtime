package cn.ibizlab.core.extensions.helper;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiMessageCorpconversationAsyncsendV2Request;
import com.dingtalk.api.request.OapiWorkrecordAddRequest;
import com.dingtalk.api.request.OapiWorkrecordUpdateRequest;
import com.dingtalk.api.response.OapiMessageCorpconversationAsyncsendV2Response;
import com.dingtalk.api.response.OapiWorkrecordAddResponse;
import com.dingtalk.api.response.OapiWorkrecordUpdateResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 钉钉api辅助类
 */
public class DingTalkHelper {
    /**
     * 钉钉获取token api
     */
    private static final String dingTalkTokenApi="https://oapi.dingtalk.com/gettoken";
    /**
     * 钉钉发送消息api
     */
    private static final String dingTalkSendMsgApi="https://oapi.dingtalk.com/topapi/message/corpconversation/asyncsend_v2";
    /**
     * 钉钉创建待办api
     */
    private static final String dingTalkCreateWorkRecordApi="https://oapi.dingtalk.com/topapi/workrecord/add";
    /**
     * 钉钉完成待办api
     */
    private static final String dingTalkFinishWorkRecordApi="https://oapi.dingtalk.com/topapi/workrecord/update";

    private static DingTalkClient sendMsgClient;
    private static DingTalkClient createWorkRecordClient;
    private static DingTalkClient finishWorkRecordClient;
    private static DingTalkClient getTokenClient;
    static {
        getTokenClient = new DefaultDingTalkClient(dingTalkTokenApi);
        sendMsgClient = new DefaultDingTalkClient(dingTalkSendMsgApi);
        createWorkRecordClient=new DefaultDingTalkClient(dingTalkCreateWorkRecordApi);
        finishWorkRecordClient = new DefaultDingTalkClient(dingTalkFinishWorkRecordApi);
    }

    /**
     * 发送工作消息通知
     * @param agentId
     * @param users
     * @param content
     * @param accessToken
     */
    public static String sendWorkNotifyMsg(Long agentId,String users,String content,String accessToken) throws Exception{
        OapiMessageCorpconversationAsyncsendV2Request req = new OapiMessageCorpconversationAsyncsendV2Request();
        req.setAgentId(agentId);
        req.setUseridList(users);
        OapiMessageCorpconversationAsyncsendV2Request.Msg dingtalkMsg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        dingtalkMsg.setMsgtype("text");
        OapiMessageCorpconversationAsyncsendV2Request.Text obj2 = new OapiMessageCorpconversationAsyncsendV2Request.Text();
        obj2.setContent(content);
        dingtalkMsg.setText(obj2);
        req.setMsg(dingtalkMsg);
        OapiMessageCorpconversationAsyncsendV2Response rsp = sendMsgClient.execute(req, accessToken);
        return rsp.getBody();
    }

    /**
     * 发送链接消息
     * @param agentId
     * @param users
     * @param title
     * @param content
     * @param msgUrl
     * @param accessToken
     * @return
     */
    public static String sendLinkMsg(Long agentId,String users,String title , String content,String msgUrl,String picUrl,String accessToken)throws Exception {
        OapiMessageCorpconversationAsyncsendV2Request req = new OapiMessageCorpconversationAsyncsendV2Request();
        req.setAgentId(agentId);
        req.setUseridList(users);
        OapiMessageCorpconversationAsyncsendV2Request.Msg dingTalkMsg = new OapiMessageCorpconversationAsyncsendV2Request.Msg();
        dingTalkMsg.setMsgtype("link");
        dingTalkMsg.setLink(new OapiMessageCorpconversationAsyncsendV2Request.Link());
        dingTalkMsg.getLink().setTitle(title);
        dingTalkMsg.getLink().setText(content);
        dingTalkMsg.getLink().setMessageUrl(msgUrl);
        dingTalkMsg.getLink().setPicUrl(msgUrl);
        req.setMsg(dingTalkMsg);
        OapiMessageCorpconversationAsyncsendV2Response rsp= sendMsgClient.execute(req, accessToken);
        return rsp.getBody();
    }

    /**
     * 创建待办
     * @param user
     * @param title
     * @param content
     * @param msgUrl
     * @param pcUrl
     * @param accessToken
     * @return
     */
    public static OapiWorkrecordAddResponse createWorkRecord(String user, String title , String content, String msgUrl, String pcUrl, String accessToken) throws Exception{
        OapiWorkrecordAddRequest req = new OapiWorkrecordAddRequest();
        req.setUserid(user);
        req.setCreateTime(new Date().getTime());
        req.setTitle(title);
        req.setUrl(msgUrl);
        req.setPcUrl(pcUrl);
        List<OapiWorkrecordAddRequest.FormItemVo> list2 = new ArrayList<>();
        OapiWorkrecordAddRequest.FormItemVo obj3 = new OapiWorkrecordAddRequest.FormItemVo();
        list2.add(obj3);
        obj3.setTitle(title);
        obj3.setContent(content);
        req.setFormItemList(list2);
        OapiWorkrecordAddResponse rsp = createWorkRecordClient.execute(req, accessToken);
        return rsp;
    }

    /**
     * 完成待办
     * @param user
     * @param recordId
     * @param accessToken
     * @return
     */
    public static String finishWorkRecord(String user,String recordId,String accessToken) throws Exception{
        OapiWorkrecordUpdateRequest req = new OapiWorkrecordUpdateRequest();
        req.setUserid(user);
        req.setRecordId(recordId);
        OapiWorkrecordUpdateResponse rsp = finishWorkRecordClient.execute(req, accessToken);
        return rsp.getBody();
    }

}
