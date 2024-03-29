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
import com.alibaba.fastjson.JSONObject;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.pay.mapper.PayTradeMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import org.springframework.util.StringUtils;

/**
 * 实体[支付交易] 服务对象接口实现
 */
@Slf4j
@Service("PayTradeServiceImpl")
public class PayTradeServiceImpl extends ServiceImpl<PayTradeMapper, PayTrade> implements IPayTradeService {

    @Autowired
    @Lazy
    protected cn.ibizlab.core.pay.service.IPayOpenAccessService payopenaccessService;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(PayTrade et) {
        fillParentData(et);
        if(!this.retBool(this.baseMapper.insert(et))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getTradeId()), et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<PayTrade> list) {
        list.forEach(item->fillParentData(item));
        this.saveOrUpdateBatch(list,batchSize);
    }

    @Override
    @Transactional
    public boolean update(PayTrade et) {
        fillParentData(et);
        if(!update(et, (Wrapper) et.getUpdateWrapper(true).eq("tradeid", et.getTradeId()))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getTradeId()), et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<PayTrade> list) {
        list.forEach(item->fillParentData(item));
        updateBatchById(list, batchSize);
    }

    @Override
    @Transactional
    public boolean remove(String key) {
        boolean result = removeById(key);
        return result ;
    }

    @Override
    @Transactional
    public void removeBatch(Collection<String> idList) {
        removeByIds(idList);
    }

    @Override
    @Transactional
    public PayTrade get(String key) {
        PayTrade et = getById(key);
        if (et == null) {
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), key);
        }
        else {
        }
        return et;
    }

    @Override
    public PayTrade getDraft(PayTrade et) {
        fillParentData(et);
        return et;
    }

    @Override
    public boolean checkKey(PayTrade et) {
        return (!ObjectUtils.isEmpty(et.getTradeId())) && (!Objects.isNull(this.getById(et.getTradeId())));
    }
    @Override
    @Transactional
    public boolean save(PayTrade et) {
        if(!saveOrUpdate(et)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(PayTrade et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? getProxyService().update(et) : getProxyService().create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<PayTrade> list) {
        list.forEach(item->fillParentData(item));
        List<PayTrade> create = new ArrayList<>();
        List<PayTrade> update = new ArrayList<>();
        for (PayTrade et : list) {
            if (ObjectUtils.isEmpty(et.getTradeId()) || ObjectUtils.isEmpty(getById(et.getTradeId()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            getProxyService().createBatch(create);
        }
        if (update.size() > 0) {
            getProxyService().updateBatch(update);
        }
        return true;
    }

    @Override
    @Transactional
    public void saveBatch(List<PayTrade> list) {
        list.forEach(item->fillParentData(item));
        List<PayTrade> create = new ArrayList<>();
        List<PayTrade> update = new ArrayList<>();
        for (PayTrade et : list) {
            if (ObjectUtils.isEmpty(et.getTradeId()) || ObjectUtils.isEmpty(getById(et.getTradeId()))) {
                create.add(et);
            } else {
                update.add(et);
            }
        }
        if (create.size() > 0) {
            getProxyService().createBatch(create);
        }
        if (update.size() > 0) {
            getProxyService().updateBatch(update);
        }
    }


	@Override
    public List<PayTrade> selectByAccessId(String id) {
        return baseMapper.selectByAccessId(id);
    }
    @Override
    public void removeByAccessId(String id) {
        this.remove(new QueryWrapper<PayTrade>().eq("accessid",id));
    }


    /**
     * 查询集合 数据集
     */
    @Override
    public Page<PayTrade> searchDefault(PayTradeSearchContext context) {
            com.baomidou.mybatisplus.extension.plugins.pagination.Page<PayTrade> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
            return new PageImpl<PayTrade>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }



    /**
     * 为当前实体填充父数据（外键值文本、外键值附加数据）
     * @param et
     */
    private void fillParentData(PayTrade et){
        //实体关系[DER1N_PAY_TRADE_PAY_OPEN_ACCESS_ACCESSID]
        if(!ObjectUtils.isEmpty(et.getAccessId())){
            cn.ibizlab.core.pay.domain.PayOpenAccess openaccess=et.getOpenaccess();
            if(ObjectUtils.isEmpty(openaccess)){
                cn.ibizlab.core.pay.domain.PayOpenAccess majorEntity=payopenaccessService.get(et.getAccessId());
                et.setOpenaccess(majorEntity);
                openaccess=majorEntity;
            }
            et.setAppId(openaccess.getAccessKey());
            et.setAccessName(openaccess.getName());
        }
    }




    @Override
    public List<JSONObject> select(String sql, Map param){
        return this.baseMapper.selectBySQL(sql,param);
    }

    @Override
    @Transactional
    public boolean execute(String sql , Map param){
        if (sql == null || sql.isEmpty()) {
            return false;
        }
        if (sql.toLowerCase().trim().startsWith("insert")) {
            return this.baseMapper.insertBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("update")) {
            return this.baseMapper.updateBySQL(sql,param);
        }
        if (sql.toLowerCase().trim().startsWith("delete")) {
            return this.baseMapper.deleteBySQL(sql,param);
        }
        log.warn("暂未支持的SQL语法");
        return true;
    }





    public IPayTradeService getProxyService() {
        return cn.ibizlab.util.security.SpringContextHolder.getBean(this.getClass());
    }
}



