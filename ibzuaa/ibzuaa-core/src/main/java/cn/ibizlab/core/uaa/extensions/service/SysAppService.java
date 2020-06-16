package cn.ibizlab.core.uaa.extensions.service;

import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.domain.SysApp;
import cn.ibizlab.core.uaa.filter.SysAppSearchContext;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import cn.ibizlab.core.uaa.service.ISysAppService;
import cn.ibizlab.core.uaa.service.ISysPSSystemService;
import cn.ibizlab.core.uaa.service.impl.SysAppServiceImpl;
import cn.ibizlab.util.errors.BadRequestAlertException;
import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.security.AuthenticationUser;
import cn.ibizlab.util.service.IBZConfigService;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Primary
@Service
public class SysAppService extends SysAppServiceImpl
{

    @Autowired
    private ISysPSSystemService sysPSSystemService;

    @Autowired
    private IBZConfigService ibzConfigService;

    @Autowired
    private UAACoreService uaaCoreService;


    //@Cacheable( value="ibzuaa_switcher",key = "'id:'+#p0+'||'+#p1")
    public JSONObject getAppSwitcher(String id,String userId)
    {
        JSONObject jo=ibzConfigService.getConfig("AppSwitcher",id, userId);
        boolean nullSwitcher=false;
        if(!jo.containsKey("model"))
            jo.put("model", new JSONArray());
        if(jo.getJSONArray("model").size()==0)
            nullSwitcher=true;
        LinkedHashMap<String,SysApp> apps=uaaCoreService.getApps();

        LinkedHashMap<String,SysApp> defApps = new LinkedHashMap<>();
        defApps.putAll(apps);
        List<SysApp> list=new ArrayList<>();
        JSONArray.parseArray(jo.get("model").toString(),SysApp.class).forEach(sysApp -> {
            SysApp def=defApps.get(sysApp.getId());
            if(def==null||def.getVisabled()==null||def.getVisabled()==0)return;

            sysApp.setAddr(def.getAddr());
            sysApp.setIcon(def.getIcon());
            sysApp.setFullname(def.getFullname());
            sysApp.setType(def.getType());
            sysApp.setGroup(def.getGroup());
            list.add(sysApp);
            defApps.remove(def.getId());
        });
        final boolean flag=nullSwitcher;
        defApps.values().forEach(def -> {
            if(def.getVisabled()==null||def.getVisabled()==0)return;
            SysApp sysApp=new SysApp();
            CachedBeanCopier.copy(def,sysApp);
            if(flag&&id.equalsIgnoreCase("default"))
                sysApp.setVisabled(1);
            else
                sysApp.setVisabled(0);
            list.add(sysApp);
        });
        jo.remove("model");
        jo.put("model",JSONArray.toJSON(list));
        return jo;
    }

    @CacheEvict( value="ibzuaa_switcher",key = "'id:'+#p0+'||'+#p1")
    public boolean saveAppSwitcher(String id,String userId,JSONObject config)
    {
        return ibzConfigService.saveConfig("AppSwitcher",id, userId,config);
    }

    @CacheEvict( value="ibzuaa_switcher",allEntries=true)
    public void resetAppNavigationBars()
    {

    }

    @Override
    public SysApp get(String key)
    {
        String systemId=key.split("-")[0];
        SysPSSystem sysPSSystem=sysPSSystemService.getById(systemId);
        if(sysPSSystem!=null&&sysPSSystem.getApps()!=null)
        {
            for(SysApp app:sysPSSystem.getApps())
            {
                if(app.getId().equals(key))
                    return app;
            }
        }
        return null;
    }

    @Override
    public boolean save(SysApp et)
    {
        if(StringUtils.isEmpty(et.getSystemid())||StringUtils.isEmpty(et.getId()))
            throw new BadRequestAlertException("应用参数缺失","SysApp",et.getId());
        SysPSSystem sysPSSystem=sysPSSystemService.getById(et.getSystemid());
        if(sysPSSystem!=null&&sysPSSystem.getApps()!=null)
        {
            boolean bchange=false;
            for(SysApp app:sysPSSystem.getApps())
            {
                if(app.getId().equals(et.getId()))
                {
                    CachedBeanCopier.copy(et,app);
                    bchange=true;
                    break;
                }
            }
            if(bchange)
                sysPSSystemService.update(sysPSSystem);
        }
        return true;
    }

    @Override
    public boolean update(SysApp et)
    {
        return this.save(et);
    }

    @Override
    public boolean create(SysApp et)
    {
        return this.save(et);
    }

    @Override
    public Page<SysApp> searchDefault(SysAppSearchContext context)
    {
        context.setSize(Integer.MAX_VALUE);
        List<SysApp> content = new ArrayList<>();
        LinkedHashMap<String,SysApp> map = uaaCoreService.getApps();
        map.values().forEach(sysApp -> {
            if(!StringUtils.isEmpty(context.getN_pssystemid_eq())) {
                if(!sysApp.getSystemid().equals(context.getN_pssystemid_eq()))
                    return;
            }
            if(!StringUtils.isEmpty(context.getN_appname_like())) {
                if(sysApp.getLabel().indexOf(context.getN_appname_like())<0 &&
                        sysApp.getFullname().indexOf(context.getN_appname_like())<0)
                    return;
            }
            content.add(sysApp);
        });
        return new PageImpl<SysApp>(content,context.getPageable(),content.size());
    }
}
