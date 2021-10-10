package com.bluemsun.island.dao.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.mapper.UserMapper;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: UserDao接口实现类
 * @author: Windlinxy
 * @create: 2021-10-07 20:18
 **/
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    private int optionCode = 0;

    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    @Override
    public int insertUser(User user) {
        try {
            int rowsAffected = getMapper(UserMapper.class).insert(user);
            if (rowsAffected == 1) {
                optionCode = ReturnCode.OP_SUCCESS;
            } else {
                optionCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            optionCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return optionCode;
    }

    @Override
    public List<User> selectAllUsers() {
        List<User> userList;

        try {
            userList = getMapper(UserMapper.class).select();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public int deleteUserById(int id) {
        try {
            int rowsAffected = getMapper(UserMapper.class).deleteById(id);
            if (rowsAffected == 1) {
                optionCode = ReturnCode.OP_SUCCESS;
            } else {
                optionCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            optionCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return optionCode;
    }


}
