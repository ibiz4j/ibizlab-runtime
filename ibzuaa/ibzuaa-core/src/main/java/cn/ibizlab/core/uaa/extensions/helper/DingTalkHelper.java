package cn.ibizlab.core.uaa.extensions.helper;

import cn.ibizlab.util.errors.BadRequestAlertException;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGetJsapiTicketRequest;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGetJsapiTicketResponse;
import com.dingtalk.api.response.OapiGettokenResponse;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

@Slf4j
public class DingTalkHelper {
    /**
     * 获取jsapi_ticket
     * @param accessToken
     * @return
     */
    @SneakyThrows
    public static String  getJsapiTicket(String accessToken){
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/get_jsapi_ticket");
        OapiGetJsapiTicketRequest req = new OapiGetJsapiTicketRequest();
        req.setTopHttpMethod("GET");
        OapiGetJsapiTicketResponse rs = client.execute(req, accessToken);
        if(!rs.isSuccess()){
            log.error("获取ticket失败,{},错误代码：{}",rs.getErrmsg(),rs.getErrcode());
            throw new BadRequestAlertException(String.format("获取ticket失败,%s,错误代码：[%s]",rs.getErrmsg(),rs.getErrcode()),"DingTalkHelper","getJsapiTicket");
        }
        return rs.getTicket();
    }

    /**
     * 计算签名
     * @param ticket
     * @param nonceStr
     * @param timeStamp
     * @param url
     * @return
     */
    public static String sign(String ticket, String nonceStr, long timeStamp, String url){
        String plain = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + String.valueOf(timeStamp)
                + "&url=" + url;
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            sha1.reset();
            sha1.update(plain.getBytes("UTF-8"));
            return byteToHex(sha1.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new BadRequestAlertException(e.getMessage(),"sign","");
        } catch (UnsupportedEncodingException e) {
            throw new BadRequestAlertException(e.getMessage(),"sign","");
        }
    }

    // 字节数组转化成十六进制字符串
    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    /**
     * 获取token
     * @param appKey
     * @param appSecret
     * @return
     */
    @SneakyThrows
    public static String getAccessToken(String appKey,String appSecret){
        DefaultDingTalkClient client = new DefaultDingTalkClient("https://oapi.dingtalk.com/gettoken");
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(appKey);
        request.setAppsecret(appSecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        if (response.getErrcode() != 0 || StringUtils.isEmpty(response.getAccessToken()))
            throw new BadRequestAlertException("获取access_token失败", "UserDingtalkRegisterService", response.getErrmsg());
        return response.getAccessToken();
    }
}
