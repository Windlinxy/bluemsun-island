package com.bluemsun.island.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 普通用户类
 *
 * @program: BulemsunIsland
 * @description: 普通用户类
 * @author: Windlinxy
 * @create: 2021-10-06 11:18
 **/
@Data
public class User {
    private int id;
    private String username;
    private String password;
    private String phoneNumber;
    private byte sex;
    private byte identifyId;
    private String signature;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String imageUrl;

    private int core;

    private int status;

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
}
