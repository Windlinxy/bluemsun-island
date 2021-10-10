package com.bluemsun.island.util;

import com.bluemsun.island.enums.ReturnCode;

import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 响应数据类
 * @author: Windlinxy
 * @create: 2021-10-10 11:13
 **/
public class ResponseUtil {
    public static Map<String,Object> returnFailed(Map<String,Object> map){
        map.put("message",ReturnCode.FAILED.getMessage());
        map.put("status",ReturnCode.FAILED.getCode());
        return map;
    }

    public static Map<String,Object> returnSuccess(Map<String,Object> map) {
        map.put("message", ReturnCode.SUCCESS.getMessage());
        map.put("status", ReturnCode.SUCCESS.getCode());
        return map;
    }
}
