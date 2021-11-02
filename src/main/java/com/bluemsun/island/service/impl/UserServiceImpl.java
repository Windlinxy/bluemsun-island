package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.UserForSectionDao;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.UserService;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;

/**
 * 用户服务接口实现类
 *
 * @program: BulemsunIsland
 * @description: 用户服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/
public class UserServiceImpl implements UserService {
    private int operationJudCode = 0;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserForSectionDao userForSectionDao;

    @Override
    public int addUser(User user) {
        operationJudCode = userDao.insertUser(user);
        return operationJudCode;
    }

    @Override
    public User isUser(User user) {
        User userInDatabase;
        userInDatabase = userDao.queryOneUser(user);
        if (userInDatabase != null) {
            //将用户信息写进缓存
            RedisUtil.setUser(userInDatabase.getId(), userInDatabase);
        }


        return userInDatabase;
    }


    @Override
    public int changeImageUrl(String token, String imageUrl) {
        int id = JwtUtil.getUserId(token);
        User userInCache = RedisUtil.getUser(id);
        userInCache.setImageUrl(imageUrl);
        RedisUtil.setUser(id, userInCache);
        operationJudCode = userDao.updateImageUrl(userInCache);
        return operationJudCode;
    }

    @Override
    public User getUserInCache(int id) {
        return RedisUtil.getUser(id);
    }

    @Override
    public User changeUser(int id, User user) {
        user.setId(id);
        operationJudCode = userDao.updateUser(user);
        User userInCache = RedisUtil.getUser(id);
        if (operationJudCode == 1 && user.getStatus() == 0) {

            //使用反射更新缓存中用户数据
            Field[] fields = user.getClass().getDeclaredFields();
            Field[] fieldsInCache = userInCache.getClass().getDeclaredFields();
            try {
                for (int i = 0; i < fields.length; i++) {
                    fields[i].setAccessible(true);
                    fieldsInCache[i].setAccessible(true);
                    if (fields[i].get(user) != null) {
                        fieldsInCache[i].set(userInCache, fields[i].get(user));
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            RedisUtil.setUser(id, userInCache);
            return userInCache;
        } else {
            return null;
        }
    }

    @Override
    public boolean judUserForSectionMaster(int userId, String sectionName) {
        int jud = userForSectionDao.getUserForSectionNameCount(userId, sectionName);
        if (jud == 1) {
            return true;
        } else {
            return false;
        }
    }


}
