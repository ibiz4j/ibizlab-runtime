package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.extensions.service.wechat.WXPay;
import cn.ibizlab.core.extensions.service.wechat.WechatPayConfig;
import cn.ibizlab.core.pay.domain.PayOpenAccess;
import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.service.IPayOpenAccessService;
import cn.ibizlab.core.pay.service.IPayTradeService;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.HttpUtils;
import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
@Slf4j
public class PayCoreService {

    @Autowired
    @Lazy
    IPayOpenAccessService openAccessService;
    @Autowired
    @Lazy
    IPayTradeService tradeService;

    @Value("${ibz.pay.ali.pagepay.returnurl:http://127.0.0.1:8080/pay/trade/pagepay/callback}")
    private  String ali_return_url;

    @Value("${ibz.pay.ali.gateway:https://openapi.alipaydev.com/gateway.do}")
    private  String ali_gateway;
    private final String format="json";
    private final String charset="UTF-8";
    private final String signType="RSA2";
    private static Map<String,AlipayClient> aliPayClientMap = Collections.synchronizedMap(new HashMap<>());

    /**
     * 支付宝网页支付
     * @param trade
     * @return
     */
    @SneakyThrows
    public String pagePay(PayTrade trade){
        PayOpenAccess openAccess=getOpenAccess(trade);
        AlipayClient alipayClient = getAliPayClient(openAccess);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setReturnUrl(openAccess.getRedirectUri());
        request.setNotifyUrl(ali_return_url);
        request.setBizContent(
                "{\"out_trade_no\":\""+ trade.getOutTradeNo() +"\","
                        + "\"total_amount\":\""+ trade.getTotalAmount() +"\","
                        + "\"subject\":\""+ trade.getSubject() +"\","
                        + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\""
                        + "}");
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        if (response.isSuccess()) {
            log.info("支付接口调用成功");
        } else {
            log.error("支付接口调用失败");
        }
        return response.getBody();
    }

    /**
     * 支付平台回调:修改订单状态，回调业务系统
     * @param req
     * @return
     */
    public String pagePayCallBack(HttpServletRequest req){

        JSONObject paramMap=new JSONObject();
        Enumeration names = req.getParameterNames();
        while(names.hasMoreElements()) {
            String key = (String)names.nextElement();
            String value = req.getParameter(key);
            paramMap.put(key,value);
        }
//        String result_code=paramMap.getString("code");
//        String result_sub_code=paramMap.getString("sub_code");
        String out_trade_no=paramMap.getString("out_trade_no");
//        String app_id=paramMap.getString("app_id");
        String total_amount=paramMap.getString("total_amount");
        String trade_status=paramMap.getString("trade_status");

        if(StringUtils.isEmpty(out_trade_no))
            return String.format("没有找到[%s]订单信息",out_trade_no);

//        String tradeId= DigestUtils.md5DigestAsHex(String.format(out_trade_no+"||"+app_id).getBytes());
        PayTrade trade = tradeService.getOne(Wrappers.<PayTrade>lambdaQuery().eq(PayTrade::getOutTradeNo,out_trade_no).eq(PayTrade::getTradeStatus,"pending"));

        if(trade==null)
            return String.format("没有找到[%s]待付款订单",out_trade_no);

        //确认订单金额
        if(!total_amount.equals(trade.getTotalAmount()))
            return String.format("交易订单金额[%s]与支付平台金额[%s]不吻合",total_amount,trade.getTotalAmount());

        PayOpenAccess openAccess=trade.getOpenaccess();
        if(openAccess==null){
            openAccess= openAccessService.get(trade.getAccessId());
        }
        String notify_url=openAccess.getNotifyUrl();
        if(StringUtils.isEmpty(notify_url))
            return String.format("无法获取[%s]开放平台回调地址",trade.getAccessId());

        //修改订单状态
        if(trade_status.equals("TRADE_SUCCESS")){
            trade.setTradeStatus("success");
        }
        else{
            trade.setTradeStatus("fail");
        }
        tradeService.update(trade);
        //回调业务系统
        HttpUtils.post(notify_url, null, paramMap);
        return "success";
    }

    /**
     * 预创建订单，生成支付二维码
     * @param trade
     * @return
     */
    public JSONObject preCreate(PayTrade trade){
        JSONObject rs=new JSONObject();
        PayOpenAccess openAccess=getOpenAccess(trade);
        switch (openAccess.getOpenType()){
            case "aliyun":
//                qrcode=aliPayPreCreate(openAccess,trade);
                break;
            case "wechat":
                rs= wechatPreCreate(openAccess,trade);
                break;
        }
        return rs;
    }

    /**
     * 查询订单
     * @param trade
     * @return
     */
    public JSONObject query(PayTrade trade){
        JSONObject rs=new JSONObject();
        PayOpenAccess openAccess=getOpenAccess(trade);
        switch (openAccess.getOpenType()){
            case "aliyun":
//                aliPayQuery(openAccess,trade);
                break;
            case "wechat":
                rs=wechatPayQuery(openAccess,trade);
                break;
        }
        return rs;
    }

    /**
     * 取消订单
     * @param trade
     * @return
     */
    public JSONObject cancel(PayTrade trade){
        JSONObject rs=new JSONObject();
        PayOpenAccess openAccess=getOpenAccess(trade);
        switch (openAccess.getOpenType()){
            case "aliyun":
//                aliPayCancel(openAccess,trade);
                break;
            case "wechat":
                rs=wechatPayCancel(openAccess,trade);
                break;
        }
        return rs;
    }

//    /**
//     * 交易预创建，生成正扫二维码
//     * @param trade
//     */
//    @SneakyThrows
//    private String aliPayPreCreate(PayOpenAccess openAccess,PayTrade trade){
//        AlipayClient alipayClient = getAliPayClient(openAccess);
//        AlipayTradePrecreateRequest  request = new AlipayTradePrecreateRequest();
//        request.setBizContent("{" +
//                "\"out_trade_no\":\""+trade.getOutTradeNo()+"\"," +
//                "\"subject\":\""+trade.getSubject()+"\"," +
//                "\"total_amount\":"+trade.getTotalAmount()+"," +
//                "  }");
//        AlipayTradePrecreateResponse response = alipayClient.execute(request);
//        if(response.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
//        return response.getQrCode();
//    }
//
//    /**
//     * 交易查询
//     * @param trade
//     */
//    @SneakyThrows
//    private String aliPayQuery(PayOpenAccess openAccess,PayTrade trade){
//        AlipayClient alipayClient = getAliPayClient(openAccess);
//        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
//        request.setBizContent("{" +
//                "\"out_trade_no\":\""+trade.getOutTradeNo()+"\"," +
//                "  }");
//        AlipayTradeQueryResponse response = alipayClient.execute(request);
//        if(response.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
//        return response.getBody();
//    }
//
//    /**
//     * 撤销交易
//     * @param trade
//     */
//    @SneakyThrows
//    private String aliPayCancel(PayOpenAccess openAccess,PayTrade trade) {
//        AlipayClient alipayClient = getAliPayClient(openAccess);
//        AlipayTradeCancelRequest request = new AlipayTradeCancelRequest();
//        request.setBizContent("{" +
//                "\"out_trade_no\":\""+trade.getOutTradeNo()+"\"," +
//                "  }");
//        AlipayTradeCancelResponse response = alipayClient.execute(request);
//        if(response.isSuccess()){
//            System.out.println("调用成功");
//        } else {
//            System.out.println("调用失败");
//        }
//        return response.getOutTradeNo();
//    }

    /**
     * 微信预创建订单
     * @param trade
     */
    @SneakyThrows
    private JSONObject wechatPreCreate(PayOpenAccess openAccess,PayTrade trade) {
        JSONObject rs=new JSONObject();
        WechatPayConfig config = getWechatPayConfig(openAccess);
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", trade.getSubject());
        data.put("out_trade_no", trade.getOutTradeNo());
//        data.put("device_info", "");
        data.put("fee_type", "CNY");
        data.put("total_fee",trade.getTotalAmount());
//        data.put("spbill_create_ip", "123.12.12.123");
        data.put("notify_url", openAccess.getRedirectUri());
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
//        data.put("product_id", "12");
        Map resp = wxpay.unifiedOrder(data);
        if(resp!=null){
            rs=new JSONObject(resp);
        }
        return rs;
    }

    /**
     * 微信：订单查询
     * @param trade
     */
    @SneakyThrows
    private JSONObject wechatPayQuery(PayOpenAccess openAccess,PayTrade trade) {
        JSONObject rs=new JSONObject();
        WechatPayConfig config = getWechatPayConfig(openAccess);
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", trade.getOutTradeNo());
        Map resp = wxpay.orderQuery(data);
        if(resp!=null){
            rs=new JSONObject(resp);
        }
        return rs;
    }

    /**
     * 微信：取消订单
     * @param trade
     */
    @SneakyThrows
    private JSONObject wechatPayCancel(PayOpenAccess openAccess,PayTrade trade) {
        JSONObject rs=new JSONObject();
        WechatPayConfig config = getWechatPayConfig(openAccess);
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", trade.getOutTradeNo());
        Map resp = wxpay.closeOrder(data);
        if(resp!=null){
            rs=new JSONObject(resp);
        }
        return rs;
    }

    /**
     * 获取开放平台信息
     * @param trade
     * @return
     */
    private PayOpenAccess getOpenAccess(PayTrade trade){
        PayOpenAccess openAccess=null;
        String accessId=trade.getAccessId();
        String appId=trade.getAppId();
        if(!StringUtils.isEmpty(accessId))
            openAccess=openAccessService.getOne(Wrappers.<PayOpenAccess>lambdaQuery().eq(PayOpenAccess::getAccessKey,appId).or().eq(PayOpenAccess::getId,accessId));
        if(ObjectUtils.isEmpty(openAccess) || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("获取开放平台配置失败","PayCoreService","pagePay");
        trade.setAccessId(openAccess.getId());
        return openAccess;
    }

    /**
     * 获取阿里支付客户端对象
     * @param openAccess
     * @return
     */
    private synchronized AlipayClient getAliPayClient(PayOpenAccess openAccess){
        String appId=openAccess.getAccessKey();
        if(aliPayClientMap.get(appId)!=null){
            return aliPayClientMap.get(appId);
        }
        AlipayClient alipayClient = new DefaultAlipayClient(ali_gateway,openAccess.getAccessKey(),openAccess.getSecretKey(),format,charset,openAccess.getAccessToken(),signType);
        aliPayClientMap.put(appId,alipayClient);
        return alipayClient;
    }

    /**
     * 获取微信应用配置
     * @param openAccess
     * @return
     */
    private WechatPayConfig getWechatPayConfig(PayOpenAccess openAccess) {
        WechatPayConfig config=new WechatPayConfig();
        config.setAppID(openAccess.getAccessKey());
        config.setKey(openAccess.getAccessKey());
        config.setMchID(openAccess.getRegionId());
        config.setWXPayDomain(null);
        return config;
    }
}
