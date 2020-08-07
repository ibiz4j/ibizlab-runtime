package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysUserAuth;
import cn.ibizlab.core.uaa.service.ISysUserAuthService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.service.IBZUSERService;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.nacos.client.identify.Base64;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * 实体[IBZUSER] 钉钉用户注册接口实现
 */
@Service
@Slf4j
public class UserDingtalkRegisterService {

    @Autowired
    private IBZUSERService ibzuserService;
    @Autowired
    private ISysUserAuthService sysUserAuthService;

    /**
     * 注册
     *
     * @param ibzuser
     */
    public void toRegister(IBZUSER ibzuser) {
        // 创建ibzuser
        boolean flag = ibzuserService.save(ibzuser);
        if (!flag) {
            throw new BadRequestAlertException("注册失败","UserDingtalkRegisterService","");
        }
    }

    /**
     * 创建钉钉用户授权信息
     * @param userAuth
     */
    public void toCreateUserAuth(SysUserAuth userAuth) {
        // 创建用户授权信息
        boolean flag = sysUserAuthService.create(userAuth);
        if (!flag) {
            throw new BadRequestAlertException("保存用户授权信息失败", "UserDingtalkRegisterService", "");
        }
    }


    /**
     * 钉钉服务端通过临时授权码code获取授权用户的个人信息
     *
     * @param code
     * @param currentTimeMillis
     * @param appId
     * @param appSecret
     * @return
     */
    public JSONObject requestDingtalkUserByCode(String code, long currentTimeMillis, String appId, String appSecret) {
        JSONObject returnObj = null;
        CloseableHttpClient client = null;
        try {
            // 根据timestamp, appSecret计算签名值
            String stringToSign = String.valueOf(currentTimeMillis);
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(appSecret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signatureBytes = mac.doFinal(stringToSign.getBytes("UTF-8"));
            String signature = new String(Base64.encodeBase64(signatureBytes));
            String urlEncodeSignature = URLEncoder.encode(signature, "UTF-8");

            // 通过临时授权码Code获取用户信息，临时授权码只能使用一次
            String url = "https://oapi.dingtalk.com/sns/getuserinfo_bycode?accessKey=" + appId
                    + "&timestamp=" + currentTimeMillis
                    + "&signature=" + urlEncodeSignature;

            // 创建httpclient对象
            client = HttpClients.createDefault();

            // 创建post方式请求对象
            HttpPost httpPost = new HttpPost(url);

            // 装填参数
            JSONObject param = new JSONObject();
            param.put("tmp_auth_code", code);
            StringEntity jsonBody = new StringEntity(param.toString(), "UTF-8");

            // 设置参数到请求对象中
            httpPost.setEntity(jsonBody);

            // 设置header信息
            httpPost.setHeader("Content-type", "application/json");
            httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

            //　执行请求操作，并拿到结果（同步阻塞）
            CloseableHttpResponse response = client.execute(httpPost);

            //　获取结果实体
            HttpEntity entity = response.getEntity();
            JSONObject entityJson = null;
            if (StringUtils.isEmpty(entity)) {
                throw new BadRequestAlertException("钉钉服务端返回结果为空", "UserDingtalkRegisterService", "");
            } else {
                //按指定编码转换结果实体为String类型
                entityJson = JSONObject.parseObject(EntityUtils.toString(entity, "UTF-8"));

                // 是否获取钉钉用户信息成功
                if (entityJson.getInteger("errcode")==0) {
                    // 这里只有简单的信息:nick、openid、unionid
                    returnObj = entityJson.getJSONObject("user_info");
                } else {
                    throw new BadRequestAlertException(entityJson.getString("errmsg"), "UserDingtalkRegisterService", "");
                }
            }

        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            throw new BadRequestAlertException("钉钉生成安全签名失败", "UserDingtalkRegisterService", "");
        } catch (IOException e) {
            throw new BadRequestAlertException("连接钉钉服务端失败", "UserDingtalkRegisterService", "");
        }
        finally {
            if(client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                }
            }
        }

        return returnObj;
    }


}