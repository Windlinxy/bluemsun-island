package com.bluemsun.island.dto;

import com.bluemsun.island.entity.Reply;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @program: BulemsunIsland
 * @description: 评论
 * @author: Windlinxy
 * @create: 2021-10-30 16:31
 **/
public class CommentResult {
    private List<Reply> list;
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

    public CommentResult() {
    }

    public List<Reply> getList() {
        return list;
    }

    public void setList(List<Reply> list) {
        this.list = list;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public int getCommentPostId() {
        return commentPostId;
    }

    public void setCommentPostId(int commentPostId) {
        this.commentPostId = commentPostId;
    }

    public int getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(int commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public int getCommentLikeNumber() {
        return commentLikeNumber;
    }

    public void setCommentLikeNumber(int commentLikeNumber) {
        this.commentLikeNumber = commentLikeNumber;
    }

    public int getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(int commentStatus) {
        this.commentStatus = commentStatus;
    }

    @Override
    public String toString() {
        return "CommentResult{" +
                "list=" + list +
                ", commentId=" + commentId +
                ", commentDate=" + commentDate +
                ", commentPostId=" + commentPostId +
                ", commentUserId=" + commentUserId +
                ", commentContent='" + commentContent + '\'' +
                ", commentLikeNumber=" + commentLikeNumber +
                ", commentStatus=" + commentStatus +
                '}';
    }
}
