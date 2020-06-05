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
import cn.ibizlab.core.ou.domain.IBZOrganization;
import cn.ibizlab.core.ou.filter.IBZOrganizationSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface IBZOrganizationMapper extends BaseMapper<IBZOrganization>{

    Page<IBZOrganization> searchDefault(IPage page, @Param("srf") IBZOrganizationSearchContext context, @Param("ew") Wrapper<IBZOrganization> wrapper) ;
    @Override
    @Cacheable( value="ibzorganization",key = "'row:'+#p0")
    IBZOrganization selectById(Serializable id);
    @Override
    @CacheEvict( value="ibzorganization",key = "'row:'+#p0.orgid")
    int insert(IBZOrganization entity);
    @Override
    @CacheEvict( value="ibzorganization",key = "'row:'+#p0.orgid")
    int updateById(@Param(Constants.ENTITY) IBZOrganization entity);
    @Override
    @CacheEvict(value="ibzorganization",key = "'row:'+#p0.orgid")
    int update(@Param(Constants.ENTITY) IBZOrganization entity, @Param("ew") Wrapper<IBZOrganization> updateWrapper);
    @Override
    @CacheEvict( value="ibzorganization",key = "'row:'+#p0")
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

    List<IBZOrganization> selectByParentorgid(@Param("orgid") Serializable orgid) ;

}
