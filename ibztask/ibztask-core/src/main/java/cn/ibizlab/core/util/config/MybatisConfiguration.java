package cn.ibizlab.core.util.config;

import com.baomidou.mybatisplus.autoconfigure.MybatisPlusProperties;
import cn.ibizlab.util.helper.UniqueNameGenerator;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.ibatis.mapping.VendorDatabaseIdProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.mybatis.spring.annotation.MapperScan;
import java.util.Properties;

/**
 * mybatis全局配置类
 */
@Configuration
@MapperScan(value="cn.ibizlab.core.*.mapper",nameGenerator = UniqueNameGenerator.class)
public class MybatisConfiguration {

    /**
     * mybatis适配多数据库
     * @return
     */
    @Bean
    public DatabaseIdProvider getDatabaseIdProvider() {
        DatabaseIdProvider databaseIdProvider = new VendorDatabaseIdProvider();
        Properties p = new Properties();
        p.setProperty("Oracle", "oracle");
        p.setProperty("MySQL", "mysql");
        p.setProperty("PostgreSQL", "postgresql");
        p.setProperty("DM", "oracle");//达梦数据库使用oracle模式
        p.setProperty("H2", "mysql");//根据当前运行的数据库设置h2对应的databaseid
        databaseIdProvider.setProperties(p);
        return databaseIdProvider;
    }

    /**
     * mybatis-plus分页
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        // 设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        // paginationInterceptor.setOverflow(false);
        // 设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(-1);

        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

}