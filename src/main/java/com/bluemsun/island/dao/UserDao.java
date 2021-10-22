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
     * @param user 用户
     * @return int 操作码
     * @date 16:54 2021/10/10
     **/
    int insertUser(User user);

    /**
     * 获取所有用户
     *
     * @return java.util.List<com.bluemsun.island.entity.User>
     * @date 16:55 2021/10/10
     **/
    List<User> queryAllUsers(int startIndex,int pageSize);


    /**
     * 根据电话号码与密码查询用户
     *
     * @param user 用户（手机号，密码）
     * @return com.bluemsun.island.entity.User 完整用户信息
     * @date 17:41 2021/10/17
     **/
    User queryOneUser(User user);

    /**
     * 上传用户头像地址
     *
     * @param user 用户（id，imageUrl）
     * @return int 操作码
     * @date 17:49 2021/10/19
     **/
    int updateImageUrl(User user);

    /**
     * 更新用户信息
     *
     * @date 9:09 2021/10/20
     * @param user 用户（传啥有啥）
     * @return int 影响行数
     **/
    int updateUser(User user);

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return int 操作判断码
     * @date 16:55 2021/10/10
     **/
    int deleteUserById(int id);

    /**
     * 获得用户总数
     *
     * @date 20:35 2021/10/22
     * @return int 用户总数
     **/
    int getAllUsersCount();
}
