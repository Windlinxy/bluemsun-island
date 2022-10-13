package com.bluemsun.island.service.impl;

import com.bluemsun.island.entity.Section;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.mapper.SectionMapper;
import com.bluemsun.island.mapper.UserMapper;
import com.bluemsun.island.service.AdminService;
import com.bluemsun.island.util.RedisUtil;

import javax.annotation.Resource;

/**
 * @program: BulemsunIsland
 * @description: 管理员服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:40
 **/

public class AdminServiceImpl implements AdminService {
    private int operationJudCode = 0;
    @Resource
    private UserMapper userMapper;
    @Resource
    private SectionMapper sectionMapper;

    @Override
    public int deleteUser(int userId) {
        operationJudCode = userMapper.deleteById(userId);
        return operationJudCode;
    }


    @Override
    public int changeUserStatus(int id, int status) {
        User user = new User();
        user.setId(id);
        user.setStatus(status);
        operationJudCode = userMapper.updateOneSelective(user);
        return operationJudCode;
    }

    @Override
    public User getUserInfo(int userId) {
        User userAfter;
        User userInCache = RedisUtil.getUser(userId);
        if (userInCache != null) {
            userAfter = userInCache;
        } else {
            User userInDatabase = userMapper.selectOneById(userId);
            if (userInDatabase != null) {
                userAfter = userInDatabase;
                RedisUtil.setUser(userId, userInDatabase);
            } else {
                userAfter = null;
            }
        }
        return userAfter;
    }

    @Override
    public int changeSectionStatus(int sectionId, int status) {
        Section section = new Section(sectionId, status);
        operationJudCode = sectionMapper.updateSelective(section);
        return operationJudCode;
    }


    @Override
    public int deleteSection(int sectionId) {
        operationJudCode = sectionMapper.deleteById(sectionId);
        return operationJudCode;
    }
}
