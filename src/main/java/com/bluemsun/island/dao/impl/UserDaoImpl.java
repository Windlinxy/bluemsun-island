package com.bluemsun.island.dao.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.mapper.UserMapper;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: UserDao接口实现类
 * @author: Windlinxy
 * @create: 2021-10-07 20:18
 **/
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {
    private int operationCode = 0;

    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    @Override
    public int insertUser(User user) {
        try {
            getMapper(UserMapper.class).insert(user);
            operationCode = ReturnCode.OP_SUCCESS;
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
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
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
            throw new RuntimeException(e);
        }
        return operationCode;
    }


}
