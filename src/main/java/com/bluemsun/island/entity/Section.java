package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;


public class Section implements Serializable {
    private int sectionId;

    private String sectionName;

    private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private int sectionStatus;

    private int focusNumber;

    private int postNumber;


    private String imageUrl;

    public Section() {
    }

    public Section(int sectionId, int sectionStatus) {
        this.sectionId = sectionId;
        this.sectionStatus = sectionStatus;
    }

    public Section(String sectionName, String description, String imageUrl) {
        this.sectionName = sectionName;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public int getSectionStatus() {
        return sectionStatus;
    }

    public void setSectionStatus(int sectionStatus) {
        this.sectionStatus = sectionStatus;
    }

    public int getFocusNumber() {
        return focusNumber;
    }

    public void setFocusNumber(int focusNumber) {
        this.focusNumber = focusNumber;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(int postNumber) {
        this.postNumber = postNumber;
    }


    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Section{" +
                "sectionId=" + sectionId +
                ", sectionName='" + sectionName + '\'' +
                ", description='" + description + '\'' +
                ", createTime=" + createTime +
                ", sectionStatus=" + sectionStatus +
                ", focusNumber=" + focusNumber +
                ", postNumber=" + postNumber +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}