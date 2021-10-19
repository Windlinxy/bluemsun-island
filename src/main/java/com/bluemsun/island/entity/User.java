package com.bluemsun.island.entity;

import java.util.Date;

/**
 * 普通用户类
 *
 * @program: BulemsunIsland
 * @description: 普通用户类
 * @author: Windlinxy
 * @create: 2021-10-06 11:18
 **/
public class User {
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private byte sex;
    private byte identifyId;
    private String signature;
    private Date birthday;
    private String imageUrl;

    public User() {
    }

    public User(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;
    }

    public User(int id, String imageUrl) {
        this.id = id;
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public byte getIdentifyId() {
        return identifyId;
    }

    public void setIdentifyId(byte identifyId) {
        this.identifyId = identifyId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", sex=" + sex +
                ", identifyId=" + identifyId +
                ", signature='" + signature + '\'' +
                ", birthday=" + birthday +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
