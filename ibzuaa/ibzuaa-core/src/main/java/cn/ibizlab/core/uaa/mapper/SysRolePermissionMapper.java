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
import cn.ibizlab.core.uaa.domain.SysRolePermission;
import cn.ibizlab.core.uaa.filter.SysRolePermissionSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface SysRolePermissionMapper extends BaseMapper<SysRolePermission> {

    Page<SysRolePermission> searchDefault(IPage page, @Param("srf") SysRolePermissionSearchContext context, @Param("ew") Wrapper<SysRolePermission> wrapper);
    @Override
    SysRolePermission selectById(Serializable id);
    @Override
    int insert(SysRolePermission entity);
    @Override
    int updateById(@Param(Constants.ENTITY) SysRolePermission entity);
    @Override
    int update(@Param(Constants.ENTITY) SysRolePermission entity, @Param("ew") Wrapper<SysRolePermission> updateWrapper);
    @Override
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

    List<SysRolePermission> selectByPermissionid(@Param("permissionid") Serializable permissionid);

    List<SysRolePermission> selectByRoleid(@Param("roleid") Serializable roleid);

}
