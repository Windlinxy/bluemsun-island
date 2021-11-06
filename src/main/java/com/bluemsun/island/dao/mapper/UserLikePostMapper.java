package com.bluemsun.island.dao.mapper;

import com.bluemsun.island.dto.UserLikePost;

/**
 * @Entity generator.domain.TbUserLikePost
 */
public interface UserLikePostMapper {

    int deleteByUserIdAndPostId(UserLikePost record);

    int insert(UserLikePost record);

    UserLikePost selectById(int id);

    int getCountByUserIdAndPostId(UserLikePost record);
}
