package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.CommentDao;
import com.bluemsun.island.dao.PostDao;
import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Comment;
import com.bluemsun.island.service.CommentService;
import com.bluemsun.island.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 评论服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:40
 **/
public class CommentServiceImpl implements CommentService {
    private int operationJudCode;
    @Autowired
    CommentDao commentDao;
    @Autowired
    PostDao postDao;

    @Override
    public int addComment(Comment comment){
        operationJudCode  =commentDao.insertComment(comment);
        if(operationJudCode == 1){
            postDao.postCommentNumberAdd(comment.getCommentPostId(),true);
            PostResult postResult = RedisUtil.getObject(comment.getCommentPostId(), PostResult.class);
            postResult.setAccessNumber( postResult.getCommentNumber()+1);
            RedisUtil.setObject(comment.getCommentPostId(),postResult);
        }
        return operationJudCode;
    }

    @Override
    public int deleteIt(int id){
        int postId = commentDao.searchComment(id).getCommentPostId();
        PostResult postResult = RedisUtil.getObject(postId, PostResult.class);
        postResult.setAccessNumber( postResult.getCommentNumber()-1);
        RedisUtil.setObject(postId,postResult);
        postDao.postCommentNumberAdd(postId,false);
        operationJudCode = commentDao.deleteById(id);
        return operationJudCode;
    }
}
