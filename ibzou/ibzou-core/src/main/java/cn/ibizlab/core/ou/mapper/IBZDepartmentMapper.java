package cn.ibizlab.core.ou.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.HashMap;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.ou.domain.IBZDepartment;
import cn.ibizlab.core.ou.filter.IBZDepartmentSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface IBZDepartmentMapper extends BaseMapper<IBZDepartment>{

    Page<IBZDepartment> searchDefault(IPage page, @Param("srf") IBZDepartmentSearchContext context, @Param("ew") Wrapper<IBZDepartment> wrapper) ;
    @Override
    @Cacheable( value="ibzdepartment",key = "'row:'+#p0")
    IBZDepartment selectById(Serializable id);
    @Override
    @CacheEvict( value="ibzdepartment",key = "'row:'+#p0.deptid")
    int insert(IBZDepartment entity);
    @Override
    @CacheEvict( value="ibzdepartment",key = "'row:'+#p0.deptid")
    int updateById(@Param(Constants.ENTITY) IBZDepartment entity);
    @Override
    @CacheEvict(value="ibzdepartment",key = "'row:'+#p0.deptid")
    int update(@Param(Constants.ENTITY) IBZDepartment entity, @Param("ew") Wrapper<IBZDepartment> updateWrapper);
    @Override
    @CacheEvict( value="ibzdepartment",key = "'row:'+#p0")
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

    List<IBZDepartment> selectByParentdeptid(@Param("deptid") Serializable deptid) ;

    List<IBZDepartment> selectByOrgid(@Param("orgid") Serializable orgid) ;

}
