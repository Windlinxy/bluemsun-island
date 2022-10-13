package com.bluemsun.island.service.impl;


import com.bluemsun.island.entity.Reply;
import com.bluemsun.island.mapper.ReplyMapper;
import com.bluemsun.island.service.ReplyService;

import javax.annotation.Resource;

/**
 * @program: BulemsunIsland
 * @description: 回复服务接口实现类
 * @author: Windlinxy
 * @create: 2021-10-21 21:44
 **/

public class ReplyServiceImpl implements ReplyService {
    private int operationJudCode = 0;
    @Resource
    private ReplyMapper replyMapper;

    @Override
    public int addReply(Reply reply) {
        if (reply.getReplyContent() == null) {
            return 0;
        }
        operationJudCode = replyMapper.insert(reply);
        return operationJudCode;
    }

    @Override
    public int deleteIt(int id) {
        operationJudCode = replyMapper.deleteById(id);
        return operationJudCode;
    }
}
