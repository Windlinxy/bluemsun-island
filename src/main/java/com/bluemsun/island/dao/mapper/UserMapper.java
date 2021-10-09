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
    int insert(User user);

    List<User> select();

    int delete(int id);
}
