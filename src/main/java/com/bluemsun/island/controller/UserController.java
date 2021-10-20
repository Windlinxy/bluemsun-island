package com.bluemsun.island.controller;

import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.FileService;
import com.bluemsun.island.service.UserService;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 *
 * @program: BulemsunIsland
 * @description: 用户控制器
 * @author: Windlinxy
 * @create: 2021-10-05 11:27
 **/

@RestController
public class UserController {
    private int jud = 0;
    private final int hashMapCapacity = (int) (6 * 0.75 + 1.0);

    @Autowired
    private UserService userService;
    @Autowired
    private FileService fileService;

    /**
     * 用户登录接口
     *
     * @param user 用户（手机号，密码，昵称）
     * @return java.util.Map<java.lang.String, java.lang.Object> 响应数据
     * @date 17:39 2021/10/17
     **/
    @PostMapping(
            value = "/users",
            consumes = "application/json",
            produces = "application/json"
    )
    public Map<String, Object> register(@RequestBody User user) {

        Map<String, Object> map = new HashMap<>(hashMapCapacity);
        jud = userService.addUser(user);
        if (jud == ReturnCode.OP_SUCCESS) {
            user.setPassword(null);
            user.setPhoneNumber(null);
            map.put("user", user);
            ResponseUtil.returnSuccess(map);
        } else if (jud == ReturnCode.OP_FAILED) {
            ResponseUtil.returnFailed(map);
        } else if (jud == ReturnCode.OP_UNKNOWN_ERROR) {
            ResponseUtil.returnUnknownError(map);
        }
        return map;
    }

    /**
     * 用户登录方法
     *
     * @param user 用户（手机号，密码）
     * @return java.util.Map<java.lang.String, java.lang.Object> 响应数据
     * @date 17:40 2021/10/17
     **/
    @PostMapping(
            value = "/users/token",
            consumes = "application/json",
            produces = "application/json"
    )
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>(hashMapCapacity);
        User userInfo = userService.isUser(user);
        if (userInfo != null) {
            userInfo.setPassword(null);
            map.put("user", userInfo);
            map.put("token", JwtUtil.sign(userInfo.getId(), userInfo.getIdentifyId()));
            ResponseUtil.returnSuccess(map);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    /**
     * 测试接口
     *
     * @param test 测试参数
     * @date 17:40 2021/10/17
     **/
    @GetMapping
    public void test(@RequestParam("test") String test) {
        System.out.println(test);
    }

    /**
     * 用户上传头像接口
     *
     * @return java.util.Map<java.lang.String, java.lang.Object> User
     * @date 20:23 2021/10/19
     **/
    @PostMapping("/user/image")
    public Map<String, Object> uploadHeadPortrait(HttpServletRequest request, @RequestParam("image") MultipartFile file) {
        Map<String, Object> map = new HashMap<>(4);
        String folderString = "images";
        String serverPath = request.getServletContext().getRealPath(folderString);
        String filename = fileService.fileStore(file, serverPath);
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/" + folderString + "/"
                + filename;
        projectServerPath = projectServerPath.replace("/bluemsun_island", "");
        userService.changeImageUrl(request.getHeader("token"), projectServerPath);
        map.put("status", ReturnCode.SUCCESS.getCode());
        map.put("imageUrl", projectServerPath);
        return map;
    }

    @GetMapping("/user")
    public Map<String, Object> getUserInfo(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(5);
        String token = request.getHeader("token");
        if (token == null) {
            ResponseUtil.returnFailed(map);
        } else {
            int id = JwtUtil.getUserId(token);
            User userInCache = userService.getUserInCache(id);
            map.put("user", userInCache);
            ResponseUtil.returnSuccess(map);
        }
        return map;
    }

    /**
     * 修改用户信息（部分）
     *
     * @param request 请求
     * @param user 用户（需要修改的信息）
     * @return java.util.Map<java.lang.String, java.lang.Object>
     * @date 17:30 2021/10/20
     **/
    @PatchMapping("/users")
    public Map<String, Object> changUserInfo(HttpServletRequest request, @RequestBody User user) {
        Map<String, Object> map = new HashMap<>(4);
        User userAfterChange = userService.changeUser(request.getHeader("token"), user);
        if (userAfterChange != null) {
            ResponseUtil.returnSuccess(map);
            map.put("user", userAfterChange);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }
}
