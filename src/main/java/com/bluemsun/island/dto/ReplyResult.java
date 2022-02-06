package com.bluemsun.island.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: dto
 * @author: Windlinxy
 * @create: 2021-10-30 21:34
 **/
@Data
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
}
