package cn.ibizlab.core.notify.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.notify.domain.MsgTemplate;
import cn.ibizlab.core.notify.filter.MsgTemplateSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface MsgTemplateMapper extends BaseMapper<MsgTemplate> {

    Page<MsgTemplate> searchDefault(IPage page, @Param("srf") MsgTemplateSearchContext context, @Param("ew") Wrapper<MsgTemplate> wrapper);
    @Override
    @Cacheable(value ="msgtemplate", key = "'row:'+#p0")
    MsgTemplate selectById(Serializable id);
    @Override
    @CacheEvict(value ="msgtemplate", key = "'row:'+#p0.tid")
    int insert(MsgTemplate entity);
    @Override
    @CacheEvict(value ="msgtemplate", key = "'row:'+#p0.tid")
    int updateById(@Param(Constants.ENTITY) MsgTemplate entity);
    @Override
    @CacheEvict(value ="msgtemplate", key = "'row:'+#p0.tid")
    int update(@Param(Constants.ENTITY) MsgTemplate entity, @Param("ew") Wrapper<MsgTemplate> updateWrapper);
    @Override
    @CacheEvict(value ="msgtemplate", key = "'row:'+#p0")
    int deleteById(Serializable id);
    /**
    * 自定义查询SQL
    * @param sql
    * @return
    */
    @Select("${sql}")
    List<JSONObject> selectBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * 自定义更新SQL
    * @param sql
    * @return
    */
    @Update("${sql}")
    boolean updateBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * 自定义插入SQL
    * @param sql
    * @return
    */
    @Insert("${sql}")
    boolean insertBySQL(@Param("sql") String sql, @Param("et")Map param);

    /**
    * 自定义删除SQL
    * @param sql
    * @return
    */
    @Delete("${sql}")
    boolean deleteBySQL(@Param("sql") String sql, @Param("et")Map param);

    List<MsgTemplate> selectByAccessId(@Param("id") Serializable id);

}
