package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.CommentMapper;
import com.bluemsun.island.dto.CommentResult;
import com.bluemsun.island.entity.Comment;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 评论
 * @author: Windlinxy
 * @create: 2021-10-30 15:07
 **/
public class CommentDao extends SqlSessionDaoSupport {
    private int operationCode = 0;
    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    public int insertComment(Comment comment){
        try {
            int rowsAffected = getMapper(CommentMapper.class).insert(comment);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public List<CommentResult> queryAllByPostId(int startIndex, int pageSize, int postId){
        List<CommentResult> list;
        try {
            list = getMapper(CommentMapper.class).selectByPostId(startIndex,pageSize,postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getAllByPostIdCount(int postId){
        int count;
        try {
            count = getMapper(CommentMapper.class).getCountByPostIdCount(postId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int deleteById(int id){
        try {
            int rowsAffected = getMapper(CommentMapper.class).deleteById(id);
            if (rowsAffected == 1) {
                operationCode = ReturnCode.OP_SUCCESS;
            } else {
                operationCode = ReturnCode.OP_FAILED;
            }
        } catch (Exception e) {
            operationCode = ReturnCode.OP_FAILED;
        }
        return operationCode;
    }
}
