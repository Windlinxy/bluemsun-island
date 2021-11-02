package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: dto
 * @author: Windlinxy
 * @create: 2021-10-30 21:34
 **/
public class ReplyResult {
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

    private String beReplier;

    private String beReplierPortrait;

    private String replier;

    private String replierPortrait;

    public ReplyResult() {
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

    public String getBeReplier() {
        return beReplier;
    }

    public void setBeReplier(String beReplier) {
        this.beReplier = beReplier;
    }

    public String getBeReplierPortrait() {
        return beReplierPortrait;
    }

    public void setBeReplierPortrait(String beReplierPortrait) {
        this.beReplierPortrait = beReplierPortrait;
    }

    public String getReplier() {
        return replier;
    }

    public void setReplier(String replier) {
        this.replier = replier;
    }

    public String getReplierPortrait() {
        return replierPortrait;
    }

    public void setReplierPortrait(String replierPortrait) {
        this.replierPortrait = replierPortrait;
    }

    @Override
    public String toString() {
        return "ReplyResult{" +
                "replyId=" + replyId +
                ", replyDate=" + replyDate +
                ", repliedCommentId=" + repliedCommentId +
                ", repliedId=" + repliedId +
                ", replyUserId=" + replyUserId +
                ", replyContent='" + replyContent + '\'' +
                ", replyStatus=" + replyStatus +
                ", replyLikeNumber=" + replyLikeNumber +
                ", beReplier='" + beReplier + '\'' +
                ", beReplierPortrait='" + beReplierPortrait + '\'' +
                ", replier='" + replier + '\'' +
                ", replierPortrait='" + replierPortrait + '\'' +
                '}';
    }
}
