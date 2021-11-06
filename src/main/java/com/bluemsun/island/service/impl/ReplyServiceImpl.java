package com.bluemsun.island.service.impl;

import com.bluemsun.island.dao.ReplyDao;
import com.bluemsun.island.entity.Reply;
import com.bluemsun.island.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @program: BulemsunIsland
 * @description: 回复服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:44
 **/
public class ReplyServiceImpl implements ReplyService {
    private int operationJudCode = 0;
    @Autowired
    private ReplyDao replyDao;

    @Override
    public int addReply(Reply reply) {
        if(reply.getReplyContent()==null){
            return 0;
        }
        operationJudCode = replyDao.insertReply(reply);
        return operationJudCode;
    }

    @Override
    public int deleteIt(int id){
        operationJudCode = replyDao.deleteById(id);
        return operationJudCode;
    }
}
