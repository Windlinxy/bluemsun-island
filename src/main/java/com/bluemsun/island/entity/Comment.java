package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Comment implements Serializable {
    /**
     * id
     */
    private int commentId;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date commentDate;

    /**
     * 帖子id
     */
    private int commentPostId;

    /**
     * 用户id
     */
    private int commentUserId;

    /**
     * 评论内容
     */
    private String commentContent;

    /**
     * 点赞数
     */
    private int commentLikeNumber;

    /**
     * 状态
     */
    private int commentStatus;


    public Comment() {
    }

    public Comment(int commentPostId, int commentUserId, String commentContent) {
        this.commentPostId = commentPostId;
        this.commentUserId = commentUserId;
        this.commentContent = commentContent;
    }
}