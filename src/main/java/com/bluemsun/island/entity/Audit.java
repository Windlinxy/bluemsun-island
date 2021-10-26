package com.bluemsun.island.entity;

import java.io.Serializable;

/**
 * 
 * @TableName tb_audit
 */
public class Audit implements Serializable {
    /**
     * 审核id
     */
    private Integer auditId;

    /**
     * 内容
     */
    private String content;

    /**
     *  用户id
     */
    private Integer userId;

    /**
     * 状态
     */
    private Integer status;
    private String imageUrl;
    private String description;
    private String sectionName;
    public Audit() {
    }

    public Audit(String content, Integer userId,String description,String imageUrl,String sectionName) {
        this.content = content;
        this.userId = userId;
        this.description = description;
        this.imageUrl = imageUrl;
        this.sectionName = sectionName;
    }



    public Audit(Integer auditId, Integer status) {
        this.auditId = auditId;
        this.status = status;
    }

    /**
     * 审核id
     */
    public Integer getAuditId() {
        return auditId;
    }

    /**
     * 审核id
     */
    public void setAuditId(Integer auditId) {
        this.auditId = auditId;
    }

    /**
     * 内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     *  用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *  用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    @Override
    public String toString() {
        return "Audit{" +
                "auditId=" + auditId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", status=" + status +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", sectionName='" + sectionName + '\'' +
                '}';
    }
}