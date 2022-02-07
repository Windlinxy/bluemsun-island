package com.bluemsun.island.util;

import com.bluemsun.island.entity.User;
import com.google.gson.Gson;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.params.ScanParams;
import redis.clients.jedis.resps.ScanResult;

import java.util.List;

/**
 * redis工具类
 *
 * @program: BulemsunIsland
 * @description: redis工具类
 * @author: Windlinxy
 * @create: 2021-10-13 20:34
 **/
public class RedisUtil {

    private static final String AUTH = "windlinxy";
    private static final JedisPool POOL;
    private static final int KEY_EXPIRE = 3600;

    static {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数，默认是1万
        config.setMaxTotal(1024);
        //最大空闲实例数
        config.setMaxIdle(200);
        //borrow一个实例的时候，是否提前进行validate操作
        config.setTestOnBorrow(true);

        int port = 6379;
        String ip = "localhost";
        int timeout = 10000;
        POOL = new JedisPool(config, ip, port, timeout, AUTH);
    }


    /**
     * 获得redis连接
     *
     * @return redis.clients.jedis.Jedis redis连接（jedis）
     **/
    public synchronized static Jedis getJedis() {
        return POOL.getResource();
    }


    public static void close(final Jedis redis) {
        if (redis != null) {
            redis.close();
        }
    }

    /**
     * 设置键值对
     *
     * @param key   键
     * @param value 值
     * @date 19:12 2021/10/17
     **/
    public static void set(String key, String value) {
        Jedis jedis = getJedis();
        jedis.set(key, value);
        close(jedis);
    }

    /**
     * 将对象以键值对的形式存储(1小时）
     *
     * @param id  userId
     * @param obj 对象
     * @date 19:10 2021/10/17
     **/
    public static void setUser(int id, Object obj) {
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        String key = "users:"+id;
        jedis.set(key, gson.toJson(obj));
        jedis.expire(key,KEY_EXPIRE);
        close(jedis);
    }

    /**
     * 将对象存进缓存
     *
     * @param key 键
     * @param obj 对象
     * @date 20:40 2021/10/19
     **/
    public static void setObject(String key, Object obj) {
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        jedis.set(key, gson.toJson(obj));
        jedis.expire(key,KEY_EXPIRE);
        close(jedis);
    }

    public static <T> T getObject(String key, Class<T> cls){
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        close(jedis);
        return gson.fromJson(jedis.get(key),cls);
    }

    public static void setObject(int id, Object obj) {
        String key = obj.getClass().getSimpleName() +":"+id;
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        jedis.set(key, gson.toJson(obj));
        jedis.expire(key,KEY_EXPIRE);
        close(jedis);
    }

    public static <T> T getObject(int id, Class<T> cls){
        String key = cls.getSimpleName()+":"+id;
        Jedis jedis = getJedis();
        Gson gson = new Gson();
        close(jedis);
        return gson.fromJson(jedis.get(key),cls);
    }

    /**
     * 获得key的value（字符串）
     *
     * @param key 减
     * @return java.lang.String 值
     * @date 19:09 2021/10/15
     **/
    public static String getString(String key) {
        Jedis jedis = getJedis();
        String value = jedis.get(key);
        close(jedis);
        return value;
    }

    /**
     * 根据用户id获得用户
     *
     * @param userId 用户id
     * @return com.bluemsun.island.entity.User 用户详细信息
     * @date 19:09 2021/10/17
     **/
    public static User getUser(int userId) {
        Gson gson = new Gson();
        return  gson.fromJson(getString("users:" + userId), User.class);
    }

    public static void pfAdd(String key,String ...members){
        Jedis jedis = getJedis();
        jedis.pfadd(key,members);
        close(jedis);
    }

    public static int pfCount(String key){
        Jedis jedis = getJedis();
        int count = (int)jedis.pfcount(key);
        close(jedis);
        return count;
    }

    public static List<String> scanPost(){
        Jedis jedis = getJedis();
        ScanParams scanParams = new ScanParams();
        scanParams.match("PostResult:*");
        ScanResult<String> result = jedis.scan("0",scanParams);
        List<String> postKeys = result.getResult();
        close(jedis);
        return postKeys;
    }

    public void expire(String key,int time){
        Jedis jedis = getJedis();
        jedis.expire(key,time);
        close(jedis);
    }
}


