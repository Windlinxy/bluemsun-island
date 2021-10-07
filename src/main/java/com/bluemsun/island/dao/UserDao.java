package com.bluemsun.island.dao;

import com.bluemsun.island.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @program: BulemsunIsland
 * @description: 用户数据持久层
 * @author: Windlinxy
 * @create: 2021-10-05 11:32
 **/
@Repository
public interface UserDao {

    /**
     * 增加一个用户
     *
     * @param user 用户
     * @return 返回状态码
     */
    int insertUser(User user);

}
