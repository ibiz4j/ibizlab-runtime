package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.extensions.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.IBZConfigService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class SysAppService {

    @Autowired
    private ISysPSSystemService sysPSSystemService;

    @Autowired
    private IBZConfigService ibzConfigService;

    @Autowired
    private UAACoreService uaaCoreService;


    @Cacheable( value="ibzuaa_appnavbar",key = "'id:'+#p0+'||'+#p1")
    public JSONObject getAppNavigationBar(String navId,String userId)
    {
        JSONObject jo=ibzConfigService.getConfig("AppNavigationBar",navId, userId);
        if(!jo.containsKey("model"))
            jo.put("model",new JSONArray());
        LinkedHashMap<String,SysApp> defApps=uaaCoreService.getApps();
        List<SysApp> list=new ArrayList<>();
        JSONArray.parseArray(jo.get("model").toString(),SysApp.class).forEach(sysApp -> {
            SysApp def=defApps.get(sysApp.getId());
            if(def==null)return;
            sysApp.setAddr(def.getAddr());
            list.add(sysApp);
        });
        jo.remove("model");
        jo.put("model",JSONArray.toJSON(list));
        return jo;
    }

    @CacheEvict( value="ibzuaa_appnavbar",allEntries=true)
    public void resetAppNavigationBars()
    {

    }

}
