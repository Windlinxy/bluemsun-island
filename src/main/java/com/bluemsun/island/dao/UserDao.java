package com.bluemsun.island.dao;

import com.bluemsun.island.entity.User;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 用户数据持久层
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/

public interface UserDao {

    int insert(User user);

    List<User> select();

    int delete(int id);

}
