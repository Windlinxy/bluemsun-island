package com.bluemsun.island.controller;

import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.UserService;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.RedisUtil;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户控制器
 * @program: BulemsunIsland
 * @description: 用户控制器
 * @author: Windlinxy
 * @create: 2021-10-05 11:27
 **/

@RestController
@RequestMapping("/users")
public class UserController {
    private int jud = 0;
    private final int hashMapCapacity = (int) (6 * 0.75 + 1.0);

    @Autowired
    private UserService userService;

    /**
     * 用户登录接口
     *
     * @date 17:39 2021/10/17
     * @param user 用户（手机号，密码，昵称）
     * @return java.util.Map<java.lang.String,java.lang.Object> 响应数据
     **/
    @PostMapping(
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
     * @date 17:40 2021/10/17
     * @param user 用户（手机号，密码）
     * @return java.util.Map<java.lang.String,java.lang.Object> 响应数据
     **/
    @PostMapping(
            value = "/token",
            consumes = "application/json",
            produces = "application/json"
    )
    public Map<String, Object> login(@RequestBody User user) {
        Map<String, Object> map = new HashMap<>(hashMapCapacity);
        User userInfo = userService.isUser(user);
        if (userInfo != null) {
            RedisUtil.set("user"+userInfo.getId(),userInfo);
            userInfo.setPassword(null);
            map.put("user", userInfo);
            map.put("token",JwtUtil.sign(userInfo.getId(),userInfo.getIdentifyId()));
            ResponseUtil.returnSuccess(map);
        } else {
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    /**
     * 测试接口
     *
     * @date 17:40 2021/10/17
     * @param test 测试参数
     **/
    @GetMapping
    public void test(@RequestParam("test") String test) {
        System.out.println(test);
    }

    @PostMapping("/image")
    public Map<String,Object> uploadHeadPortrait(HttpServletRequest request, MultipartFile file) throws ServletException, IOException {
        Map<String, Object> map = new HashMap<>();
        String folderString = "images";
        String serverPath = request.getServletContext().getRealPath(folderString);
        System.out.println(serverPath);
        System.out.println(file.isEmpty());
        String filename = userService.fileStore(file, serverPath);
        String projectServerPath = request.getScheme() + "://" + request.getServerName() + ":"
                + request.getServerPort() + request.getContextPath() + "/" + folderString + "/"
                + filename;
        map.put("status", ReturnCode.SUCCESS.getCode());
        map.put("imageUrl",projectServerPath);
        return map;
    }

}
