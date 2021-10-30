package com.bluemsun.island.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName tb_reply
 */
public class Reply implements Serializable {
    /**
     * id
     */
    private Integer replyId;

    /**
     * 回复时间
     */
    private Date replyDate;

    /**
     * 被回复评论
     */
    private Integer replyedId;

    /**
     * 用户id
     */
    private Integer replyUserId;

    /**
     * 内容
     */
    private String replyContent;

    /**
     * 状态
     */
    private Integer replyStatus;

    /**
     * 
     */
    private Integer replyLikeNumber;

    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    public Integer getReplyId() {
        return replyId;
    }

    /**
     * id
     */
    public void setReplyId(Integer replyId) {
        this.replyId = replyId;
    }

    /**
     * 回复时间
     */
    public Date getReplyDate() {
        return replyDate;
    }

    /**
     * 回复时间
     */
    public void setReplyDate(Date replyDate) {
        this.replyDate = replyDate;
    }

    /**
     * 被回复评论
     */
    public Integer getReplyedId() {
        return replyedId;
    }

    /**
     * 被回复评论
     */
    public void setReplyedId(Integer replyedId) {
        this.replyedId = replyedId;
    }

    /**
     * 用户id
     */
    public Integer getReplyUserId() {
        return replyUserId;
    }

    /**
     * 用户id
     */
    public void setReplyUserId(Integer replyUserId) {
        this.replyUserId = replyUserId;
    }

    /**
     * 内容
     */
    public String getReplyContent() {
        return replyContent;
    }

    /**
     * 内容
     */
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    /**
     * 状态
     */
    public Integer getReplyStatus() {
        return replyStatus;
    }

    /**
     * 状态
     */
    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 
     */
    public Integer getReplyLikeNumber() {
        return replyLikeNumber;
    }

    /**
     * 
     */
    public void setReplyLikeNumber(Integer replyLikeNumber) {
        this.replyLikeNumber = replyLikeNumber;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Reply other = (Reply) that;
        return (this.getReplyId() == null ? other.getReplyId() == null : this.getReplyId().equals(other.getReplyId()))
            && (this.getReplyDate() == null ? other.getReplyDate() == null : this.getReplyDate().equals(other.getReplyDate()))
            && (this.getReplyedId() == null ? other.getReplyedId() == null : this.getReplyedId().equals(other.getReplyedId()))
            && (this.getReplyUserId() == null ? other.getReplyUserId() == null : this.getReplyUserId().equals(other.getReplyUserId()))
            && (this.getReplyContent() == null ? other.getReplyContent() == null : this.getReplyContent().equals(other.getReplyContent()))
            && (this.getReplyStatus() == null ? other.getReplyStatus() == null : this.getReplyStatus().equals(other.getReplyStatus()))
            && (this.getReplyLikeNumber() == null ? other.getReplyLikeNumber() == null : this.getReplyLikeNumber().equals(other.getReplyLikeNumber()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getReplyId() == null) ? 0 : getReplyId().hashCode());
        result = prime * result + ((getReplyDate() == null) ? 0 : getReplyDate().hashCode());
        result = prime * result + ((getReplyedId() == null) ? 0 : getReplyedId().hashCode());
        result = prime * result + ((getReplyUserId() == null) ? 0 : getReplyUserId().hashCode());
        result = prime * result + ((getReplyContent() == null) ? 0 : getReplyContent().hashCode());
        result = prime * result + ((getReplyStatus() == null) ? 0 : getReplyStatus().hashCode());
        result = prime * result + ((getReplyLikeNumber() == null) ? 0 : getReplyLikeNumber().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", replyId=").append(replyId);
        sb.append(", replyDate=").append(replyDate);
        sb.append(", replyedId=").append(replyedId);
        sb.append(", replyUserId=").append(replyUserId);
        sb.append(", replyContent=").append(replyContent);
        sb.append(", replyStatus=").append(replyStatus);
        sb.append(", replyLikeNumber=").append(replyLikeNumber);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}