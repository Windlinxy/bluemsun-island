package com.bluemsun.island.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tb_audit
 */
@Data
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

}