package com.business.dubbo.charge.cache;

import com.business.api.entity.DictionaryBusinessInfo;
import com.business.dubbo.charge.service.DictionaryBusinessInfoService;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by chenll on 2017/7/15.
 */
@Service
public class BusinessTypeLocalCache {

    private static final int EXPIRETIME = 5;

    @Autowired
    private DictionaryBusinessInfoService dictionaryBusinessInfoService;

    private LoadingCache<Integer,DictionaryBusinessInfo> cache;

    @PostConstruct
    public void init(){
        cache= CacheBuilder.newBuilder().
                expireAfterWrite(EXPIRETIME, TimeUnit.MINUTES)
                .maximumSize(30).build(new CacheLoader<Integer, DictionaryBusinessInfo>() {
                    @Override
                    public DictionaryBusinessInfo load(Integer key) throws Exception {
                        return dictionaryBusinessInfoService.findByType(key);
                    }
                });

    }

    public DictionaryBusinessInfo getBusinessType(Integer type) throws ExecutionException {
        return cache.get(type);
    }
}
