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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.context.annotation.Lazy;
import cn.ibizlab.core.ou.domain.IBZTeam;
import cn.ibizlab.core.ou.filter.IBZTeamSearchContext;
import cn.ibizlab.core.ou.service.IIBZTeamService;

import cn.ibizlab.util.helper.CachedBeanCopier;


import cn.ibizlab.core.ou.client.IBZTeamFeignClient;

/**
 * 实体[组] 服务对象接口实现
 */
@Slf4j
@Service
public class IBZTeamServiceImpl implements IIBZTeamService {

    @Autowired
    IBZTeamFeignClient iBZTeamFeignClient;


    @Override
    public boolean checkKey(IBZTeam et) {
        return iBZTeamFeignClient.checkKey(et);
    }
    @Override
    public boolean create(IBZTeam et) {
        IBZTeam rt = iBZTeamFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;
    }

    public void createBatch(List<IBZTeam> list){
        iBZTeamFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(IBZTeam et) {
        IBZTeam rt = iBZTeamFeignClient.update(et.getTeamid(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt,et);
        return true;

    }

    public void updateBatch(List<IBZTeam> list){
        iBZTeamFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String teamid) {
        boolean result=iBZTeamFeignClient.remove(teamid) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        iBZTeamFeignClient.removeBatch(idList);
    }

    @Override
    public IBZTeam get(String teamid) {
		IBZTeam et=iBZTeamFeignClient.get(teamid);
        if(et==null){
            et=new IBZTeam();
            et.setTeamid(teamid);
        }
        else{
        }
        return  et;
    }

    @Override
    @Transactional
    public boolean save(IBZTeam et) {
        if(et.getTeamid()==null) et.setTeamid((String)et.getDefaultKey(true));
        if(!iBZTeamFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<IBZTeam> list) {
        iBZTeamFeignClient.saveBatch(list) ;
    }

    @Override
    public IBZTeam getDraft(IBZTeam et) {
        et=iBZTeamFeignClient.getDraft();
        return et;
    }





    /**
     * 查询集合 DEFAULT
     */
    @Override
    public Page<IBZTeam> searchDefault(IBZTeamSearchContext context) {
        Page<IBZTeam> iBZTeams=iBZTeamFeignClient.searchDefault(context);
        return iBZTeams;
    }


}



