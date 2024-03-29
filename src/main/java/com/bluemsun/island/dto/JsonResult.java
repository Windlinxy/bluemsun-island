package com.bluemsun.island.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @program: BulemsunIsland
 * @description: json返回
 * @author: Windlinxy
 * @create: 2021-10-25 09:18
 **/
@Data
@Component
public class JsonResult<T> {


    /**
     * 错误码
     */
    private Integer status;

    /**
     * 提示信息
     */
    private String msg;

    /**
     * 返回的具体内容
     */
    private T data;


    public JsonResult(Integer code, String msg, T data) {
        this.status = code;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult() {
    }


    public JsonResult<T> fail() {
        return new JsonResult<>(0, "操作失败", null);
    }

    public JsonResult<T> fail(String msg) {
        return new JsonResult<>(0, msg, null);
    }

    public JsonResult<T> ok() {
        return new JsonResult<>(1, "操作成功", null);
    }

    public JsonResult<T> ok(T data) {
        return new JsonResult<>(1, "操作成功", data);
    }
}
