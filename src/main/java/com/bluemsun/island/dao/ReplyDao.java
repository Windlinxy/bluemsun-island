package com.bluemsun.island.dao;

import com.bluemsun.island.dao.mapper.ReplyMapper;
import com.bluemsun.island.dto.ReplyResult;
import com.bluemsun.island.entity.Reply;
import com.bluemsun.island.enums.ReturnCode;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.dao.DuplicateKeyException;

import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 回复
 * @author: Windlinxy
 * @create: 2021-10-30 16:33
 **/
public class ReplyDao extends SqlSessionDaoSupport {
    private int operationCode = 0;
    private <T> T getMapper(Class<T> mapperClass) {
        return getSqlSession().getMapper(mapperClass);
    }

    public int insertReply(Reply reply){
        try {
            getMapper(ReplyMapper.class).insert(reply);
            operationCode = ReturnCode.OP_SUCCESS;
        } catch (DuplicateKeyException e) {
            operationCode = ReturnCode.OP_FAILED;
        } catch (Exception e) {
            operationCode = ReturnCode.OP_UNKNOWN_ERROR;
            throw new RuntimeException(e);
        }
        return operationCode;
    }

    public List<ReplyResult> queryAllByCommentId(int startIndex, int pageSize, int commentId){
        List<ReplyResult> list;
        try {
            list = getMapper(ReplyMapper.class).selectByCommentId(startIndex,pageSize,commentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int getAllByCommentIdCount(int commentId){
        int count;
        try {
            count = getMapper(ReplyMapper.class).getCountByCommentIdCount(commentId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return count;
    }

    public int deleteById(int id){
        try {
            int rowsAffected = getMapper(ReplyMapper.class).deleteById(id);
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
