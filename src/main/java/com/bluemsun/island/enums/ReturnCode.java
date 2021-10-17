package com.bluemsun.island.enums;

/**
 * 响应码枚举类
 * @program: BulemsunIsland
 * @description: 响应码枚举类
 * @author: Windlinxy
 * @create: 2021-10-06 14:10
 **/
public enum ReturnCode {
    //请求成功
    SUCCESS(1, "成功！"),
    //请求失败
    FAILED(0, "失败！"),
    //发生未知错误
    UNKNOWN_ERROR(-1,"发生未知错误"),
    //用户没有登录
    ERROR_NO_LOGIN(2, "未登录！"),
    //无权限请求
    ERROR_NO_AUTHORITY(-2,"没有权限操作！");

    public static final int OP_SUCCESS = 1;
    public static final int OP_FAILED = 0;
    public static final int OP_UNKNOWN_ERROR = -1;

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
