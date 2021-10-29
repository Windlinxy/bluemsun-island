package com.bluemsun.island.service;

import com.bluemsun.island.entity.User;

/**
 * @program: BulemsunIsland
 * @description: 管理员服务接口
 * @author: Windlinxy
 * @create: 2021-10-21 20:41
 **/
public interface AdminService {
    /**
     * 根据id删除用户
     *
     * @date 10:09 2021/10/23
     * @param userId 用户id
     * @return int 操作判断
     **/
    int deleteUser(int userId);

    /**
     * 修改用户状态
     *
     * @date 15:51 2021/10/23
     * @param id    用户id
     * @param status    用户状态
     * @return int 操作判断
     **/
    int changeUserStatus(int id,int status);

    /**
     * 获取用户信息
     *
     * @date 16:19 2021/10/23
     * @param userId    用户id
     * @return com.bluemsun.island.entity.User 用户
     **/
    User getUserInfo(int userId);

    int changeSectionStatus(int sectionId, int status);

    int deleteSection(int sectionId);
}
