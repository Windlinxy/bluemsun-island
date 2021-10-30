package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Reply;

/**
 * @Entity generator.domain.TbReply
 */
public interface ReplyMapper {

    int deleteById(int id);

    int insert(Reply record);

    Reply searchById(int id);

    int updateByIdSelective(Reply record);
}
