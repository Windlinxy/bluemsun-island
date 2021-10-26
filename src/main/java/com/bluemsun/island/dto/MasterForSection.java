package com.bluemsun.island.dto;

import java.io.Serializable;


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
    private int masterSectionId;

    public MasterForSection(int masterId, int masterSectionId) {
        this.masterId = masterId;
        this.masterSectionId = masterSectionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMasterId() {
        return masterId;
    }

    public void setMasterId(int masterId) {
        this.masterId = masterId;
    }

    public int getMasterSectionId() {
        return masterSectionId;
    }

    public void setMasterSectionId(int masterSectionId) {
        this.masterSectionId = masterSectionId;
    }

    @Override
    public String toString() {
        return "MasterForSection{" +
                "id=" + id +
                ", masterId=" + masterId +
                ", masterSectionId=" + masterSectionId +
                '}';
    }
}