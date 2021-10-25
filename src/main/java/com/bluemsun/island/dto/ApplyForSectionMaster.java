package com.bluemsun.island.dto;

/**
 * @program: BulemsunIsland
 * @description: 申请成为版主
 * @author: Windlinxy
 * @create: 2021-10-25 10:03
 **/
public class ApplyForSectionMaster {
    private int userId;
    private String sectionName;
    private String description;
    private String userImage;

    public ApplyForSectionMaster(int userId, String sectionName, String description, String userImage) {
        this.userId = userId;
        this.sectionName = sectionName;
        this.description = description;
        this.userImage = userImage;
    }

    public ApplyForSectionMaster() {
    }

    @Override
    public String toString() {
        return "ApplyForSectionMaster{" +
                "userId=" + userId +
                ", sectionName='" + sectionName + '\'' +
                ", description='" + description + '\'' +
                ", userImage='" + userImage + '\'' +
                '}';
    }
}
