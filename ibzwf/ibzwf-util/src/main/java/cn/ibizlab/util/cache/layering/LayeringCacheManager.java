package cn.ibizlab.util.cache.layering;

import com.github.benmanes.caffeine.cache.Caffeine;
import com.github.benmanes.caffeine.cache.CaffeineSpec;
import cn.ibizlab.util.cache.setting.FirstCacheSetting;
import cn.ibizlab.util.cache.setting.SecondaryCacheSetting;
import lombok.Data;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;
import org.springframework.util.StringUtils;

/**
 * 缓存分层类
 * 1级缓存为caffeine
 * 2级缓存为redis
 */
@Data
public class LayeringCacheManager implements CacheManager {
    static final int DEFAULT_EXPIRE_AFTER_WRITE = 2;
    static final int DEFAULT_INITIAL_CAPACITY = 5;
    static final int DEFAULT_MAXIMUM_SIZE = 1_000;
    private final ConcurrentMap<String, Cache> cacheMap = new ConcurrentHashMap<String, Cache>(16);
    /**
     * 一级缓存配置
     */
    private Map<String, FirstCacheSetting> firstCacheSettings = null;
    /**
     * 二级缓存配置
     */
    private Map<String, SecondaryCacheSetting> secondaryCacheSettings = null;

    public RedisCacheWriter redisCacheWriter;

    public RedisCacheConfiguration redisConfiguration;

    public RedisOperations redisOperations;

    /**
     * 是否允许动态创建缓存，默认是true
     */
    private boolean dynamic = true;

    /**
     * 缓存值是否允许为NULL
     */
    private boolean allowNullValues = false;

    /**
     * expireAfterWrite：2 小时
     * initialCapacity：5
     * maximumSize： 1_000
     */
    private Caffeine<Object, Object> cacheBuilder = Caffeine.newBuilder()
            .expireAfterAccess(DEFAULT_EXPIRE_AFTER_WRITE, TimeUnit.HOURS)
            .initialCapacity(DEFAULT_INITIAL_CAPACITY)
            .maximumSize(DEFAULT_MAXIMUM_SIZE);

    public LayeringCacheManager(RedisTemplate<String, Object> redisTemplate) {
        this.redisOperations=redisTemplate;
    }

    /**
     * 获取缓存对象
     * @param name
     * @return
     */
    @Override
    public Cache getCache(String name) {
        Cache cache = this.cacheMap.get(name);
        if (cache == null && this.dynamic) {
            synchronized (this.cacheMap) {
                cache = this.cacheMap.get(name);
                if (cache == null) {
                    cache = createCache(name);
                    this.cacheMap.put(name, cache);
                }
            }
        }
        return cache;
    }

    @Override
    public Collection<String> getCacheNames() {
        return Collections.unmodifiableSet(this.cacheMap.keySet());
    }

    protected Cache createCache(String name) {
        return new LayeringCache(name,isAllowNullValues(),this.redisOperations, getUsedFirstCache(name),createNativeCaffeineCache(name),redisCacheWriter,redisConfiguration);
    }

    /**
     * Create a native Caffeine Cache instance for the specified cache name.
     *
     * @param name the name of the cache
     * @return the native Caffeine Cache instance
     */
    protected com.github.benmanes.caffeine.cache.Cache<Object, Object> createNativeCaffeineCache(String name) {
        return getCaffeine(name).build();
    }

    /**
     * 使用该CacheManager的当前状态重新创建已知的缓存。
     */
    private void refreshKnownCaches() {
        for (Map.Entry<String, Cache> entry : this.cacheMap.entrySet()) {
            entry.setValue(createCache(entry.getKey()));
        }
    }

    /**
     * 设置是否允许Cache的值为null
     *
     * @param allowNullValues
     */
    public void setAllowNullValues(boolean allowNullValues) {
        if (this.allowNullValues != allowNullValues) {
            this.allowNullValues = allowNullValues;
            refreshKnownCaches();
        }
    }

    /**
     * 获取是否允许Cache的值为null
     *
     * @return
     */
    public boolean isAllowNullValues() {
        return this.allowNullValues;
    }

    /**
     * 根据缓存名称设置一级缓存的有效时间和刷新时间，单位秒
     *
     * @param firstCacheSettings
     */
    public void setFirstCacheSettings(Map<String, FirstCacheSetting> firstCacheSettings) {
        this.firstCacheSettings = (!CollectionUtils.isEmpty(firstCacheSettings) ? new ConcurrentHashMap<>(firstCacheSettings) : null);
    }

    /**
     * 获取是否使用一级缓存，默认是true
     */
    public boolean getUsedFirstCache(String name) {
        SecondaryCacheSetting secondaryCacheSetting = null;
        if (!CollectionUtils.isEmpty(secondaryCacheSettings)) {
            secondaryCacheSetting = secondaryCacheSettings.get(name);
        }

        return secondaryCacheSetting != null ? secondaryCacheSetting.getUsedFirstCache() : true;
    }

    public void setCaffeineSpec(CaffeineSpec caffeineSpec) {
        Caffeine<Object, Object> cacheBuilder = Caffeine.from(caffeineSpec);
        if (!ObjectUtils.nullSafeEquals(this.cacheBuilder, cacheBuilder)) {
            this.cacheBuilder = cacheBuilder;
            refreshKnownCaches();
        }
    }
    private Caffeine<Object, Object> getCaffeine(String name) {
        if (!CollectionUtils.isEmpty(firstCacheSettings)) {
            FirstCacheSetting firstCacheSetting = firstCacheSettings.get(name);
            if (firstCacheSetting != null && StringUtils.isEmpty(firstCacheSetting.getCacheSpecification())) {
                // 根据缓存名称获取一级缓存配置
                return Caffeine.from(CaffeineSpec.parse(firstCacheSetting.getCacheSpecification()));
            }
        }
        return this.cacheBuilder;
    }
}
