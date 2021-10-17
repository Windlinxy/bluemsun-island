package com.bluemsun.island.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @program: BulemsunIsland
 * @description: T
 * @author: Windlinxy
 * @create: 2021-10-16 21:52
 **/
public class RedisUtilT {

    private RedisUtilT() {
    }

    //进入redis的密码

    private static final String AUTH = "windlinxy";
    private static JedisPool pool = null;

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
        pool = new JedisPool(config, ip, port, timeout,AUTH);
    }

    //得到redis连接

    public synchronized static Jedis getJedis() {
        if (pool != null) {
            return pool.getResource();
        } else {
            return null;
        }
    }

    //关闭redis连接

    public static void close(final Jedis redis) {
        if (redis != null) {
            redis.close();
        }
    }


}
