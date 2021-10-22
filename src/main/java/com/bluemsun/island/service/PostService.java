package com.bluemsun.island.service;

import com.bluemsun.island.entity.Post;

/**
 * @program: BulemsunIsland
 * @description: 帖子服务接口
 * @author: Windlinxy
 * @create: 2021-10-22 18:33
 **/
public interface PostService {
    /**
     * 添加帖子
     *
     * @date 18:50 2021/10/22
     * @param post 帖子
     * @return int 操作判断
     **/
    int addPost(Post post);
}
