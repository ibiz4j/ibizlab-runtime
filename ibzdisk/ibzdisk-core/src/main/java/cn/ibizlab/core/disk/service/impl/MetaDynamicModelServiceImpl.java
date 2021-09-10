package cn.ibizlab.core.disk.service.impl;

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
import cn.ibizlab.core.disk.domain.MetaDynamicModel;
import cn.ibizlab.core.disk.filter.MetaDynamicModelSearchContext;
import cn.ibizlab.core.disk.service.IMetaDynamicModelService;

import cn.ibizlab.util.helper.CachedBeanCopier;
import cn.ibizlab.util.helper.DEFieldCacheMap;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.ibizlab.core.disk.mapper.MetaDynamicModelMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;

/**
 * 实体[动态模型] 服务对象接口实现
 */
@Slf4j
@Service("MetaDynamicModelServiceImpl")
public class MetaDynamicModelServiceImpl extends ServiceImpl<MetaDynamicModelMapper, MetaDynamicModel> implements IMetaDynamicModelService {


    protected cn.ibizlab.core.disk.service.IMetaDynamicModelService metadynamicmodelService = this;

    protected int batchSize = 500;

    @Override
    @Transactional
    public boolean create(MetaDynamicModel et) {
        if(!this.retBool(this.baseMapper.insert(et))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getConfigid()), et);
        return true;
    }

    @Override
    @Transactional
    public void createBatch(List<MetaDynamicModel> list) {
        this.saveBatch(list, batchSize);
    }

    @Override
    @Transactional
    public boolean update(MetaDynamicModel et) {
        if(!update(et, (Wrapper) et.getUpdateWrapper(true).eq("configid", et.getConfigid()))) {
            return false;
        }
        CachedBeanCopier.copy(get(et.getConfigid()), et);
        return true;
    }

    @Override
    @Transactional
    public void updateBatch(List<MetaDynamicModel> list) {
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
    public MetaDynamicModel get(String key) {
        MetaDynamicModel et = getById(key);
        if (et == null) {
            throw new BadRequestAlertException("数据不存在", this.getClass().getSimpleName(), key);
        }
        else {
        }
        return et;
    }

    @Override
    public MetaDynamicModel getDraft(MetaDynamicModel et) {
        return et;
    }

    @Override
    public boolean checkKey(MetaDynamicModel et) {
        return (!ObjectUtils.isEmpty(et.getConfigid())) && (!Objects.isNull(this.getById(et.getConfigid())));
    }
    @Override
    @Transactional
    public MetaDynamicModel init(MetaDynamicModel et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean initBatch(List<MetaDynamicModel> etList) {
        for(MetaDynamicModel et : etList) {
            init(et);
        }
        return true;
    }

    @Override
    @Transactional
    public MetaDynamicModel publish(MetaDynamicModel et) {
        //自定义代码
        return et;
    }

    @Override
    @Transactional
    public boolean publishBatch(List<MetaDynamicModel> etList) {
        for(MetaDynamicModel et : etList) {
            publish(et);
        }
        return true;
    }

    @Override
    @Transactional
    public boolean save(MetaDynamicModel et) {
        if(!saveOrUpdate(et)) {
            return false;
        }
        return true;
    }

    @Override
    @Transactional
    public boolean saveOrUpdate(MetaDynamicModel et) {
        if (null == et) {
            return false;
        } else {
            return checkKey(et) ? getProxyService().update(et) : getProxyService().create(et);
        }
    }

    @Override
    @Transactional
    public boolean saveBatch(Collection<MetaDynamicModel> list) {
        List<MetaDynamicModel> create = new ArrayList<>();
        List<MetaDynamicModel> update = new ArrayList<>();
        for (MetaDynamicModel et : list) {
            if (ObjectUtils.isEmpty(et.getConfigid()) || ObjectUtils.isEmpty(getById(et.getConfigid()))) {
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
    public void saveBatch(List<MetaDynamicModel> list) {
        List<MetaDynamicModel> create = new ArrayList<>();
        List<MetaDynamicModel> update = new ArrayList<>();
        for (MetaDynamicModel et : list) {
            if (ObjectUtils.isEmpty(et.getConfigid()) || ObjectUtils.isEmpty(getById(et.getConfigid()))) {
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
    public List<MetaDynamicModel> selectByPdynainstid(String configid) {
        return baseMapper.selectByPdynainstid(configid);
    }
    @Override
    public void removeByPdynainstid(String configid) {
        this.remove(new QueryWrapper<MetaDynamicModel>().eq("pdynainstid",configid));
    }


    /**
     * 查询集合 数据集
     */
    @Override
    public Page<MetaDynamicModel> searchDefault(MetaDynamicModelSearchContext context) {
            com.baomidou.mybatisplus.extension.plugins.pagination.Page<MetaDynamicModel> pages=baseMapper.searchDefault(context.getPages(),context,context.getSelectCond());
            return new PageImpl<MetaDynamicModel>(pages.getRecords(), context.getPageable(), pages.getTotal());
    }

    /**
     * 查询集合 主实例数据查询
     */
    @Override
    public Page<MetaDynamicModel> searchDynaInst(MetaDynamicModelSearchContext context) {
            com.baomidou.mybatisplus.extension.plugins.pagination.Page<MetaDynamicModel> pages=baseMapper.searchDynaInst(context.getPages(),context,context.getSelectCond());
            return new PageImpl<MetaDynamicModel>(pages.getRecords(), context.getPageable(), pages.getTotal());
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



    public IMetaDynamicModelService getProxyService() {
        return cn.ibizlab.util.security.SpringContextHolder.getBean(this.getClass());
    }
}



