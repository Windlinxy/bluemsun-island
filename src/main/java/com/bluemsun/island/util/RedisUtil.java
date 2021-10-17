package com.bluemsun.island.util;

import com.bluemsun.island.entity.User;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @program: BulemsunIsland
 * @description: redis工具类
 * @author: Windlinxy
 * @create: 2021-10-13 20:34
 **/
public class RedisUtil{

    private static final Jedis jedis = RedisUtilT.getJedis();


    public static void test(){
        jedis.set("addr","北京");
        System.out.println(jedis.get("addr"));
    }

    public static void set(String key,String value){
        jedis.set(key,value);
    }

    public static void set(String key,Object obj){
        Gson gson = new Gson();
        jedis.set(key,gson.toJson(obj));
    }

    public static String getString(String key){
            return jedis.get(key);
    }

    public static User getUser(long userId){
        Gson gson = new Gson();
        return gson.fromJson(getString("user"+userId),User.class);
    }

    public static void addSet(String key,String ... members){
        jedis.sadd(key,members);
    }

    public static String getZ(String key){
        Set<String> set = jedis.smembers(key);
        return set.toString();
    }
}


