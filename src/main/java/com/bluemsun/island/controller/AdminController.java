package com.bluemsun.island.controller;

import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.AdminService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    private int operationJudCode = 0;
    @Autowired
    private PageService pageService;
    @Autowired
    private AdminService adminService;

    @GetMapping(
            value = "/users",
            produces = "application/json")
    public Map<String, Object> userList(@RequestParam("cur") int currentPage, @RequestParam("size") int pageSize) {
        Map<String, Object> map = new HashMap<>();
        System.out.println(currentPage+"==="+pageSize);
        Page<User> page;
        if (currentPage < 1 || pageSize < 1) {
            ResponseUtil.returnFailed(map);
        } else {
            page = pageService.getUsers(currentPage, pageSize);
            ResponseUtil.returnSuccess(map);
            map.put("page", page);
        }
        return map;
    }

    @DeleteMapping(
            value = "/users/{userId}"
    )
    public Map<String, Object> deleteUser(@PathVariable("userId")int userId){
        Map<String, Object> map = new HashMap<>();
        operationJudCode =adminService.deleteUser(userId);
        if(operationJudCode == ReturnCode.OP_SUCCESS){
            ResponseUtil.returnSuccess(map);
        }else if(operationJudCode == ReturnCode.OP_FAILED){
            ResponseUtil.returnFailed(map);
        }else {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }
}
