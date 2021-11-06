package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.dto.PostResult;
import com.bluemsun.island.entity.Post;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 帖子映射
 *
 * @program: BulemsunIsland
 * @description: 帖子映射
 * @author: Windlinxy
 * @create: 2021-10-21 21:23
 **/
public interface PostMapper {

    int deleteById(int id);

    int insert(Post record);

    int insertSelective(Post record);

    int updateByIdSelective(Post record);

    int updateById(Post record);

    int commentNumberAdd(int postId);

    int commentNumberDel(int postId);

    int likeNumberAdd(int postId);

    int likeNumberDel(int postId);

    PostResult selectById(long id);

    int getAllCount();

    int getAllCountBySectionId(int id);

    List<PostResult> selectAll(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    PostResult selectOneById(int id);

    List<PostResult> selectAllBySectionIdDate(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize, @Param("sectionId")int sectionId);

    List<PostResult> selectAllBySectionIdHot(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize, @Param("sectionId")int sectionId);

    List<PostResult> selectAllHot(@Param("startIndex") int startIndex, @Param("pageSize")int pageSize);

    List<PostResult> selectByPostTitle(@Param("startIndex") int startIndex, @Param("pageSize") int pageSize, @Param("postTitle") String postTitle);

    int getCountByPostTitle(String postTitle);
}
