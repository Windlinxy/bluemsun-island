package com.bluemsun.island.util;

import com.bluemsun.island.entity.User;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

/**
 * @program: BulemsunIsland
 * @description: redis工具类
 * @author: Windlinxy
 * @create: 2021-10-13 20:34
 **/
public class RedisUtil {

    private static final String AUTH = "windlinxy";
    private static final JedisPool POOL;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数，默认是1万
        config.setMaxTotal(1024);
        //最大空闲实例数
        config.setMaxIdle(200);
        //等连接池给连接的最大时间，毫秒，设成-1表示永远不超时
        config.setMaxWaitMillis(10000);
        //borrow一个实例的时候，是否提前进行validate操作
        config.setTestOnBorrow(true);

        int port = 6379;
        String ip = "localhost";
        int timeout = 10000;
        POOL = new JedisPool(config, ip, port, timeout, AUTH);
    }

    //得到redis连接

    public synchronized static Jedis getJedis() {
        return POOL.getResource();
    }


    public static void close(final Jedis redis) {
        if (redis != null) {
            redis.close();
        }
    }

    public static void test() {
        Jedis jedis = getJedis();
        jedis.set("addr", "北京");
        System.out.println(jedis.get("addr"));
        close(jedis);
    }

    public static void set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(key, value);
        close(jedis);
    }

    public static void set(String key, Object obj) {
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        jedis.set(key, gson.toJson(obj));
        close(jedis);
    }

    public static String getString(String key) {
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        close(jedis);
        return value;
    }

    public static User getUser(long userId) {
        Gson gson = new Gson();
        return gson.fromJson(getString("user" + userId), User.class);
    }

    public static long addSet(String key, String... members) {
        Jedis jedis = getJedis();
        long reply=jedis.sadd(key, members);
        close(jedis);
        return reply;
    }

    public static String getZ(String key) {
        Jedis jedis = getJedis();
        Set<String> set = jedis.smembers(key);
        close(jedis);
        return set.toString();
    }
}


