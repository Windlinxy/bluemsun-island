package com.bluemsun.island.service.impl;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Comment;
import com.bluemsun.island.mapper.CommentMapper;
import com.bluemsun.island.mapper.PostMapper;
import com.bluemsun.island.service.CommentService;
import com.bluemsun.island.util.RedisUtil;

import javax.annotation.Resource;

/**
 * @program: BulemsunIsland
 * @description: 评论服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:40
 **/

public class CommentServiceImpl implements CommentService {
    private int operationJudCode;
    @Resource
    CommentMapper commentMapper;
    @Resource
    PostMapper postMapper;

    @Override
    public int addComment(Comment comment) {
        operationJudCode = commentMapper.insert(comment);
        if (operationJudCode == 1) {
            postMapper.commentNumberAdd(comment.getCommentPostId());
            PostResult postResult = RedisUtil.getObject(comment.getCommentPostId(), PostResult.class);
            postResult.setAccessNumber(postResult.getCommentNumber() + 1);
            RedisUtil.setObject(comment.getCommentPostId(), postResult);
        }
        return operationJudCode;
    }

    @Override
    public int deleteIt(int id) {
        int postId = commentMapper.selectById(id).getCommentPostId();
        PostResult postResult = RedisUtil.getObject(postId, PostResult.class);
        postResult.setAccessNumber(postResult.getCommentNumber() - 1);
        RedisUtil.setObject(postId, postResult);
        postMapper.commentNumberDel(postId);
        operationJudCode = commentMapper.deleteById(id);
        return operationJudCode;
    }
}
