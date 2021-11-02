package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.dto.ReplyResult;
import com.bluemsun.island.entity.Reply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Entity generator.domain.TbReply
 */
public interface ReplyMapper {

    int deleteById(int id);

    int insert(Reply record);

    Reply searchById(int id);

    int updateByIdSelective(Reply record);

    List<ReplyResult> selectByCommentId(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("commentId")int commentId);

    int getCountByCommentIdCount(int commentId);
}
