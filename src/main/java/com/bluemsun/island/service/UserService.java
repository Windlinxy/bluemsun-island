package com.bluemsun.island.service;

import com.bluemsun.island.entity.User;

/**
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
}
