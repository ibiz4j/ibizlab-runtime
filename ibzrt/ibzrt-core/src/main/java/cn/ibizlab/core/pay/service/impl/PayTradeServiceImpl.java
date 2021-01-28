package cn.ibizlab.core.pay.service.impl;

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
import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.filter.PayTradeSearchContext;
import cn.ibizlab.core.pay.service.IPayTradeService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import cn.ibizlab.core.pay.client.PayTradeFeignClient;

/**
 * 实体[支付交易] 服务对象接口实现
 */
@Slf4j
@Service
public class PayTradeServiceImpl implements IPayTradeService {

    @Autowired
    PayTradeFeignClient payTradeFeignClient;


    @Override
    public boolean create(PayTrade et) {
        PayTrade rt = payTradeFeignClient.create(et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;
    }

    public void createBatch(List<PayTrade> list){
        payTradeFeignClient.createBatch(list) ;
    }

    @Override
    public boolean update(PayTrade et) {
        PayTrade rt = payTradeFeignClient.update(et.getTradeId(),et);
        if(rt==null)
            return false;
        CachedBeanCopier.copy(rt, et);
        return true;

    }

    public void updateBatch(List<PayTrade> list){
        payTradeFeignClient.updateBatch(list) ;
    }

    @Override
    public boolean remove(String trade_id) {
        boolean result=payTradeFeignClient.remove(trade_id) ;
        return result;
    }

    public void removeBatch(Collection<String> idList){
        payTradeFeignClient.removeBatch(idList);
    }

    @Override
    public PayTrade get(String trade_id) {
		PayTrade et=payTradeFeignClient.get(trade_id);
        if(et==null){
            et=new PayTrade();
            et.setTradeId(trade_id);
        }
        else{
        }
        return  et;
    }

    @Override
    public PayTrade getDraft(PayTrade et) {
        et=payTradeFeignClient.getDraft(et);
        return et;
    }

    @Override
    public boolean checkKey(PayTrade et) {
        return payTradeFeignClient.checkKey(et);
    }
    @Override
    @Transactional
    public boolean save(PayTrade et) {
        if(et.getTradeId()==null) et.setTradeId((String)et.getDefaultKey(true));
        if(!payTradeFeignClient.save(et))
            return false;
        return true;
    }

    @Override
    public void saveBatch(List<PayTrade> list) {
        payTradeFeignClient.saveBatch(list) ;
    }



	@Override
    public List<PayTrade> selectByAccessId(String id) {
        PayTradeSearchContext context=new PayTradeSearchContext();
        context.setSize(Integer.MAX_VALUE);
        context.setN_accessid_eq(id);
        return payTradeFeignClient.searchDefault(context).getContent();
    }

    @Override
    public void removeByAccessId(String id) {
        Set<String> delIds=new HashSet<String>();
        for(PayTrade before:selectByAccessId(id)){
            delIds.add(before.getTradeId());
        }
        if(delIds.size()>0)
            this.removeBatch(delIds);
    }



    /**
     * 查询集合 数据集
     */
    @Override
    public Page<PayTrade> searchDefault(PayTradeSearchContext context) {
        Page<PayTrade> payTrades=payTradeFeignClient.searchDefault(context);
        return payTrades;
    }

}



