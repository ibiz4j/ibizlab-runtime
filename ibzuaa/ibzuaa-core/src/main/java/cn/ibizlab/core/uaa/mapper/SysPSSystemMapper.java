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
import cn.ibizlab.core.uaa.domain.SysPSSystem;
import cn.ibizlab.core.uaa.filter.SysPSSystemSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

public interface SysPSSystemMapper extends BaseMapper<SysPSSystem> {

    Page<SysPSSystem> searchDefault(IPage page, @Param("srf") SysPSSystemSearchContext context, @Param("ew") Wrapper<SysPSSystem> wrapper);
    Page<SysPSSystem> searchPick(IPage page, @Param("srf") SysPSSystemSearchContext context, @Param("ew") Wrapper<SysPSSystem> wrapper);
    @Override
    SysPSSystem selectById(Serializable id);
    @Override
    int insert(SysPSSystem entity);
    @Override
    int updateById(@Param(Constants.ENTITY) SysPSSystem entity);
    @Override
    int update(@Param(Constants.ENTITY) SysPSSystem entity, @Param("ew") Wrapper<SysPSSystem> updateWrapper);
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

}
