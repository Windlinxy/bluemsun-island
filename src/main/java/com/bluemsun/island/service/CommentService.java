package com.bluemsun.island.service;

import com.bluemsun.island.entity.Comment;

/**
 * @program: BulemsunIsland
 * @description: 评论服务接口
 * @author: Windlinxy
 * @create: 2021-10-21 20:44
 **/
public interface CommentService {
    int addComment(Comment comment);
    int deleteIt(int id);
}
