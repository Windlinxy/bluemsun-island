package com.bluemsun.island.dao;

import com.bluemsun.island.entity.Post;

import java.util.List;

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

    /**
     * 查找所有帖子
     *
     * @date 10:32 2021/10/23
     * @param startIndex 开始
     * @param  pageSize 数据量大小
     * @return java.util.List<com.bluemsun.island.entity.Post>
     **/
    List<Post> queryAllPosts(int startIndex, int pageSize);

    /**
     * 总帖子数
     *
     * @date 10:33 2021/10/23
     * @return int 数量
     **/
    int getAllPostsCount();
}
