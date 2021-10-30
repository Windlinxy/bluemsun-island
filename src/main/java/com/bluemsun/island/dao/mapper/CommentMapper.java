package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.entity.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    Comment selectById(int id);

    int insert(Comment record);

    int updateByIdSelective(Comment record);

    int deleteById(int id);

    List<Comment> selectByPostId(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("postId")int postId);

    int getCountByPostIdCount(int postId);
}
