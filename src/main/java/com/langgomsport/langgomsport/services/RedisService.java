package com.langgomsport.langgomsport.services;

import com.langgomsport.langgomsport.configs.RedisConfig;
import org.springframework.beans.factory.annotation.Value;
import redis.clients.jedis.Jedis;

public class RedisService {

  public static void main(String[] args) {

    try (Jedis jedis = new Jedis(RedisConfig.redisHost, RedisConfig.redisPort)) {
      jedis.set("key", "value");
      System.out.println("Redis Value: " + jedis.get("key"));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
