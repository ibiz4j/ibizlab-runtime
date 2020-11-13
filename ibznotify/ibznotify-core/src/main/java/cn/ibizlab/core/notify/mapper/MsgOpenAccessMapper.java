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
import cn.ibizlab.core.notify.domain.MsgOpenAccess;
import cn.ibizlab.core.notify.filter.MsgOpenAccessSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface MsgOpenAccessMapper extends BaseMapper<MsgOpenAccess> {

    Page<MsgOpenAccess> searchDefault(IPage page, @Param("srf") MsgOpenAccessSearchContext context, @Param("ew") Wrapper<MsgOpenAccess> wrapper);
    @Override
    @Cacheable(value ="msgopenaccess", key = "'row:'+#p0")
    MsgOpenAccess selectById(Serializable id);
    @Override
    @CacheEvict(value ="msgopenaccess", key = "'row:'+#p0.id")
    int insert(MsgOpenAccess entity);
    @Override
    @CacheEvict(value ="msgopenaccess", key = "'row:'+#p0.id")
    int updateById(@Param(Constants.ENTITY) MsgOpenAccess entity);
    @Override
    @CacheEvict(value ="msgopenaccess", key = "'row:'+#p0.id")
    int update(@Param(Constants.ENTITY) MsgOpenAccess entity, @Param("ew") Wrapper<MsgOpenAccess> updateWrapper);
    @Override
    @CacheEvict(value ="msgopenaccess", key = "'row:'+#p0")
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

}
