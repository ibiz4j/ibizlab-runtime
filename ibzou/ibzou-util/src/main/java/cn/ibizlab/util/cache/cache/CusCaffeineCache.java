package cn.ibizlab.util.cache.cache;

import cn.ibizlab.util.helper.Globs;
import org.springframework.cache.caffeine.CaffeineCache;
import com.github.benmanes.caffeine.cache.Cache;

import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 自定义的Caffeine缓存
 */
public class CusCaffeineCache extends CaffeineCache{

    public CusCaffeineCache(String name, Cache<Object, Object> cache) {
        super(name,cache);
    }

    public CusCaffeineCache(String name, Cache<Object, Object> cache, boolean allowNullValues) {
        super(name,cache,allowNullValues);
    }


    @Override
    public void evict(@NotNull Object key) {
        if (key instanceof String && ((String) key).startsWith("glob:")) {
            String globPattern = ((String)key).split("glob:")[1];
            // 将Glob匹配转换成正则匹配
            String regexPattern = Globs.toUnixRegexPattern(globPattern);
            // String regexPattern = Globs.toWindowsRegexPattern(globPattern);

            Cache<Object,Object> cache = super.getNativeCache();
            Set<Object> keySet = cache.asMap().keySet();
            keySet = keySet.stream().filter(o->o.toString().matches(regexPattern)).collect(Collectors.toSet());

            cache.invalidateAll(keySet);
        }else{
            super.evict(key);
        }
    }
}
