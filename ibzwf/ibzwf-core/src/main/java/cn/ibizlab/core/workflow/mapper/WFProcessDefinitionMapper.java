package cn.ibizlab.core.workflow.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.workflow.domain.WFProcessDefinition;
import cn.ibizlab.core.workflow.filter.WFProcessDefinitionSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface WFProcessDefinitionMapper extends BaseMapper<WFProcessDefinition> {

    Page<WFProcessDefinition> searchDefault(IPage page, @Param("srf") WFProcessDefinitionSearchContext context, @Param("ew") Wrapper<WFProcessDefinition> wrapper);
    @Override
    @Cacheable(value ="wfprocessdefinition", key = "'row:'+#p0")
    WFProcessDefinition selectById(Serializable id);
    @Override
    @CacheEvict(value ="wfprocessdefinition", key = "'row:'+#p0.definitionkey")
    int insert(WFProcessDefinition entity);
    @Override
    @CacheEvict(value ="wfprocessdefinition", key = "'row:'+#p0.definitionkey")
    int updateById(@Param(Constants.ENTITY) WFProcessDefinition entity);
    @Override
    @CacheEvict(value ="wfprocessdefinition", key = "'row:'+#p0.definitionkey" ,condition ="#p0 != null")
    int update(@Param(Constants.ENTITY) WFProcessDefinition entity, @Param("ew") Wrapper<WFProcessDefinition> updateWrapper);
    @Override
    @CacheEvict(value ="wfprocessdefinition", key = "'row:'+#p0")
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
