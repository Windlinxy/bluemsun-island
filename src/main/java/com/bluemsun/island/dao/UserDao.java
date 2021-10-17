package com.bluemsun.island.dao;

import com.bluemsun.island.entity.User;

import java.util.List;

/**
 * 用户数据持久层
 *
 * @program: BulemsunIsland
 * @description: 用户数据持久层
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/
public interface UserDao {

    /**
     * 添加用户
     *
     * @date 16:54 2021/10/10
     * @param user 用户
     * @return int 操作码
     **/
    int insertUser(User user);

    /**
     * 获取所有用户
     *
     * @date 16:55 2021/10/10
     * @return java.util.List<com.bluemsun.island.entity.User>
     **/
    List<User> selectAllUsers();

    /**
     * 根据id删除用户
     *
     * @date 16:55 2021/10/10
     * @param id 用户id
     * @return int 操作判断码
     **/
    int deleteUserById(int id);

    /**
     * 根据电话号码与密码查询用户
     *
     * @date 17:41 2021/10/17
     * @param user 用户（手机号，密码）
     * @return com.bluemsun.island.entity.User 完整用户信息
     **/
    User queryOneUser(User user);

}
