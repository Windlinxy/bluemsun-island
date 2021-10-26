package com.bluemsun.island.dto;

import com.bluemsun.island.entity.Section;

/**
 * @program: BulemsunIsland
 * @description: 申请成为版主
 * @author: Windlinxy
 * @create: 2021-10-25 10:03
 **/
public class ApplyForSectionMaster {
    private int userId;
    private Section section;

    public ApplyForSectionMaster(int userId,Section section) {
        this.userId = userId;
        this.section = section;
    }

    public ApplyForSectionMaster() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public String toString() {
        return "ApplyForSectionMaster{" +
                "userId=" + userId +
                ", section=" + section +
                '}';
    }
}
