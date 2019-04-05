package com.hochbichler.cache;

import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

@Component
@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CacheService {
    @Resource
    private CacheService self;

    @Cacheable("authToken")
    public String getCurrentDate() {
        return new Date().toString();
    }

    @CachePut("authToken")
    public String resetCache() {
        return new Date().toString();
    }

    public String cacheDate() {
        return self.getCurrentDate();
    }
}
