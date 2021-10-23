package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.AdminService;
import com.bluemsun.island.util.RedisUtil;
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



    @Override
    public int changeUserStatus(int id,int status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        operationJudCode = userDao.updateUser(user);
        return operationJudCode;
    }

    @Override
    public User getUserInfo(int userId){
        User userAfter;
        User userInCache = RedisUtil.getUser(userId);
        if(userInCache!=null){
            userAfter = userInCache;
        }else {
            User userInDatabase = userDao.queryOneUser(userId);
            if(userInDatabase != null){
                userAfter = userInDatabase;
                RedisUtil.setUser(userId,userInDatabase);
            }else {
                userAfter = null;
            }
        }
        return userAfter;
    }

}
