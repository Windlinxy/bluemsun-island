package com.bluemsun.island.service;

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
}
