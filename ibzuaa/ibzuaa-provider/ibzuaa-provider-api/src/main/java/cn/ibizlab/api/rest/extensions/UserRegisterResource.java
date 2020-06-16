package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.extensions.service.UserRegisterService;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;


@RestController
public class UserRegisterResource {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private ISysPSSystemService iSysPSSystemService;

    @Value("${ibiz.auth.qq.redirect_uri:http://127.0.0.1:8111/#/qqLoginRedirect}")
    private String redirect_URI;

    @PostMapping(value = "/uaa/register")
    public ResponseEntity<JSONObject> register(@RequestBody JSONObject param) {
        JSONObject object = new JSONObject();
        // 空校验
        String loginname = param.getString("loginname");
        String personname = param.getString("personname");
        String password = param.getString("password");
        String registerType = param.getString("registerType");
        if (StringUtils.isEmpty(loginname))
            throw new BadRequestAlertException("用户名为空", "register", "");
        if (StringUtils.isEmpty(personname) && (!"qq".equals(registerType) && !"weixin".equals(registerType)))
            throw new BadRequestAlertException("用户姓名为空", "register", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "register", "");
        if (StringUtils.isEmpty(registerType))
            throw new BadRequestAlertException("注册方式为空", "register", "");

        // 检查用户名是否已被注册
        String sql = "select loginname from ibzuser where loginname=#{et.loginname}";
        Map<String, Object> sqlParam = new HashMap<>();
        sqlParam.put("loginname", loginname);
        List<JSONObject> select = iSysPSSystemService.select(sql, sqlParam);
        if (select.size() > 0)
            throw new BadRequestAlertException("该用户名已被注册", "register", "");

        // 注册
        IBZUSER ibzuser = new IBZUSER();
        String uuid = UUID.randomUUID().toString();
        ibzuser.setPersonname(personname);
        ibzuser.setPassword(password);
        ibzuser.setLoginname(loginname);
        switch (registerType) {
            case "commom":// 普通注册
                ibzuser.setUserid("commom-" + uuid);
                userRegisterService.commomRegister(ibzuser);
                break;
            case "qq":// qq授权注册
                ibzuser = null;
//                ibzuser.setUserid("qq-" + uuid);
//                String openId = param.getString("openId");
//                String accessToken = param.getString("accessToken");
//                userRegisterService.qqRegister(ibzuser, openId, accessToken);
                break;
            default:
                ibzuser.setUserid("commom-" + uuid);
                userRegisterService.commomRegister(ibzuser);
                break;
        }
        object.put("ibzuser", ibzuser);
        return ResponseEntity.ok().body(object);
    }


    /**
     * 根据openId查用户
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/uaa/queryUserByOpenId")
    public ResponseEntity<JSONObject> queryUserByOpenId(@RequestBody JSONObject param) {
        JSONObject object = new JSONObject();
        // 空校验
        String openId = param.getString("openId");
        if (StringUtils.isEmpty(openId))
            throw new BadRequestAlertException("openId为空", "queryUserByOpenId", "");

        // 根据openid查用户
        String sql = "select * from ibzuser where avatar=#{et.avatar}";
        Map<String, Object> sqlParam = new HashMap<>();
        sqlParam.put("avatar", openId);
        List<JSONObject> select = iSysPSSystemService.select(sql, sqlParam);
        if (select.size() > 0) {
            // 将查询到的ibzuser对象返回
            IBZUSER ibzuser = select.get(0).toJavaObject(IBZUSER.class);
            object.put("ibzuser", ibzuser);
        }

        return ResponseEntity.ok().body(object);
    }

    //这里的token要和微信测试号网页填写的token一样
    public static final String TOKEN = "weixin";

    /**
     * 响应微信发送的Token验证
     *
     * @param signature 　微信加密签名，signature结合了开发者填写的token参数和请求中的timestamp参数、nonce参数
     * @param timestamp 　时间戳
     * @param nonce     　随机数
     * @param echostr   　随机字符串
     * @param response  响应对象
     * @throws IOException
     * @throws NoSuchAlgorithmException
     */
    @GetMapping(value = "/uaa/responseTokenToWeiXin")
    public void responseTokenToWeiXin(String signature, String timestamp, String nonce, String echostr, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        // 将token、timestamp、nonce三个参数进行字典序排序
        System.out.println("signature:" + signature);
        System.out.println("timestamp:" + timestamp);
        System.out.println("nonce:" + nonce);
        System.out.println("echostr:" + echostr);
        System.out.println("TOKEN:" + TOKEN);
        String[] params = new String[]{TOKEN, timestamp, nonce};
        Arrays.sort(params);
        // 将三个参数字符串拼接成一个字符串进行sha1加密
        String clearText = params[0] + params[1] + params[2];
        String algorithm = "SHA-1";
        String sign = new String(org.apache.commons.codec.binary.Hex.encodeHex(MessageDigest.getInstance(algorithm).digest((clearText).getBytes()), true));
        // 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
        if (signature.equals(sign)) {
            // 确认此次GET请求来自微信服务器，原样返回echostr参数内容，则接入生效，成为开发者成功
            response.getWriter().print(echostr);
        }
    }


}
