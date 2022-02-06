package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class Reply implements Serializable {
    /**
     * id
     */
    private Integer replyId;

    /**
     * 回复时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date replyDate;
    /**
     * 被回复评论id
     */
    private int repliedCommentId;
    /**
     * 被回复用户id
     */
    private int repliedId;

    /**
     * 用户id
     */
    private int replyUserId;

    /**
     * 内容
     */
    private String replyContent;

    /**
     * 状态
     */
    private int replyStatus;

    /**
     * 
     */
    private int replyLikeNumber;

    public Reply() {
    }

    public Reply(int repliedCommentId, int repliedId, int replyUserId, String replyContent) {
        this.repliedCommentId = repliedCommentId;
        this.repliedId = repliedId;
        this.replyUserId = replyUserId;
        this.replyContent = replyContent;
    }
}