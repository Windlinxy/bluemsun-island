package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.PostDao;
import com.bluemsun.island.entity.Post;
import com.bluemsun.island.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 帖子服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-22 18:33
 **/
public class PostServiceImpl implements PostService {
    private int operationJudCode = 0;
    @Autowired
    private PostDao postDao;

    @Override
    public int addPost(Post post){
        System.out.println(post);
        operationJudCode = postDao.insertPost(post);
        return operationJudCode;
    }
}
