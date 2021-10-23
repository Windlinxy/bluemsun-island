package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.PostDao;
import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 页面服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:43
 **/
public class PageServiceImpl implements PageService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private PostDao postDao;

    @Override
    public Page<User> getUsers(int curPage, int pageSize) {
        int totalResult = userDao.getAllUsersCount();
        Page<User> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(userDao.queryAllUsers(page.getStartIndex(),pageSize));
        return page;
    }

    @Override
    public Page<Post> getPosts(int  curPage, int pageSize){
        int totalResult = userDao.getAllUsersCount();
        Page<Post> page = new Page<>(curPage, pageSize, totalResult);
        page.setList(postDao.queryAllPosts(page.getStartIndex(),pageSize));
        return page;
    }

}
