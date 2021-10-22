package com.bluemsun.island.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 管理员
 * @author: Windlinxy
 * @create: 2021-10-21 20:33
 **/
@RestController
public class AdminController {
    @GetMapping("/users")
    public Map<String,Object> userList(){
        Map<String,Object> map = new HashMap<>();

        return map;
    }
}
