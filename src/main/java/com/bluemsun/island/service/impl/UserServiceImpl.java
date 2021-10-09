package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.impl.UserDaoImpl;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: BulemsunIsland
 * @description: 用户服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDaoImpl userDao;

    @Override
    public int addUser(User user) {
        userDao.insert(user);
        return ReturnCode.OP_SUCCESS;
    }


}
