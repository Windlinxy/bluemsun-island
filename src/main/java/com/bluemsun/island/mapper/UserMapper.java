package com.bluemsun.island.mapper;

import com.bluemsun.island.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户映射
 *
 * @program: BulemsunIsland
 * @description: 用户映射
 * @author: Windlinxy
 * @create: 2021-10-09 17:23
 **/
@Mapper
public interface UserMapper {
    /**
     * 插入用户
     *
     * @param user 用户
     * @return int  数据库改动行数
     * @date 16:03 2021/10/10
     **/
    int insert(User user);

    /**
     * 根据id删除用户记录
     *
     * @param id 用户id
     * @return int 修改行数
     * @date 16:56 2021/10/10
     **/
    int deleteById(int id);

    /**
     * 修改头像url
     *
     * @param user 用户（id，imageUrl）
     * @return int
     * @date 17:39 2021/10/19
     **/
    int updateImageUrl(User user);

    /**
     * 灵活修改用户信息
     * @param user  用户（灵活）
     * @return int
     * @date 14:35 2021/10/22
     **/
    int updateOneSelective(User user);

    /**
     * 根据手机号和密码查找用户
     *
     * @param user 用户
     * @return com.bluemsun.island.entity.User 用户
     * @date 16:57 2021/10/10
     **/
    User selectOneByPhoneNumberAndPassword(User user);

    /**
     * 获取所有用户
     * @param startIndex 开始页
     * @param pageSize      页面大小
     * @return java.util.List<com.bluemsun.island.entity.User>
     * @date 16:02 2021/10/10
     **/
    List<User> selectAll(@Param("startIndex")int startIndex, @Param("pageSize")int pageSize);//int,int

    /**
     * 获得用户表记录数
     *
     * @date 14:36 2021/10/22
     * @return int 记录数
     **/
    int getAllCount();

    User selectOneById(int userId);

    List<User> selectByUserName(@Param("startIndex") int startIndex,@Param("pageSize") int pageSize,@Param("username") String username);

    int getCountByUserName(String username);
}
