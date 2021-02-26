package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.extensions.domain.Template;
import cn.ibizlab.core.extensions.helper.DingTalkHelper;
import cn.ibizlab.core.notify.domain.MsgBody;
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.domain.MsgUserAccount;
import cn.ibizlab.core.notify.filter.MsgBodySearchContext;
import cn.ibizlab.core.notify.service.IMsgBodyService;
import cn.ibizlab.core.notify.service.IMsgOpenAccessService;
import cn.ibizlab.core.notify.service.IMsgTemplateService;
import cn.ibizlab.core.notify.service.IMsgUserAccountService;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dm.model.v20151123.SingleSendMailRequest;
import com.aliyuncs.dm.model.v20151123.SingleSendMailResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiWorkrecordAddResponse;
import com.google.gson.Gson;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class NotifyCoreService {

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
    /**
     * 微信获取token api
     */
    private  final String weChatGetTokenApi="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";
    /**
     * 微信发送消息api
     */
    private  final String weChatSendMsgApi="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=%s";
    /**
     * 阿里短信服务域名
     */
    private static final String aliSmsDomain="dysmsapi.aliyuncs.com";
    /**
     * 阿里短信服务单处理行为
     */
    private static final String aliSendSmsAction="SendSms";
    /**
     * 阿里短信服务单处理行为
     */
    private static final String aliSendSmsVersion="2017-05-25";
    /**
     * 平台消息类型代码表
     */
    private static Map<Integer,String> templateType = new HashMap(){{
        put(2,"aliyun-email");
        put(4,"aliyun-sms");
        put(32,"wechat-msg");
        put(64,"dingtalk-msg");
    }};

    private static DingTalkClient sendMsgClient;
    private static DingTalkClient createWorkRecordClient;
    private static DingTalkClient finishWorkRecordClient;
    private static DingTalkClient getTokenClient;
    private Map<String, List<MsgBody>> msgMap = new ConcurrentHashMap<>();
    static {
        getTokenClient = new DefaultDingTalkClient(dingTalkTokenApi);
        sendMsgClient = new DefaultDingTalkClient(dingTalkSendMsgApi);
        createWorkRecordClient=new DefaultDingTalkClient(dingTalkCreateWorkRecordApi);
        finishWorkRecordClient = new DefaultDingTalkClient(dingTalkFinishWorkRecordApi);
    }

    @Autowired
    @Lazy
    RestTemplate restTemplate;
    @Autowired
    @Lazy
    IMsgOpenAccessService openAccessService;
    @Autowired
    @Lazy
    IMsgTemplateService templateService;
    @Autowired
    @Lazy
    IMsgUserAccountService userAccountService;

    @Autowired
    @Lazy
    NotifyCoreService proxyService;

    @Autowired
    @Lazy
    IMsgBodyService msgBodyService;

    /**
     * 获取钉钉token
     * @param openAccess
     * @return
     */
    @SneakyThrows
    public String getDingTalkToken(MsgOpenAccess openAccess){
        String accessKey=openAccess.getAccessKey();
        String accessSecret=openAccess.getSecretKey();
        OapiGettokenRequest req = new OapiGettokenRequest();
        req.setAppkey(accessKey);
        req.setAppsecret(accessSecret);
        req.setHttpMethod("GET");
        OapiGettokenResponse rsp = getTokenClient.execute(req);
        getResult(rsp.getBody());
        return rsp.getBody();
    }

    /**
     * 获取微信token
     * @param openAccess
     * @return
     */
    public String getWeChatToken(MsgOpenAccess openAccess){
        String accessKey=openAccess.getAccessKey();
        String accessSecret=openAccess.getSecretKey();
        ResponseEntity<String> result = restTemplate.getForEntity(String.format(weChatGetTokenApi,accessKey,accessSecret), String.class);
        getResult(result.getBody());
        return result.getBody();
    }

    /**
     * 设置新token及过期时间
     * @param openAccess
     * @return
     */
    public MsgOpenAccess refreshToken(MsgOpenAccess openAccess){
        String tempToken=null;
        switch (openAccess.getOpenType()){
            case "wechat":
                tempToken=getWeChatToken(openAccess);
                break;
            case "dingtalk":
                tempToken=getDingTalkToken(openAccess);
                break;
        }
        if(!StringUtils.isEmpty(tempToken)){
            JSONObject objToken = JSONObject.parseObject(tempToken);
            if(objToken!=null){
                Calendar calendar =Calendar.getInstance();
                calendar.setTime(new Date());
                calendar.add(Calendar.SECOND,Integer.parseInt(objToken.getString("expires_in")));
                Date date = calendar.getTime();
                openAccess.setAccessToken(objToken.getString("access_token"));
                openAccess.setExpiresTime(new Timestamp(date.getTime()));
            }
        }
        return openAccess;
    }

    /**
     * 发送消息服务
     */
    @Scheduled(fixedRate = 60000)
    public void sendMsgService() {
        List<MsgBody> msgList=msgBodyService.list(Wrappers.<MsgBody>lambdaQuery().eq(MsgBody::getIsSend,0).eq(MsgBody::getIsError,0));
        List<MsgBody> dingtalk=new ArrayList<>();
        List<MsgBody> wechat=new ArrayList<>();
        List<MsgBody> email=new ArrayList<>();
        List<MsgBody> sms=new ArrayList<>();
        List<MsgBody> dingtalk_link=new ArrayList<>();
        List<MsgBody> dingtalk_workRecord=new ArrayList<>();
        for(MsgBody msg: msgList){
            switch(msg.getMsgType()){
                case 2:
                    email.add(msg);
                    break;
                case 4:
                    sms.add(msg);
                    break;
                case 32:
                    wechat.add(msg);
                    break;
                case 64:
                    dingtalk.add(msg);
                    break;
                case 65:
                    dingtalk_link.add(msg);
                    break;
                case 66:
                    dingtalk_workRecord.add(msg);
                    break;
            }
        }
        for(MsgBody msg : email){
            aliEMailService(msg);
        }
        for(MsgBody msg : sms){
            aliSmsService(msg);
        }
        for(MsgBody msg : wechat){
            weChatMsgService(msg);
        }
        for(MsgBody msg : dingtalk){
            dingTalkMsgService(msg);
        }
        for(MsgBody msg : dingtalk_link){
            dingTalkLinkMsgService(msg);
        }
        for(MsgBody msg : dingtalk_workRecord){
            dingTalkWorkRecordService(msg);
        }
    }

    /**
     * 发送钉钉消息
     * @param msg
     */
    private void dingTalkMsgService(MsgBody msg){
        try {
            String msgUsers=getMsgUsers(msg);
            MsgTemplate template=templateService.getById(msg.getTemplateId());
            MsgOpenAccess openAccess =template.getOpenaccess();
            String result = DingTalkHelper.sendWorkNotifyMsg(openAccess.getAgentId(),msgUsers,msg.getContent(),openAccess.getAccessToken());
            saveCallResult(msg,result);
        } catch (Exception e) {
            log.error("发送[{}]消息失败，失败原因为：[{}]",msg.getMsgId(),e);
            saveErrorResult(msg,e.getMessage());
        }
    }

    /**
     * 发送钉钉链接消息
     * @return
     */
    public void dingTalkLinkMsgService(MsgBody msg){
        try {
            String msgUsers=getMsgUsers(msg);
            MsgTemplate template=getTempLate(msg.getTemplateId());
            MsgOpenAccess openAccess =getOpenAccess(template.getAccessId());
            String result =DingTalkHelper.sendLinkMsg(openAccess.getAgentId(),msgUsers,msg.getSubject(),msg.getContent(),msg.getMsgLink(),msg.getMsgLink(),openAccess.getAccessToken());
            saveCallResult(msg,result);
        } catch (Exception e) {
            log.error("发送[{}]消息失败，失败原因为：[{}]",msg.getMsgId(),e);
            saveErrorResult(msg,e.getMessage());
        }
    }

    /**
     * 发送钉钉待办
     * @param msg
     */
    public void dingTalkWorkRecordService(MsgBody msg){
        try {
            String msgUser=getMsgUsers(msg);
            MsgTemplate template=getTempLate(msg.getTemplateId());
            MsgOpenAccess openAccess =getOpenAccess(template.getAccessId());
            OapiWorkrecordAddResponse rsp=DingTalkHelper.createWorkRecord(msgUser,msg.getSubject(),msg.getContent(),msg.getMsgLink(),msg.getMsgLinkPc(),openAccess.getAccessToken());
            if(rsp.isSuccess()){
                msg.setUserData(rsp.getRecordId());
            }
            saveCallResult(msg,rsp.getBody());
        } catch (Exception e) {
            log.error("创建[{}]工作待办失败，失败原因为：[{}]",msg.getMsgId(),e);
            saveErrorResult(msg,e.getMessage());
        }
    }

    /**
     * 完成钉钉待办
     * @param msgId
     * @return
     */
    public boolean finishDingTalkWorkRecord(String msgId){
        String result;
        MsgBody msg=null;
        try {
            msg=msgBodyService.getById(msgId);
            if(msg==null){
                throw new BadRequestAlertException(String.format("无法获取到[%s]待办信息",msgId),"","");
            }
            String msgUser=getMsgUsers(msg);
            MsgTemplate template=getTempLate(msg.getTemplateId());
            MsgOpenAccess openAccess =getOpenAccess(template.getAccessId());
            result = DingTalkHelper.finishWorkRecord(msgUser,msg.getUserData(),openAccess.getAccessToken());
        } catch (Exception e) {
            result=String.format("完成[{}]工作待办失败，失败原因为：[{}]",msgId,e);
            log.error(result);
        }
        if(msg!=null){
            msg.setUserData2(result);
            msgBodyService.update(msg);
        }
        return true;
    }

    /**
     * 发送阿里短信
     * @param msg
     * @return
     */
    @SneakyThrows
    private boolean aliSmsService(MsgBody msg){
        String msgUsers=msg.getToUsers();
        MsgTemplate template=templateService.getById(msg.getTemplateId());
        MsgOpenAccess openAccess =template.getOpenaccess();
        String region=openAccess.getRegionId();
        String accessKey=openAccess.getAccessKey();
        String accessSecret=openAccess.getSecretKey();
        DefaultProfile profile = DefaultProfile.getProfile(StringUtils.isEmpty(region)?"cn-hangzhou":region, accessKey, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);
        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain(aliSmsDomain);

        request.setSysAction(aliSendSmsAction);
        request.putQueryParameter("RegionId", region);
        request.putQueryParameter("PhoneNumbers", msgUsers);
        request.putQueryParameter("SignName", template.getTemplateName());
        request.putQueryParameter("Version", aliSendSmsVersion);
        request.putQueryParameter("TemplateCode", template.getTemplateId());
        request.putQueryParameter("TemplateParam", msg.getTemplateParams());
        CommonResponse response = client.getCommonResponse(request);
        saveCallResult(msg,new Gson().toJson(response));
        log.info(String.format("成功向用户[%s]发送一条短信",msgUsers));
        return true;
    }

    /**
     * 发送阿里邮件
     * @param msg
     * @return
     */
    @SneakyThrows
    private boolean aliEMailService(MsgBody msg){
        String msgUsers=msg.getToUsers();
        MsgTemplate template=templateService.getById(msg.getTemplateId());
        MsgOpenAccess openAccess =template.getOpenaccess();
        String region=openAccess.getRegionId();
        String accessKey=openAccess.getAccessKey();
        String accessSecret=openAccess.getSecretKey();
        DefaultProfile profile = DefaultProfile.getProfile(StringUtils.isEmpty(region)?"cn-hangzhou":region, accessKey, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        SingleSendMailRequest request = new SingleSendMailRequest();
        request.setAccountName(template.getTemplateId());
        request.setAddressType(1);
        request.setReplyToAddress(false);
        request.setToAddress(msgUsers);
        request.setSubject(template.getTemplateName());
        request.setHtmlBody(template.getContent());
        SingleSendMailResponse response =client.getAcsResponse(request);
        saveCallResult(msg,new Gson().toJson(response));
        log.info(String.format("成功向用户[%s]发送一条邮件",msgUsers));
        return true;
    }

    /**
     * 发送微信消息
     * @param msg
     * @return
     */
    private boolean weChatMsgService(MsgBody msg){
        String msgUsers=getMsgUsers(msg);
        MsgTemplate template=templateService.getById(msg.getTemplateId());
        MsgOpenAccess openAccess =template.getOpenaccess();
        Map templParams=new HashMap();
        Map paramMap=new HashMap();
        paramMap.put("template_id",template.getTemplateId());
        paramMap.put("touser",msgUsers);
        paramMap.put("data",msg.getTemplateParams());

        JSONObject obj=new JSONObject();
        obj.put("value","test");
        templParams.put("result",obj);
        HttpEntity request = new HttpEntity(paramMap);
        ResponseEntity<String> result = restTemplate.postForEntity(String.format(weChatSendMsgApi,openAccess.getAccessToken()), request , String.class);
        saveCallResult(msg,result.getBody());
        return true;
    }

    /**
     * 存储消息进消息表
     * @param msg
     * @return
     */
    public boolean sendMsg(MsgBody msg){
        String templateId =msg.getTemplateId();
        String userIds=msg.getToUsers();
        List<MsgBody> msgList=new ArrayList<>();
        for(int msgType:getMsgType(msg.getMsgType())){
            MsgTemplate msgTemplate =getTempLate(templateId);
            msg.setMsgName(msg.getSubject());
            msg.setTemplateId(msgTemplate.getTid());
            msg.setToUsers(userIds);
            msg.setMsgType(msgType);
            msgList.add(msg);
        }
        if(msgList.size()>0)
            msgBodyService.createBatch(msgList);
        return true;
    }

    /**
     * 存储钉钉消息进消息表
     * @param msg
     * @return
     */
    @SneakyThrows
    public boolean sendDingTalkLinkMsg(MsgBody msg){
        getTempLate(msg.getTemplateId());
        msg.setMsgName(msg.getSubject());
        msg.setMsgType(65);
        return msgBodyService.create(msg);
    }

    /**
     * 存储钉钉待办进消息表
     * @param msg
     * @return
     */
    @SneakyThrows
    public String createDingTalkWorkRecord(MsgBody msg){
        if(StringUtils.isEmpty(msg.getToUsers()))
            throw new BadRequestAlertException("无法获取到用户信息","","");
        getTempLate(msg.getTemplateId());
        msg.setMsgName(msg.getSubject());
        msg.setMsgType(66);
        msg.setMsgId(String.valueOf(msg.getDefaultKey(true)));
        msgBodyService.create(msg);
        return msg.getMsgId();
    }

    /**
     * 创建消息模板
     * @param template
     * @return
     */
    public synchronized boolean createMsgTemplate(Template template){
        JSONArray templates = template.getTemplate();
        for(int a=0;a<templates.size();a++){
            List<MsgTemplate> newTempList=new ArrayList<>();
            MsgTemplate newTempl =JSONObject.toJavaObject(templates.getJSONObject(a),MsgTemplate.class);
            Collection<String> templTypes = templateType.values();

            //创建消息模板
            for(String templateType : templTypes){
                String tid=String.format("%s-%s",newTempl.getTid(),templateType);
                MsgTemplate templ=templateService.getById(tid);
                if(templ!=null){
                    log.info(String.format("消息模板[%s]已存在，忽略发布!",tid));
                    continue;
                }
                MsgTemplate msgTemplate=new MsgTemplate();
//                String openAccessType=templateType.contains("-")?templateType.substring(0,templateType.indexOf("-")):templateType;
                CachedBeanCopier.copy(newTempl,msgTemplate);
//                msgTemplate.setOpenType(openAccessType);
                msgTemplate.setTid(tid);
                msgTemplate.setTemplateType(templateType);
//                msgTemplate.setAccessId(String.format("%s-%s",msgTempl.getTid(),openAccessType));
                newTempList.add(msgTemplate);
            }
            if(newTempList.size()>0)
                templateService.createBatch(newTempList);
        }
        return true;
    }

    /**
     * 获取消息类型
     * @param msgType
     * @return
     */
    private String getIdentityType(int msgType) {
        String identityType="";
        switch(msgType){
            case 2:
                identityType="aliyun";
                break;
            case 4:
                identityType="aliyun";
                break;
            case 32:
                identityType="wechat";
                break;
            case 64:
                identityType="dingtalk";
                break;
            case 65:
                identityType="dingtalk";
                break;
            case 66:
                identityType="dingtalk";
                break;
        }
        return identityType;
    }

    /**
     * 获取消息账户
     * @param msg
     * @return
     */
    private String getMsgUsers(MsgBody msg){
        String userId=msg.getToUsers();
        String msgType=getIdentityType(msg.getMsgType());
        QueryWrapper<MsgUserAccount> qw =new QueryWrapper();
        qw.eq("identity_type",msgType);
        if(userId.contains(",")){
            qw.in("userid",userId.split(","));
            List<MsgUserAccount> userAccounts =userAccountService.list(qw);
            if(userAccounts==null || userAccounts.size()==0)
                throw new BadRequestAlertException("未能获取到授权用户","NotifyCoreService","sendDingTalkMsg");

            StringBuffer authUserIds=new StringBuffer();
            for(MsgUserAccount userAccount: userAccounts){
                if(StringUtils.isEmpty(authUserIds.toString())){
                    authUserIds.append(userAccount.getIdentifier());
                }else{
                    authUserIds.append(","+userAccount.getIdentifier());
                }
            }
            return authUserIds.toString();
        }else{
            qw.eq("userid",userId);
            MsgUserAccount userAccount =userAccountService.getOne(qw);
            if(userAccount==null || StringUtils.isEmpty(userAccount.getIdentifier()))
                throw new BadRequestAlertException("未能获取到授权用户","NotifyCoreService","sendDingTalkMsg");
            return userAccount.getIdentifier();
        }
    }

    /**
     * 解析接口返回结果
     * @param result
     */
    private void getResult(String result){
        JSONObject resultJo = JSONObject.parseObject(result);
        if(resultJo.containsKey("errcode") && resultJo.getInteger("errcode")!=0)
            throw new BadRequestAlertException(String.format("发送消息失败,%s",resultJo.toString()),"","");
        else
            log.info("发送消息成功");
    }

    /**
     * 保存接口返回结果
     * @param msg
     * @param result
     */
    private void saveCallResult(MsgBody msg,String result){
        JSONObject resultJo = JSONObject.parseObject(result);
        if(resultJo.containsKey("errcode") && resultJo.getInteger("errcode")!=0){
            msg.setIsError(1);
            msg.setErrorInfo(resultJo.toString());
            log.info("发送消息失败");
        }
        else{
            msg.setIsError(0);
            log.info("发送消息成功");
        }
        msg.setIsSend(1);
        msgBodyService.update(msg);
    }

    /**
     * 存储错误信息
     * @param msg
     * @param errInfo
     */
    private void saveErrorResult(MsgBody msg,String errInfo){
        msg.setIsError(1);
        msg.setErrorInfo(errInfo);
        msg.setIsSend(1);
        msgBodyService.update(msg);
    }

    /**
     * 解析数值代码表获取消息类型
     * @param msgType
     * @return
     */
    private List<Integer> getMsgType(int msgType){
        List<Integer> useMsg=new ArrayList<>();
        for (Map.Entry<Integer,String> msg : templateType.entrySet()){
            if((msgType & msg.getKey()) == msg.getKey()){
                useMsg.add(msg.getKey());
            }
        }
        return useMsg;
    }

    /**
     * 获取消息模板
     * @param templateId
     * @return
     */
    private MsgTemplate getTempLate(String templateId){
        MsgTemplate template=templateService.getById(templateId);
        if(template==null){
            throw new BadRequestAlertException(String.format("发送链接消息失败，无法获取到[%s]对应的rt模板",templateId),"","");
        }
        return template;
    }

    /**
     * 获取开放平台
     * @param openAccessId
     * @return
     */
    private MsgOpenAccess getOpenAccess(String openAccessId){
        MsgOpenAccess openAccess =openAccessService.getById(openAccessId);
        if (openAccess == null){
            throw new BadRequestAlertException(String.format("发送链接消息失败，无法获取到[%s]对应的开放平台",openAccessId),"","");
        }
        return openAccess;
    }

    /**
     * 获取某个用户全量存储催办消息
     * @return
     */
    public Page<MsgBody> getBacklogAllContent(MsgBodySearchContext context) {
        if(ObjectUtils.isEmpty(context)){
            throw new BadRequestAlertException("无效消息上下文","NotifyCoreService","getBacklogAllContent");
        }
        if(ObjectUtils.isEmpty(context.getN_tousers_eq())){
            throw new BadRequestAlertException("无效用户信息","NotifyCoreService","getBacklogAllContent");
        }
        context.setN_tousers_eq(context.getN_tousers_eq());
        context.setSize(Integer.MAX_VALUE);
        Page<MsgBody> result = msgBodyService.searchDefault(context);
        return result;
    }

    /**
     * 获取某个用户分页存储催办消息
     * @return
     */
    @Scheduled(fixedRate = 300000)
    public synchronized void getBacklogPageContent() {
        msgMap.clear();
        MsgBodySearchContext context = new MsgBodySearchContext();
        context.setSize(Integer.MAX_VALUE);

        Page<MsgBody> page = msgBodyService.searchDefault(context);
        msgMap = page.getContent().stream().collect(Collectors.groupingBy(MsgBody::getToUsers));
    }

    /**
     * 缓存某个用户分页催办消息
     * @return
     */
    public Page<MsgBody> getBacklogByPage(MsgBodySearchContext context) {
        if (ObjectUtils.isEmpty(context)) {
            throw new BadRequestAlertException("无效消息上下文", "NotifyCoreService", "getBacklogAllContent");
        }
        String toUserId = context.getN_tousers_eq();
        if (!msgMap.containsKey(toUserId)) {
            return Page.empty();
        } else {

            com.baomidou.mybatisplus.extension.plugins.pagination.Page<MsgBody> pages = new com.baomidou.mybatisplus.extension.plugins.pagination.Page<>();
            int current = context.getPages().getCurrent() < 0 ? 0 : (int) context.getPages().getCurrent();
            int size = context.getPages().getCurrent() < 0 ? 0 : (int) context.getPages().getSize();
            List<MsgBody> pageList = new ArrayList<>();
            List<MsgBody> msgBodyList = msgMap.get(toUserId);

            //计算当前页第一条数据的下标
            int currId = context.getPages().getCurrent() > 1 ? (current - 1) * size : 0;
            for (int i = 0; i < size && i < msgBodyList.size() - currId; i++) {
                pageList.add(msgBodyList.get(currId + i));
            }
            pages.setSize(size);
            pages.setCurrent(current);
            pages.setTotal(msgMap.get(toUserId).size());
            pages.setRecords(pageList);


            return new PageImpl<>(pages.getRecords(), context.getPageable(), pages.getTotal());
        }
    }
}
