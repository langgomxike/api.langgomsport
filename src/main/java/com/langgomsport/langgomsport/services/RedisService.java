package com.langgomsport.langgomsport.services;

import redis.clients.jedis.Jedis;

public class RedisService {

    public static void main(String[] args) {
        String redisHost = "localhost";
        int redisPort = 6379;

        try(Jedis jedis = new Jedis(redisHost, redisPort)) {
            jedis.set("key", "value");
            System.out.println("Redis Value: " + jedis.get("key"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
