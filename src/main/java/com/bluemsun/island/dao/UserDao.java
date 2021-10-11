package com.bluemsun.island.dao;

import com.bluemsun.island.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
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

    User queryOneUser(User user);

}
