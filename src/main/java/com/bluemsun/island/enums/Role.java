package com.bluemsun.island.enums;

/**
 * @program: BulemsunIsland
 * @description: 用户角色
 * @author: Windlinxy
 * @create: 2021-10-08 14:22
 **/
public enum Role {
    //请求处理成功
    USER(0, "用户"),
    //
    ADMIN(-1, "管理员"),
    MASTER(1, "版主");

    private final Integer code;
    private final String message;

    Role(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }


}
