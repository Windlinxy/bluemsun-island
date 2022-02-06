package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
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
}