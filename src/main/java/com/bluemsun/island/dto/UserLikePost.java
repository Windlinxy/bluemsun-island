package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_user_like_post
 */
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getFocusTime() {
        return focusTime;
    }

    public void setFocusTime(Date focusTime) {
        this.focusTime = focusTime;
    }

    @Override
    public String toString() {
        return "UserLikePost{" +
                "id=" + id +
                ", userId=" + userId +
                ", postId=" + postId +
                ", focusTime=" + focusTime +
                '}';
    }
}