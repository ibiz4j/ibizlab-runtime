package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.extensions.service.UserRegisterService;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.util.domain.IBZUSER;
import cn.ibizlab.util.errors.BadRequestAlertException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


@RestController
public class UserRegisterResource {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private ISysPSSystemService iSysPSSystemService;

    /**
     * 普通注册
     *
     * @param param
     * @return
     */
    @PostMapping(value = "/uaa/register")
    public ResponseEntity<JSONObject> register(@RequestBody JSONObject param) {
        JSONObject object = new JSONObject();
        // 空校验
        String loginname = param.getString("loginname");
        String personname = param.getString("personname");
        String password = param.getString("password");
        String registerType = param.getString("registerType");
        if (StringUtils.isEmpty(loginname))
            throw new BadRequestAlertException("用户名为空", "UserRegisterResource", "");
        if (StringUtils.isEmpty(personname) && (!"qq".equals(registerType) && !"wechat".equals(registerType)))
            throw new BadRequestAlertException("用户姓名为空", "UserRegisterResource", "");
        if (StringUtils.isEmpty(password))
            throw new BadRequestAlertException("密码为空", "UserRegisterResource", "");
        if (StringUtils.isEmpty(registerType))
            throw new BadRequestAlertException("注册方式为空", "UserRegisterResource", "");

        // 检查用户名是否已被注册
        String sql = "select loginname from ibzuser where loginname=#{et.loginname}";
        Map<String, Object> sqlParam = new HashMap<>();
        sqlParam.put("loginname", loginname);
        List<JSONObject> select = iSysPSSystemService.select(sql, sqlParam);
        if (select.size() > 0)
            throw new BadRequestAlertException("该用户名已被注册", "UserRegisterResource", "");

        // 注册
        IBZUSER ibzuser = new IBZUSER();
        String uuid = UUID.randomUUID().toString();
        ibzuser.setPersonname(personname);
        ibzuser.setPassword(password);
        ibzuser.setLoginname(loginname);
        ibzuser.setUserid("commom-" + uuid);
        userRegisterService.toRegister(ibzuser);

        // 响应结果
        object.put("ibzuser", ibzuser);
        return ResponseEntity.ok().body(object);
    }




}
