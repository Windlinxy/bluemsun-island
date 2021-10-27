package com.bluemsun.island.dao;

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
public class UserDao extends SqlSessionDaoSupport {
    private int operationCode = 0;

    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    /**
     * 添加用户
     *
     * @param user 用户
     * @return int 操作码
     * @date 16:54 2021/10/10
     **/
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

    /**
     * 根据id删除用户
     *
     * @param id 用户id
     * @return int 操作判断码
     * @date 16:55 2021/10/10
     **/
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

    /**
     * 上传用户头像地址
     *
     * @param user 用户（id，imageUrl）
     * @return int 操作码
     * @date 17:49 2021/10/19
     **/
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

    /**
     * 更新用户信息
     *
     * @param user 用户（传啥有啥）
     * @return int 影响行数
     * @date 9:09 2021/10/20
     **/
    public int updateUser(User user) {
        try {
            int rowsAffected = getMapper(UserMapper.class).updateOneSelective(user);
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

    /**
     * 获取所有用户
     *
     * @return java.util.List<com.bluemsun.island.entity.User>
     * @date 16:55 2021/10/10
     **/
    public List<User> queryAllUsers(int startIndex,int pageSize) {
        List<User> userList;
        try {
            userList = getMapper(UserMapper.class).selectAll(startIndex,pageSize);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
//    public List<User> queryAllUsersByOrder(int startIndex,int pageSize,String col,String order) {
//        List<User> userList;
//        try {
//            userList = getMapper(UserMapper.class).selectAllUserByOrder(col,order,startIndex,pageSize);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        return userList;
//    }

    /**
     * 根据电话号码与密码查询用户
     *
     * @param user 用户（手机号，密码）
     * @return com.bluemsun.island.entity.User 完整用户信息
     * @date 17:41 2021/10/17
     **/
    public User queryOneUser(User user) {
        try {
            user = getMapper(UserMapper.class).selectOneByPhoneNumberAndPassword(user);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    /**
     * 根据id获得用户
     *
     * @param userId 用户id
     * @return User 获得用户
     * @date 16:10 2021/10/23
     **/
    public User queryOneUser(int userId) {
        User user;
        try {
            user = getMapper(UserMapper.class).selectOneById(userId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    /**
     * 获得用户总数
     *
     * @return int 用户总数
     * @date 20:35 2021/10/22
     **/
    public int getAllUsersCount(){
        int count;
        try {
            count = getMapper(UserMapper.class).getAllCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int getUsersCountByName(String name){
        int count;
        try {
            count = getMapper(UserMapper.class).getCountByUserName(name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public List<User> queryUsersByName(int startIndex,int pageSize,String name) {
        List<User> userList;
        try {
            userList = getMapper(UserMapper.class).selectByUserName(startIndex,pageSize,name);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return userList;
    }
}
