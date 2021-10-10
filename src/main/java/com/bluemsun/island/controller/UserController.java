package com.bluemsun.island.controller;

import com.bluemsun.island.entity.User;
import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.service.UserService;
import com.bluemsun.island.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 用户控制器
 * @author: Windlinxy
 * @create: 2021-10-05 11:27
 **/

@RestController
@RequestMapping("/users")
public class UserController {
    private final int hashMapCapacity = (int)(3*0.75+1.0);

    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public Map<String, Object> register(@RequestBody User user) {
        Map<String,Object> map = new HashMap<>(hashMapCapacity);

        if(userService.addUser(user) == ReturnCode.OP_SUCCESS){
            user.setPassword(null);
            user.setPhoneNumber(null);
            map.put("user",user);
            ResponseUtil.returnSuccess(map);
        }else if (userService.addUser(user) == ReturnCode.OP_FAILED){
            ResponseUtil.returnFailed(map);
        }
        return map;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public void test(@RequestParam("test") String test) {
        System.out.println(test);

    }
}
