package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.SQLException;

/**
 * @program: BulemsunIsland
 * @description: 用户服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/
public class UserServiceImpl implements UserService {
    private int operationJudCode = 0;
    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        operationJudCode = userDao.insertUser(user);
        return operationJudCode;
    }

    @Override
    public User isUser(User user) {
        User userInDatabase;
        userInDatabase = userDao.queryOneUser(user);
        return userInDatabase;
    }


}
