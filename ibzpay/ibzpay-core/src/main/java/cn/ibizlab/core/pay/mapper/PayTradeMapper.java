package cn.ibizlab.core.pay.mapper;

import java.util.List;
import org.apache.ibatis.annotations.*;
import java.util.Map;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import java.util.Map;
import org.apache.ibatis.annotations.Select;
import cn.ibizlab.core.pay.domain.PayTrade;
import cn.ibizlab.core.pay.filter.PayTradeSearchContext;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import java.io.Serializable;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.alibaba.fastjson.JSONObject;

@com.baomidou.dynamic.datasource.annotation.DS("db2")
public interface PayTradeMapper extends BaseMapper<PayTrade> {

    Page<PayTrade> searchDefault(IPage page, @Param("srf") PayTradeSearchContext context, @Param("ew") Wrapper<PayTrade> wrapper);
    @Override
    PayTrade selectById(Serializable id);
    @Override
    int insert(PayTrade entity);
    @Override
    int updateById(@Param(Constants.ENTITY) PayTrade entity);
    @Override
    int update(@Param(Constants.ENTITY) PayTrade entity, @Param("ew") Wrapper<PayTrade> updateWrapper);
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

    List<PayTrade> selectByAccessId(@Param("id") Serializable id);

}
