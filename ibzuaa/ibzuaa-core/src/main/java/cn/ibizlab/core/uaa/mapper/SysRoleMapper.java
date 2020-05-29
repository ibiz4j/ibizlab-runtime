package cn.ibizlab.core.uaa.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.uaa.domain.SysRole;
import cn.ibizlab.core.uaa.filter.SysRoleSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface SysRoleMapper extends BaseMapper<SysRole>{

    Page<SysRole> searchDefault(IPage page, @Param("srf") SysRoleSearchContext context, @Param("ew") Wrapper<SysRole> wrapper) ;
    @Override
    @Cacheable( value="sysrole",key = "'row:'+#p0")
    SysRole selectById(Serializable id);
    @Override
    @CacheEvict( value="sysrole",key = "'row:'+#p0.roleid")
    int insert(SysRole entity);
    @Override
    @CacheEvict( value="sysrole",key = "'row:'+#p0.roleid")
    int updateById(@Param(Constants.ENTITY) SysRole entity);
    @Override
    @CacheEvict(value="sysrole",key = "'row:'+#p0.roleid")
    int update(@Param(Constants.ENTITY) SysRole entity, @Param("ew") Wrapper<SysRole> updateWrapper);
    @Override
    @CacheEvict( value="sysrole",key = "'row:'+#p0")
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
