package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: post联查类
 * @author: Windlinxy
 * @create: 2021-10-24 21:29
 **/
public class PostResult {
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

    /**
     * 状态
     */
    private int status;

    private String imageUrl;

    private String username;

    private String sectionName;

    private String sectionImageUrl;
    public PostResult() {
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getSectionImageUrl() {
        return sectionImageUrl;
    }

    public void setSectionImageUrl(String sectionImageUrl) {
        this.sectionImageUrl = sectionImageUrl;
    }

    @Override
    public String toString() {
        return "PostResult{" +
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
                ", imageUrl='" + imageUrl + '\'' +
                ", username='" + username + '\'' +
                ", sectionName='" + sectionName + '\'' +
                ", sectionImageUrl='" + sectionImageUrl + '\'' +
                '}';
    }
}
