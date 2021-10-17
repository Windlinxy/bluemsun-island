package com.bluemsun.island.util;

import com.bluemsun.island.enums.ReturnCode;

import java.util.Map;

/**
 * 响应工具类
 *
 * @program: BulemsunIsland
 * @description: 响应数据类
 * @author: Windlinxy
 * @create: 2021-10-10 11:13
 **/
public class ResponseUtil {
    public static void returnFailed(Map<String,Object> map){
        map.put("message",ReturnCode.FAILED.getMessage());
        map.put("status",ReturnCode.FAILED.getCode());
    }

    public static void returnSuccess(Map<String,Object> map) {
        map.put("message", ReturnCode.SUCCESS.getMessage());
        map.put("status", ReturnCode.SUCCESS.getCode());
    }

    public static void returnUnknownError(Map<String,Object> map) {
        map.put("message", ReturnCode.SUCCESS.getMessage());
        map.put("status", ReturnCode.SUCCESS.getCode());
    }
}
