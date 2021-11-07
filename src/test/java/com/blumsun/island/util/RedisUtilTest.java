package com.blumsun.island.util;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.util.RedisUtil;
import org.junit.Test;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: redis测试
 * @author: Windlinxy
 * @create: 2021-11-04 15:53
 **/
public class RedisUtilTest {
    @Test
    public void testRedisSetObject() {
        RedisUtil.setObject(1, new Post(1, 2));
        //System.out.println(RedisUtil.getObject("post:2",Post.class));
    }

    @Test
    public void addUserInHyperLogLog() {
        RedisUtil.pfAdd("postAccess:" + 1 + ":" + 2, 45 + "");
        System.out.println(RedisUtil.pfCount("postAccess:" + 1 + ":" + 2));
    }

    @Test
    public void testScan() {
        List<String> postKeys = RedisUtil.scanPost();
        for (String postKey : postKeys) {
            System.out.println(RedisUtil.getObject(postKey, PostResult.class));
        }
    }
}
