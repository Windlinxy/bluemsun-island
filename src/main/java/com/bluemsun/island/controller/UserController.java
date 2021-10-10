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
    private int jud = 0;
    private final int hashMapCapacity = (int)(6*0.75+1.0);

    @Autowired
    private UserService userService;

    @PostMapping(
            consumes = "application/json",
            produces = "application/json"
    )
    public Map<String, Object> register(@RequestBody User user) {
        Map<String,Object> map = new HashMap<>(hashMapCapacity);
        jud = userService.addUser(user);
        if( jud == ReturnCode.OP_SUCCESS){
            user.setPassword(null);
            user.setPhoneNumber(null);
            map.put("user",user);
            ResponseUtil.returnSuccess(map);
        }else if (jud == ReturnCode.OP_FAILED){
            ResponseUtil.returnFailed(map);
        }else if(jud == ReturnCode.OP_UNKNOWN_ERROR){
            ResponseUtil.returnUnknownError(map);
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
