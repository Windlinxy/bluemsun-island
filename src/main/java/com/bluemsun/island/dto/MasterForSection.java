package com.bluemsun.island.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class MasterForSection implements Serializable {
    /**
     * 
     */
    private int id;

    /**
     * 
     */
    private int masterId;

    /**
     * 
     */
    private String  masterSectionName;

    public MasterForSection() {
    }

    public MasterForSection(int masterId, String masterSectionName) {
        this.masterId = masterId;
        this.masterSectionName = masterSectionName;
    }

}