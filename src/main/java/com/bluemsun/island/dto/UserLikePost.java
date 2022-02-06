package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_user_like_post
 */
@Data
public class UserLikePost implements Serializable {
    /**
     * 主键id
     */
    private int id;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 帖子id
     */
    private int postId;

    /**
     * 关注时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date focusTime;

    public UserLikePost() {
    }

    public UserLikePost(int userId, int postId) {
        this.userId = userId;
        this.postId = postId;
    }
}