package com.bluemsun.island.service;

import com.bluemsun.island.entity.User;

/**
 * 用户服务借口
 *
 * @program: BulemsunIsland
 * @description: 用户服务
 * @author: Windlinxy
 * @create: 2021-10-05 11:31
 **/
public interface UserService {

    /**
     * 增加用户服务
     *
     * @param user 用户
     * @return 返回状态码
     */
    int addUser(User user);

    /**
     * 判断是否是已注册用户
     *
     * @param user 用户（手机号，密码）
     * @return com.bluemsun.island.entity.User 用户信息
     * @date 17:56 2021/10/17
     **/
    User isUser(User user);


    /**
     * 改变用户url
     *
     * @param token    token令牌
     * @param imageUrl 图片url
     * @return int
     * @date 18:03 2021/10/19
     **/
    int changeImageUrl(String token, String imageUrl);

    /**
     * 获取缓存中的用户
     *
     * @date 20:51 2021/10/19
     * @param id 用户id
     * @return com.bluemsun.island.entity.User 用户
     **/
    User getUserInCache(int id);

    /**
     * 修改部分用户信息(*)
     *
     * @date 15:35 2021/10/20
     * @param token 用户令牌
     * @param  user 用户（部分修改的信息）
     * @return com.bluemsun.island.entity.User 用户（全部信息）
     **/
    User changeUser(String token, User user);
}
