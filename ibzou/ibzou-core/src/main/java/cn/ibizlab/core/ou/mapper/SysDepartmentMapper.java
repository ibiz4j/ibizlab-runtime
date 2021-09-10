package cn.ibizlab.core.ou.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.ou.domain.SysDepartment;
import cn.ibizlab.core.ou.filter.SysDepartmentSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface SysDepartmentMapper extends BaseMapper<SysDepartment> {

    Page<SysDepartment> searchDefault(IPage page, @Param("srf") SysDepartmentSearchContext context, @Param("ew") Wrapper<SysDepartment> wrapper);
    @Override
    @Cacheable(value ="sysdepartment", key = "'row:'+#p0")
    SysDepartment selectById(Serializable id);
    @Override
    @CacheEvict(value ="sysdepartment", key = "'row:'+#p0.deptid")
    int insert(SysDepartment entity);
    @Override
    @CacheEvict(value ="sysdepartment", key = "'row:'+#p0.deptid")
    int updateById(@Param(Constants.ENTITY) SysDepartment entity);
    @Override
    @CacheEvict(value ="sysdepartment", key = "'row:'+#p0.deptid" ,condition ="#p0 != null")
    int update(@Param(Constants.ENTITY) SysDepartment entity, @Param("ew") Wrapper<SysDepartment> updateWrapper);
    @Override
    @CacheEvict(value ="sysdepartment", key = "'row:'+#p0")
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

    List<SysDepartment> selectByParentdeptid(@Param("deptid") Serializable deptid);

    List<SysDepartment> selectByOrgid(@Param("orgid") Serializable orgid);

}
