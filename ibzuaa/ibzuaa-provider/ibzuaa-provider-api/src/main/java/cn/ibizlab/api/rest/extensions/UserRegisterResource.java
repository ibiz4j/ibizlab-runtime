package cn.ibizlab.api.rest.extensions;

import cn.ibizlab.core.uaa.domain.SysUser;
import cn.ibizlab.core.uaa.extensions.service.UserRegisterService;
import cn.ibizlab.util.domain.IBZUSER;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserRegisterResource {

    @Autowired
    private UserRegisterService userRegisterService;

    @PostMapping(value = "/uaa/register")
    public ResponseEntity<JSONObject> register(@RequestBody SysUser ibzuser) {

        JSONObject object = new JSONObject();
        // 响应结果
        object.put("ibzuser", userRegisterService.toRegister(ibzuser));
        return ResponseEntity.ok().body(object);
    }




}
