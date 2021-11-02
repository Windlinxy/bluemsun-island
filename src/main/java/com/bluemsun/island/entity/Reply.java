package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


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

    public Integer getReplyId() {
        return replyId;
    }

    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    public Date getReplyDate() {
        return replyDate;
    }

    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    public int getRepliedCommentId() {
        return repliedCommentId;
    }

    public void setRepliedCommentId(int repliedCommentId) {
        this.repliedCommentId = repliedCommentId;
    }

    public int getRepliedId() {
        return repliedId;
    }

    public void setRepliedId(int repliedId) {
        this.repliedId = repliedId;
    }

    public int getReplyUserId() {
        return replyUserId;
    }

    public void setReplyUserId(int replyUserId) {
        this.replyUserId = replyUserId;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(int replyStatus) {
        this.replyStatus = replyStatus;
    }

    public int getReplyLikeNumber() {
        return replyLikeNumber;
    }

    public void setReplyLikeNumber(int replyLikeNumber) {
        this.replyLikeNumber = replyLikeNumber;
    }

    @Override
    public String toString() {
        return "Reply{" +
                "replyId=" + replyId +
                ", replyDate=" + replyDate +
                ", repliedCommentId=" + repliedCommentId +
                ", repliedId=" + repliedId +
                ", replyUserId=" + replyUserId +
                ", replyContent='" + replyContent + '\'' +
                ", replyStatus=" + replyStatus +
                ", replyLikeNumber=" + replyLikeNumber +
                '}';
    }
}