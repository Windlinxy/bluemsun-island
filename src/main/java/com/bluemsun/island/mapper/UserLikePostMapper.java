package com.bluemsun.island.mapper;

import com.bluemsun.island.dto.UserLikePost;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Entity generator.domain.TbUserLikePost
 */
@Mapper
public interface UserLikePostMapper {

    int deleteByUserIdAndPostId(UserLikePost record);

    int insert(UserLikePost record);

    UserLikePost selectById(int id);

    int getCountByUserIdAndPostId(UserLikePost record);
}
