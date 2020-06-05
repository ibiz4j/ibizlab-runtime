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
import cn.ibizlab.core.ou.domain.IBZDeptMember;
import cn.ibizlab.core.ou.filter.IBZDeptMemberSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface IBZDeptMemberMapper extends BaseMapper<IBZDeptMember>{

    Page<IBZDeptMember> searchDefault(IPage page, @Param("srf") IBZDeptMemberSearchContext context, @Param("ew") Wrapper<IBZDeptMember> wrapper) ;
    @Override
    IBZDeptMember selectById(Serializable id);
    @Override
    int insert(IBZDeptMember entity);
    @Override
    int updateById(@Param(Constants.ENTITY) IBZDeptMember entity);
    @Override
    int update(@Param(Constants.ENTITY) IBZDeptMember entity, @Param("ew") Wrapper<IBZDeptMember> updateWrapper);
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

    List<IBZDeptMember> selectByDeptid(@Param("deptid") Serializable deptid) ;

    List<IBZDeptMember> selectByUserid(@Param("userid") Serializable userid) ;

    List<IBZDeptMember> selectByPostid(@Param("postid") Serializable postid) ;

}
