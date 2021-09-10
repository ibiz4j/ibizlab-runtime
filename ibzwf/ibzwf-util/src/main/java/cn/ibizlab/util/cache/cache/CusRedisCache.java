package cn.ibizlab.util.cache.cache;

import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;

import javax.validation.constraints.NotNull;

/**
 * 自定义的redis缓存
 */
public class CusRedisCache extends RedisCache {

    public CusRedisCache(String name, RedisCacheWriter redisCacheWriter, RedisCacheConfiguration configuration) {
        super(name, redisCacheWriter, configuration);
    }

    @Override
    public void evict(@NotNull Object key) {
        if (key instanceof String && ((String) key).startsWith("glob:")) {
            String globPattern = ((String)key).split("glob:")[1];

            byte[] globPatternBytes = super.getCacheConfiguration().getConversionService().convert(globPattern,byte[].class);
            if(globPatternBytes!=null){
                super.getNativeCache().clean(super.getName(),globPatternBytes);
            }
        }else{
            super.evict(key);
        }
    }
}
