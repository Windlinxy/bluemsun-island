package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: post联查类
 * @author: Windlinxy
 * @create: 2021-10-24 21:29
 **/
@Data
public class PostResult{
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
}
