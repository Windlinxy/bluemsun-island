package com.bluemsun.island.dao;

import com.bluemsun.island.entity.Post;

/**
 * @program: BulemsunIsland
 * @description: 帖子数据持久层接口
 * @author: Windlinxy
 * @create: 2021-10-21 21:46
 **/
public interface PostDao {
    /**
     * 插入一条Post
     *
     * @date 18:37 2021/10/22
     * @param post 帖子
     * @return int 影响行数
     **/
    int insertPost(Post post);
}
