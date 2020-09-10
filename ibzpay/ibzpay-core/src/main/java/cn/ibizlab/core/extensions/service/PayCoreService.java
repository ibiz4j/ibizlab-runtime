package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.extensions.service.wechat.WXPay;
import cn.ibizlab.core.extensions.service.wechat.WechatPayConfig;
import cn.ibizlab.core.extensions.service.wechat.WechatPayDomain;
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

    @Value("${ibz.pay.ali.pagepay.notifyurl:http://127.0.0.1:8080/pay/trade/pagepay/callback}")
    private  String ali_notify_url;

    @Value("${ibz.pay.wechat.notifyurl:http://127.0.0.1:8080/pay/trade/callback}")
    private  String wechat_notify_url;

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
        PayOpenAccess openAccess=getOpenAccess(trade.getAccessId());
        trade.setAccessId(openAccess.getId());
        AlipayClient alipayClient = getAliPayClient(openAccess);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
        request.setReturnUrl(openAccess.getRedirectUri());
        request.setNotifyUrl(ali_notify_url);
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
        String out_trade_no=paramMap.getString("out_trade_no");
        String total_amount=paramMap.getString("total_amount");
        String trade_status=paramMap.getString("trade_status");
        if(StringUtils.isEmpty(out_trade_no))
            return String.format("没有找到[%s]订单信息",out_trade_no);

        PayTrade trade = tradeService.getOne(Wrappers.<PayTrade>lambdaQuery().eq(PayTrade::getOutTradeNo,out_trade_no).eq(PayTrade::getTradeStatus,"NOTPAY"));
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
     * 下订单，获取支付链接
     * @param trade 订单信息
     * @return
     */
    @SneakyThrows
    public JSONObject preCreate(PayTrade trade){
        PayOpenAccess openAccess=getOpenAccess(trade.getAccessId());
        trade.setAccessId(openAccess.getId());
        WechatPayConfig config = getWechatPayConfig(openAccess);
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("body", trade.getSubject());
        data.put("out_trade_no", trade.getOutTradeNo());
        data.put("fee_type", "CNY");
        data.put("total_fee",trade.getTotalAmount());
        data.put("notify_url", wechat_notify_url);
        data.put("trade_type", "NATIVE");  // 此处指定为扫码支付
        return getResult(wxpay.unifiedOrder(data));
    }

    /**
     * 查询订单
     * @param accessId    开放平台配置标识
     * @param outTradeNo  订单号
     * @return
     */
    @SneakyThrows
    public JSONObject query(String accessId,String outTradeNo){
        PayOpenAccess openAccess=getOpenAccess(accessId);
        WechatPayConfig config = getWechatPayConfig(openAccess);
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        Map rsMap=wxpay.orderQuery(data);
        JSONObject rs=getResult(rsMap);
        String trade_status=rs.getString("trade_state");
        if(!StringUtils.isEmpty(trade_status)){
            //更新订单状态
            PayTrade trade=new PayTrade();
            trade.setAccessId(openAccess.getId());
            trade.setOutTradeNo(outTradeNo);
            trade.setTradeStatus(trade_status);
            trade.setTradeId((String) trade.getDefaultKey(true));
            tradeService.update(trade);
            if("SUCCESS".equals(trade_status)){
                //回调业务系统
                HttpUtils.post(openAccess.getNotifyUrl(), null, new JSONObject(rsMap));
            }
        }
        return rs;
    }

    /**
     * 取消订单
     * @param accessId    开放平台配置标识
     * @param outTradeNo  订单号
     * @return
     */
    @SneakyThrows
    public JSONObject cancel(String accessId,String outTradeNo){
        PayOpenAccess openAccess=getOpenAccess(accessId);
        WechatPayConfig config = getWechatPayConfig(openAccess);
        WXPay wxpay = new WXPay(config);
        Map<String, String> data = new HashMap<String, String>();
        data.put("out_trade_no", outTradeNo);
        return getResult(wxpay.closeOrder(data));
    }

    public String callBack(HttpServletRequest req){
        return "success";
    }
    /**
     * 获取开放平台信息
     * @param id
     * @return
     */
    private PayOpenAccess getOpenAccess(String id){
        PayOpenAccess openAccess=null;
        if(!StringUtils.isEmpty(id))
            openAccess=openAccessService.getOne(Wrappers.<PayOpenAccess>lambdaQuery().eq(PayOpenAccess::getAccessKey,id).or().eq(PayOpenAccess::getId,id));
        if(ObjectUtils.isEmpty(openAccess) || (openAccess.getDisabled()!=null && openAccess.getDisabled()==1))
            throw new BadRequestAlertException("获取开放平台配置失败","PayCoreService","pagePay");
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
    @SneakyThrows
    private WechatPayConfig getWechatPayConfig(PayOpenAccess openAccess) {
        WechatPayConfig config=new WechatPayConfig();
        config.setAppID(openAccess.getAccessKey());
        config.setKey(openAccess.getSecretKey());
        config.setMchID(openAccess.getAccessToken());
        config.setWXPayDomain(new WechatPayDomain());
        return config;
    }

    /**
     * 移除敏感信息
     * @param resp
     * @return
     */
    private JSONObject getResult(Map resp){
        JSONObject rs=new JSONObject();
        if(resp!=null){
            rs=new JSONObject(resp);
            rs.remove("device_info");
            rs.remove("nonce_str");
            rs.remove("appid");
            rs.remove("sign");
            rs.remove("mch_id");
            rs.remove("prepay_id");
            rs.remove("return_code");
            rs.remove("return_msg");
        }
        return rs;
    }
}
