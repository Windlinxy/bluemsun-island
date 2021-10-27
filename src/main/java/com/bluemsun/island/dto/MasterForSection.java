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
    private String  masterSectionName;

    public MasterForSection() {
    }

    public MasterForSection(int masterId, String masterSectionName) {
        this.masterId = masterId;
        this.masterSectionName = masterSectionName;
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

    public String getMasterSectionName() {
        return masterSectionName;
    }

    public void setMasterSectionName(String masterSectionName) {
        this.masterSectionName = masterSectionName;
    }

    @Override
    public String toString() {
        return "MasterForSection{" +
                "id=" + id +
                ", masterId=" + masterId +
                ", masterSectionName='" + masterSectionName + '\'' +
                '}';
    }
}