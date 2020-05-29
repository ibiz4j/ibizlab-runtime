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
import cn.ibizlab.core.ou.domain.IBZEmployee;
import cn.ibizlab.core.ou.filter.IBZEmployeeSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface IBZEmployeeMapper extends BaseMapper<IBZEmployee>{

    Page<IBZEmployee> searchDefault(IPage page, @Param("srf") IBZEmployeeSearchContext context, @Param("ew") Wrapper<IBZEmployee> wrapper) ;
    @Override
    @Cacheable( value="ibzemployee",key = "'row:'+#p0")
    IBZEmployee selectById(Serializable id);
    @Override
    @CacheEvict( value="ibzemployee",key = "'row:'+#p0.userid")
    int insert(IBZEmployee entity);
    @Override
    @CacheEvict( value="ibzemployee",key = "'row:'+#p0.userid")
    int updateById(@Param(Constants.ENTITY) IBZEmployee entity);
    @Override
    @CacheEvict(value="ibzemployee",key = "'row:'+#p0.userid")
    int update(@Param(Constants.ENTITY) IBZEmployee entity, @Param("ew") Wrapper<IBZEmployee> updateWrapper);
    @Override
    @CacheEvict( value="ibzemployee",key = "'row:'+#p0")
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

    List<IBZEmployee> selectByMdeptid(@Param("deptid") Serializable deptid) ;

    List<IBZEmployee> selectByOrgid(@Param("orgid") Serializable orgid) ;

}
