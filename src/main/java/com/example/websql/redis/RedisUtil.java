package com.example.websql.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis操作类
 */
public class RedisUtil {

    private static String redisAddress = "127.0.0.1";
    private static int redisPort = 6379;
    private static int redisTimeout = 2000;
    private static JedisPool pool;

    public RedisUtil() {

    }

    public static void connectRedis() {
        pool = new JedisPool(new JedisPoolConfig(), redisAddress, redisPort, redisTimeout);
    }

    public static Jedis getJedis() {

        if (pool == null) {
            connectRedis();
        }

        return pool.getResource();
    }
}
