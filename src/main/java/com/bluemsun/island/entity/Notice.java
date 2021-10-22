package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: 消息通知
 * @author: Windlinxy
 * @create: 2021-10-21 21:15
 **/
public class Notice {
    /**
     *消息id
     */
    private int id;

    /**
     *用户id
     */
    private int userId;

    /**
     *内容
     */
    private String content;

    /**
     *通知时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date noticeTime;

    private int status;
    public Notice() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Notice{" +
                "id=" + id +
                ", userId=" + userId +
                ", content='" + content + '\'' +
                ", noticeTime=" + noticeTime +
                ", status=" + status +
                '}';
    }
}
