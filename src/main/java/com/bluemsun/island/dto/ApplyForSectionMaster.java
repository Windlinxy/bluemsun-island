package com.bluemsun.island.dto;

import com.bluemsun.island.entity.Section;
import lombok.Data;

/**
 * @program: BulemsunIsland
 * @description: 申请成为版主
 * @author: Windlinxy
 * @create: 2021-10-25 10:03
 **/
@Data
public class ApplyForSectionMaster {
    private int userId;
    private Section section;

    public ApplyForSectionMaster(int userId,Section section) {
        this.userId = userId;
        this.section = section;
    }

    public ApplyForSectionMaster() {
    }
}
