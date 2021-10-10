package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.User;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 用户映射
 * @author: Windlinxy
 * @create: 2021-10-09 17:23
 **/
public interface UserMapper {
    /**
     * 插入用户
     *
     * @param user 用户
     * @return int  数据库改动行数
     * @date 16:03 2021/10/10
     **/
    int insert(User user);

    /**
     * 获取所有用户
     *
     * @return java.util.List<com.bluemsun.island.entity.User>
     * @date 16:02 2021/10/10
     **/
    List<User> select();

    /**
     * 根据id删除用户记录
     *
     * @date 16:56 2021/10/10
     * @param id 用户id
     * @return int 修改行数
     **/
    int deleteById(int id);

    /**
     * 根据手机号和密码查找用户
     *
     * @date 16:57 2021/10/10
     * @param user 用户
     * @return com.bluemsun.island.entity.User 用户
     **/
    User queryOneByPhoneNumberAndPassword(User user);
}
