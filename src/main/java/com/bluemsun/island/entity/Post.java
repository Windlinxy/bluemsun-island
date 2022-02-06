package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: 帖子
 * @author: Windlinxy
 * @create: 2021-10-21 21:00
 **/
@Data
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

    public Post(int postId, int status) {
        this.postId = postId;
        this.status = status;
    }
}
