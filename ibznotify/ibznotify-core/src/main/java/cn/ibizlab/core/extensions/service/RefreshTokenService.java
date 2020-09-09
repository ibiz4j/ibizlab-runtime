package cn.ibizlab.core.extensions.service;

import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.service.IMsgOpenAccessService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 定时刷新token
 */
@Service
@Slf4j
public class RefreshTokenService{

    @Autowired
    IMsgOpenAccessService smsConfigService;

    @Autowired
    NotifyCoreService notifyCoreService;

    @Scheduled(fixedRate = 3600000)
    public void refreshToken() {
        QueryWrapper<MsgOpenAccess> qw=new QueryWrapper();
        qw.eq("disabled",0).isNotNull("access_key").isNotNull("secret_key").and(i -> i.eq("open_type","wechat").or().eq("open_type","dingtalk"));
        List<MsgOpenAccess> accessList= smsConfigService.list(qw);
        if(accessList.size()==0)
            return ;
        List<MsgOpenAccess> refreshAccessList=new ArrayList<>();
        for(MsgOpenAccess openAccess : accessList){
            String accessToken = openAccess.getAccessToken();
            Timestamp expiresTime = openAccess.getExpiresTime();
            if(StringUtils.isEmpty(accessToken)){
                notifyCoreService.refreshToken(openAccess);
                refreshAccessList.add(openAccess);
            }
            else{
                if(expiresTime==null || expiresTime.before(new Timestamp(new Date().getTime()))){
                    notifyCoreService.refreshToken(openAccess);//刷新token
                    refreshAccessList.add(openAccess);
                }
            }
        }
        if(refreshAccessList.size()>0)
            smsConfigService.updateBatch(refreshAccessList);
    }
}