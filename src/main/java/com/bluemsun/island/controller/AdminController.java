package com.bluemsun.island.controller;

import com.bluemsun.island.entity.Page;
import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.AdminService;
import com.bluemsun.island.service.PageService;
import com.bluemsun.island.service.UserService;
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
@RequestMapping(
        produces = "application/json"
)
public class AdminController {
    private int operationJudCode = 0;
    @Autowired
    private PageService pageService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserService userService;

    @GetMapping(
            value = "/users")
    public Map<String, Object> userList(
            @RequestParam("cur") int currentPage,
            @RequestParam("size") int pageSize
    ) {
        Map<String, Object> map = new HashMap<>();
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
            value = "/users/:{id}"
    )
    public Map<String, Object> deleteUser(@PathVariable("id") int userId) {
        Map<String, Object> map = new HashMap<>();
        operationJudCode = adminService.deleteUser(userId);
        if (operationJudCode == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
        } else if (operationJudCode == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    @PatchMapping(
            value = "users/:{id}/:{sta}"
    )
    public Map<String, Object> banUser(@PathVariable("id") int userId, @PathVariable("sta") int status) {
        Map<String, Object> map = new HashMap<>();
        operationJudCode = adminService.changeUserStatus(userId, status);
        if (operationJudCode == ReturnCode.OP_SUCCESS) {
            ResponseUtil.returnSuccess(map);
            map.put("userStatus",status);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    @GetMapping(
            value = "users/{id}"
    )
    public Map<String, Object> getUserInfo(@PathVariable("id") int id) {
        Map<String, Object> map = new HashMap<>();
        User userInfo = adminService.getUserInfo(id);
        if (userInfo != null) {
            ResponseUtil.returnSuccess(map);
            map.put("user", userInfo);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

}
