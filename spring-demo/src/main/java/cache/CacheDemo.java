package cache;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *  缓存demo
 * @author 孟星魂, mengxinghun@izjjf.cn
 * @create 2020/4/20 8:24
 **/
@Component
@EnableCaching
public class CacheDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("cache" , "bean");
        CacheDemo cacheDemo = context.getBean(CacheDemo.class);
        for (int i = 0; i < 300; i++) {
            cacheDemo.cacheput(i + "");
        }
        for (int i = 0; i < 300; i++) {
            cacheDemo.cacheable(i + "");
        }
        System.out.println(cacheDemo.cacheable("2"));
        System.out.println("---------------------------------------------------------------------");
        System.out.println(cacheDemo.cacheable("2"));
        System.out.println("---------------------------------------------------------------------");
        System.out.println(cacheDemo.cacheput("2"));
        System.out.println("---------------------------------------------------------------------");
        System.out.println(cacheDemo.cacheable("2"));
        System.out.println("---------------------------------------------------------------------");
        System.out.println(cacheDemo.cacheEvict("2"));
        System.out.println("---------------------------------------------------------------------");
        System.out.println(cacheDemo.cacheable("2"));
    }

    @Cacheable(cacheNames = "test" , key = "'test'+#id")
    public String cacheable(String id) {
        StringBuilder builder = new StringBuilder("cacheable");
        System.out.println("compute ++++++++++++++++++++"+id);
        builder.append("++").append(id);
        System.out.println("compute --------------------" +id);
        builder.append("--").append(id);
        return builder.toString();
    }
    @CachePut(cacheNames = "test2" , key = "'test'+#id")
    public String cacheput(String id) {
        StringBuilder builder = new StringBuilder("cacheput");
        System.out.println("cacheput ++++++++++++++++++++"+id);
        builder.append("++").append(id);
        System.out.println("cacheput --------------------" +id);
        builder.append("--").append(id);
        return builder.toString();
    }
    @CacheEvict(cacheNames = "test2" , key = "'test'+#id")
    public String cacheEvict(String id) {
        StringBuilder builder = new StringBuilder("cacheEvict");
        System.out.println("cacheEvict ++++++++++++++++++++"+id);
        builder.append("++").append(id);
        System.out.println("cacheEvict --------------------" +id);
        builder.append("--").append(id);
        return builder.toString();
    }

    @Bean
    public Cache testCache() {
        ConcurrentMapCache cache = new ConcurrentMapCache("test");
        return cache;
    }
    @Bean
    public Cache test2Cache() {
        ConcurrentMapCache cache = new ConcurrentMapCache("test2");
        return cache;
    }
    @Bean
    public CacheManager getCacheManager(@Qualifier("testCache") Cache cache , @Qualifier("test2Cache") Cache cache2) {
        SimpleCacheManager manager = new SimpleCacheManager();
        List<Cache> caches = new ArrayList<>();
        caches.add(cache);
        caches.add(cache2);
        manager.setCaches(caches);
        return manager;
    }
}
