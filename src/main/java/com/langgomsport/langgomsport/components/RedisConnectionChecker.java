package com.langgomsport.langgomsport.components;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisConnectionChecker {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void checkRedisConnection() {
        try {
            redisTemplate.opsForValue().set("testKey", "testValue", 10, TimeUnit.SECONDS);
            String testValue = redisTemplate.opsForValue().get("testKey").toString();
            if ("testValue".equals(testValue)) {
                System.out.println("Redis connected successfully!");
            } else {
                System.out.println("Redis connection failed!");
            }
        } catch (Exception e) {
            System.err.println("Redis connection error: " + e.getMessage());
        }
    }
}
