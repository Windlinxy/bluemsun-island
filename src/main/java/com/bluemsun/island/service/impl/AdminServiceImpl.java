package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 管理员服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:40
 **/
public class AdminServiceImpl implements AdminService {
    private int operationJudCode = 0;
    @Autowired
    private UserDao userDao;
@Override
    public int deleteUser(int userId){
        operationJudCode =  userDao.deleteUserById(userId);
        return operationJudCode;
    }
}
