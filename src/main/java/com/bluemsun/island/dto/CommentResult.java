package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: 评论
 * @author: Windlinxy
 * @create: 2021-10-30 16:31
 **/
public class CommentResult {
    /**
     * id
     */
    private int id;

    /**
     * 评论时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;

    /**
     * 帖子id
     */
    private int postId;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户头像
     */
    private String userPortrait;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 点赞数
     */
    private int likeNumber;

    /**
     * 状态
     */
    private int status;

    private int commenterId;

    public CommentResult() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPortrait() {
        return userPortrait;
    }

    public void setUserPortrait(String userPortrait) {
        this.userPortrait = userPortrait;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCommenterId() {
        return commenterId;
    }

    public void setCommenterId(int commenterId) {
        this.commenterId = commenterId;
    }

    @Override
    public String toString() {
        return "CommentResult{" +
                "id=" + id +
                ", date=" + date +
                ", postId=" + postId +
                ", userName='" + userName + '\'' +
                ", userPortrait='" + userPortrait + '\'' +
                ", content='" + content + '\'' +
                ", likeNumber=" + likeNumber +
                ", status=" + status +
                ", repliedUserId=" + commenterId +
                '}';
    }
}
