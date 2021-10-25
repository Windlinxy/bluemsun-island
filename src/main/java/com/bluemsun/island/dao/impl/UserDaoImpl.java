package com.bluemsun.island.dao.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.mapper.UserMapper;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * 用户接口实现类
 *
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
            int rowsAffected = getMapper(UserMapper.class).insert(user);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
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

    @Override
    public int updateImageUrl(User user) {
        try {
            int rowsAffected = getMapper(UserMapper.class).updateImageUrl(user);
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

    @Override
    public int updateUser(User user) {
        try {
            int rowsAffected = getMapper(UserMapper.class).updateUserSelective(user);
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

    @Override
    public List<User> queryAllUsers(int startIndex,int pageSize) {
        List<User> userList;
        try {
            userList = getMapper(UserMapper.class).selectAllUser(startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public List<User> queryAllUsersByOrder(int startIndex,int pageSize,String col,String order) {
        List<User> userList;
        try {
            userList = getMapper(UserMapper.class).selectAllUserByOrder(col,order,startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }

    @Override
    public User queryOneUser(User user) {
        try {
            user = getMapper(UserMapper.class).selectOneByPhoneNumberAndPassword(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User queryOneUser(int userId) {
        User user;
        try {
            user = getMapper(UserMapper.class).selectOneById(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public int getAllUsersCount(){
        int count;
        try {
            count = getMapper(UserMapper.class).getAllUsersCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }


}
