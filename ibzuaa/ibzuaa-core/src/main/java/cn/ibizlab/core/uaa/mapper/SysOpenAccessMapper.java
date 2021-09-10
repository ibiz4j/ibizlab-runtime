package cn.ibizlab.core.uaa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.uaa.domain.SysOpenAccess;
import cn.ibizlab.core.uaa.filter.SysOpenAccessSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface SysOpenAccessMapper extends BaseMapper<SysOpenAccess> {

    Page<SysOpenAccess> searchDefault(IPage page, @Param("srf") SysOpenAccessSearchContext context, @Param("ew") Wrapper<SysOpenAccess> wrapper);
    @Override
    @Cacheable(value ="sysopenaccess", key = "'row:'+#p0")
    SysOpenAccess selectById(Serializable id);
    @Override
    @CacheEvict(value ="sysopenaccess", key = "'row:'+#p0.id")
    int insert(SysOpenAccess entity);
    @Override
    @CacheEvict(value ="sysopenaccess", key = "'row:'+#p0.id")
    int updateById(@Param(Constants.ENTITY) SysOpenAccess entity);
    @Override
    @CacheEvict(value ="sysopenaccess", key = "'row:'+#p0.id" ,condition ="#p0 != null")
    int update(@Param(Constants.ENTITY) SysOpenAccess entity, @Param("ew") Wrapper<SysOpenAccess> updateWrapper);
    @Override
    @CacheEvict(value ="sysopenaccess", key = "'row:'+#p0")
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
