package cn.ibizlab.core.ou.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import java.math.BigInteger;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import cn.ibizlab.util.errors.BadRequestAlertException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.SysTeam;
import cn.ibizlab.core.ou.filter.SysTeamSearchContext;
import cn.ibizlab.core.ou.service.ISysTeamService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.ou.client.SysTeamFeignClient;

/**
 * 实体[组] 服务对象接口实现
 */
@Slf4j
@Service
public class SysTeamServiceImpl implements ISysTeamService {

    @Autowired
    SysTeamFeignClient sysTeamFeignClient;


    @Override
    public boolean create(SysTeam et) {
        SysTeam rt = sysTeamFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<SysTeam> list){
        sysTeamFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(SysTeam et) {
        SysTeam rt = sysTeamFeignClient.update(et.getTeamid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<SysTeam> list){
        sysTeamFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String teamid) {
        boolean result=sysTeamFeignClient.remove(teamid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        sysTeamFeignClient.removeBatch(idList);
    }

    @Override
    public SysTeam get(String teamid) {
		SysTeam et=sysTeamFeignClient.get(teamid);
        if(et==null){
            et=new SysTeam();
            et.setTeamid(teamid);
        }
        else{
        }
        return  et;
    }

    @Override
    public SysTeam getDraft(SysTeam et) {
        et=sysTeamFeignClient.getDraft();
        return et;
    }

    @Override
    public boolean checkKey(SysTeam et) {
        return sysTeamFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(SysTeam et) {
        if(et.getTeamid()==null) et.setTeamid((String)et.getDefaultKey(true));
        if(!sysTeamFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<SysTeam> list) {
        sysTeamFeignClient.saveBatch(list) ;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<SysTeam> searchDefault(SysTeamSearchContext context) {
        Page<SysTeam> sysTeams=sysTeamFeignClient.searchDefault(context);
        return sysTeams;
    }



}



