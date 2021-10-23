package com.bluemsun.island.service;

import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.entity.User;

/**
 * @program: BulemsunIsland
 * @description: 分页服务接口
 * @author: Windlinxy
 * @create: 2021-10-21 20:40
 **/
public interface PageService {
    /**
     * 获得用户页面
     *
     * @date 20:44 2021/10/22
     * @param curPage 当前页
     * @param  pageSize 页面大小
     * @return Page<User>
     **/
    Page<User> getUsers(int curPage, int pageSize);

    /**
     * 获得所有帖子
     *
     * @date 10:36 2021/10/23
     * @param curPage 当前页
     * @param  pageSize 页面显示数量
     * @return Page<Post>
     **/
    Page<Post> getPosts(int  curPage, int pageSize);
}
