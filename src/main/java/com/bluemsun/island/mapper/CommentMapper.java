package com.bluemsun.island.mapper;

import com.bluemsun.island.dto.CommentResult;
import com.bluemsun.island.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CommentMapper {

    Comment selectById(int id);

    int insert(Comment record);

    int updateByIdSelective(Comment record);

    int deleteById(int id);

    List<CommentResult> selectByPostId(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("postId")int postId);

    int getCountByPostIdCount(int postId);
}
