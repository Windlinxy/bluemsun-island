package com.bluemsun.island.dao.impl;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.mapper.UserMapper;
import com.bluemsun.island.entity.User;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: UserDao接口实现类
 * @author: Windlinxy
 * @create: 2021-10-07 20:18
 **/
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {


    private <T> T getMapper(Class<T> T){
        return (T) getSqlSession().getMapper(T);
    }

    @Override
    public int insert(User user) {
        int rowsAffected = getMapper(UserMapper.class).insert(user);
        return 0;
    }

    @Override
    public List<User> select() {

        return null;
    }

    @Override
    public int delete(int id) {
        return 0;
    }
}
