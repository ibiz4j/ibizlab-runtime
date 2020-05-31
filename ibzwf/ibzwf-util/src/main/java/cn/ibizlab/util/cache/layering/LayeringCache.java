package cn.ibizlab.util.cache.layering;

import cn.ibizlab.util.enums.RedisChannelTopic;
import cn.ibizlab.util.cache.listener.RedisPublisher;
import cn.ibizlab.util.cache.redis.CustomizedRedisCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.springframework.cache.support.NullValue;
import org.springframework.data.redis.cache.RedisCache;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.core.RedisOperations;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;
/**
 * 缓存分层类
 * 1级缓存为caffeine
 * 2级缓存为redis
 */
public class LayeringCache extends AbstractValueAdaptingCache {
    Logger logger = LoggerFactory.getLogger(LayeringCache.class);

    /**
     * 缓存的名称
     */
    private final String name;

    /**
     * 是否使用一级缓存
     */
    private boolean usedFirstCache = true;

    /**
     * redi缓存
     */
    private  RedisCache redisCache;
    /**
     * Caffeine缓存
     */
    private final CaffeineCache caffeineCache;

    RedisOperations<? extends Object, ? extends Object> redisOperations;

    /**
     * @param name              缓存名称
     * @param allowNullValues   是否允许存NULL，默认是false
     * @param usedFirstCache    是否使用一级缓存，默认是true
     * @param caffeineCache     Caffeine缓存
     */
    public LayeringCache(String name , boolean allowNullValues,RedisOperations redisOperations, boolean usedFirstCache,  com.github.benmanes.caffeine.cache.Cache<Object, Object> caffeineCache,
                         RedisCacheWriter redisCacheWriter, RedisCacheConfiguration configuration) {
        super(allowNullValues);
        this.name = name;
        this.usedFirstCache = usedFirstCache;
        this.redisCache = new CustomizedRedisCache(name, redisCacheWriter, configuration);
        this.caffeineCache = new CaffeineCache(name, caffeineCache, allowNullValues);
        this.redisOperations=redisOperations;
    }

    public CaffeineCache getFirstCache() {
        return this.caffeineCache;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Object getNativeCache() {
        return this;
    }

    @Override
    public ValueWrapper get(Object key) {

        ValueWrapper wrapper = null;
        if (usedFirstCache) {
            // 查询一级缓存
            wrapper = caffeineCache.get(key);
            logger.debug("查询一级缓存 key:{}，value:{}", key,wrapper);
        }
        if (wrapper == null) {
            // 查询二级缓存
            wrapper = redisCache.get(key);
            caffeineCache.put(key, wrapper == null ? null : wrapper.get());
            logger.debug("查询二级缓存,并将数据放到一级缓存。 key:{}", key);
        }
        return wrapper;
    }

    @Override
    public <T> T get(Object key, Class<T> type) {
        T value = null;
        if (usedFirstCache) {
            // 查询一级缓存
            value = caffeineCache.get(key, type);
            logger.debug("查询一级缓存 key:{}", key);
        }
        if (value == null) {
            // 查询二级缓存
            value = redisCache.get(key, type);
            caffeineCache.put(key, value);
            logger.debug("查询二级缓存,并将数据放到一级缓存。 key:{}", key);
        }
        return value;
    }

    @SuppressWarnings("unchecked")
	@Override
    public <T> T get(Object key, Callable<T> valueLoader) {
        T value = null;
        if (usedFirstCache) {
            // 查询一级缓存,如果一级缓存没有值则调用getForSecondaryCache(k, valueLoader)查询二级缓存
            value = (T) caffeineCache.getNativeCache().get(key, k -> getForSecondaryCache(k, valueLoader));
        } else {
            // 直接查询二级缓存
            value = (T) getForSecondaryCache(key, valueLoader);
        }

        if (value instanceof NullValue) {
            return null;
        }
        return value;
    }

    @Override
    public void put(Object key, Object value) {
        if (usedFirstCache) {
            caffeineCache.put(key, value);
        }
        redisCache.put(key, value);
    }

    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        if (usedFirstCache) {
            caffeineCache.putIfAbsent(key, value);
        }
        return redisCache.putIfAbsent(key, value);
    }

    @Override
    public void evict(Object key) {
        redisCache.evict(key); //清除redis中的二级缓存
        if (usedFirstCache) {
            caffeineCache.evict(key);//清除本机一级缓存
            Map<String, Object> message = new HashMap<>();
            message.put("cacheName", name);
            message.put("key", key);
            RedisPublisher redisPublisher = new RedisPublisher(redisOperations, RedisChannelTopic.REDIS_CACHE_DELETE_TOPIC.getChannelTopic());// 创建redis发布者
            redisPublisher.publisher(message);//发布消息，清除其它集群机器中的一级缓存
        }
        logger.debug(String.format("清除二级缓存数据[%s]", key));
    }

    @Override
    public void clear() {
        redisCache.clear(); //清除redis中的二级缓存
        if (usedFirstCache) {
            caffeineCache.clear();//清除本机一级缓存
            Map<String, Object> message = new HashMap<>();
            message.put("cacheName", name);
            RedisPublisher redisPublisher = new RedisPublisher(redisOperations, RedisChannelTopic.REDIS_CACHE_CLEAR_TOPIC.getChannelTopic());// 创建redis发布者
            redisPublisher.publisher(message);//发布消息，清除其它集群机器中的一级缓存
        }
    }

    @Override
    protected Object lookup(Object key) {
        Object value = null;
        if (usedFirstCache) {
            value = caffeineCache.get(key);
            logger.debug("查询一级缓存 key:{}", key);
        }
        if (value == null) {
            value = redisCache.get(key);
            logger.debug("查询二级缓存 key:{}", key);
        }
        return value;
    }

    /**
     * 查询二级缓存
     * @param key
     * @param valueLoader
     * @return
     */
    private <T> Object getForSecondaryCache(Object key, Callable<T> valueLoader) {
        T value = redisCache.get(key, valueLoader);
        logger.debug("查询二级缓存 key:{}", key);
        return toStoreValue(value);
    }
}
