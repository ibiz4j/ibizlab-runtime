package cn.ibizlab.util.cache.setting;

import com.github.benmanes.caffeine.cache.CaffeineSpec;

public class FirstCacheSetting {

    /**
     * 一级缓存配置，配置项请点击这里 {@link CaffeineSpec#configure(String, String)}
     * @param cacheSpecification
     */
    public FirstCacheSetting(String cacheSpecification) {
        this.cacheSpecification = cacheSpecification;
    }

    private String cacheSpecification;

    public String getCacheSpecification() {
        return cacheSpecification;
    }
}
