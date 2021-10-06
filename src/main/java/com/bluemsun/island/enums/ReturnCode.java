package com.bluemsun.island.enums;

/**
 * @program: BulemsunIsland
 * @description: 响应码
 * @author: Windlinxy
 * @create: 2021-10-06 14:10
 **/
public enum ReturnCode {
    //请求处理成功
    SUCCESS(1, "成功！"),
    //
    ERROR_NO_LOGIN(-1, "未登录！"),
    FAILED(0, "失败！"),
    ERROR_NO_AUTHORITY(-2,"没有权限操作！"),

    OP_SUCCESS(1,"操作成功！"),
    OP_FAILED(0,"操作失败！");

    private final Integer code;
    private final String message;

    ReturnCode(Integer code, String message) {
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
