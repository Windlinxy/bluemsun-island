package com.bluemsun.island.util;

import org.springframework.data.redis.connection.RedisConnection;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;

import java.util.Set;

/**
 * @program: BulemsunIsland
 * @description: redis工具类
 * @author: Windlinxy
 * @create: 2021-10-13 20:34
 **/
public class RedisUtil{

    private static Jedis jedis = getJedis();

    private static Jedis getJedis(){
        JedisShardInfo shardInfo = new JedisShardInfo("59.110.24.11");
        shardInfo.setPassword("windlinxy");
        return new Jedis(shardInfo);
    }

    public static void test(){
        jedis.set("addr","北京");
        System.out.println(jedis.get("addr"));
    }

    public static void set(String key,String value){
        jedis.set(key,value);
    }

    public static String get(String key){
        return jedis.get(key);
    }

    public static void addSet(String key,String ... members){
        jedis.sadd(key,members);
    }

    public static String getZ(String key){
        Set<String> set = jedis.smembers(key);
        return set.toString();
    }
}


