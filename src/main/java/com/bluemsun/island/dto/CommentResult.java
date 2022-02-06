package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: 评论
 * @author: Windlinxy
 * @create: 2021-10-30 16:31
 **/
@Data
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
}
