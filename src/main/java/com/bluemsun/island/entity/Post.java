package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: 帖子
 * @author: Windlinxy
 * @create: 2021-10-21 21:00
 **/
public class Post {
    /**
     * 帖子id
     */
    private int postId;

    /**
     * 发帖时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date postDate;

    /**
     * 标题
     */
    private String title;

    /**
     * 用户id
     */
    private int userId;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 访问量
     */
    private int accessNumber;

    /**
     * 收藏量
     */
    private int starNumber;

    /**
     * 评论数
     */
    private int commentNumber;

    /**
     * 点赞数
     */
    private int likeNumber;

    /**
     * 板块id
     */
    private int sectionId;

    private int status;

    public Post() {
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public Date getPostDate() {
        return postDate;
    }

    public void setPostDate(Date postDate) {
        this.postDate = postDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAccessNumber() {
        return accessNumber;
    }

    public void setAccessNumber(int accessNumber) {
        this.accessNumber = accessNumber;
    }

    public int getStarNumber() {
        return starNumber;
    }

    public void setStarNumber(int starNumber) {
        this.starNumber = starNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public void setCommentNumber(int commentNumber) {
        this.commentNumber = commentNumber;
    }

    public int getLikeNumber() {
        return likeNumber;
    }

    public void setLikeNumber(int likeNumber) {
        this.likeNumber = likeNumber;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postDate=" + postDate +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", accessNumber=" + accessNumber +
                ", starNumber=" + starNumber +
                ", commentNumber=" + commentNumber +
                ", likeNumber=" + likeNumber +
                ", sectionId=" + sectionId +
                ", status=" + status +
                '}';
    }
}
