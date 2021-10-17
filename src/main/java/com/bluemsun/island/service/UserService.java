package com.bluemsun.island.service;

import com.bluemsun.island.entity.User;

/**
 * 用户服务借口
 * @program: BulemsunIsland
 * @description: 用户服务
 * @author: Windlinxy
 * @create: 2021-10-05 11:31
 **/
public interface UserService {

    /**
     * 增加用户服务
     *
     * @param user  用户
     * @return      返回状态码
     */
    int addUser(User user);

    /**
     * 判断是否是已注册用户
     *
     * @date 17:56 2021/10/17
     * @param user 用户（手机号，密码）
     * @return com.bluemsun.island.entity.User 用户信息
     **/
    User isUser(User user);

}
