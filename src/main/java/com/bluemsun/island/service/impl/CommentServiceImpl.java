package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.CommentDao;
import com.bluemsun.island.entity.Comment;
import com.bluemsun.island.service.CommentService;
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

    @Override
    public int addComment(Comment comment){
        operationJudCode  =commentDao.insertComment(comment);
        return operationJudCode;
    }

    @Override
    public int deleteIt(int id){
        operationJudCode = commentDao.deleteById(id);
        return operationJudCode;
    }
}
