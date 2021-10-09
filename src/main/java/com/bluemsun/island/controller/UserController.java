package com.bluemsun.island.controller;

import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @program: BulemsunIsland
 * @description: 用户控制器
 * @author: Windlinxy
 * @create: 2021-10-05 11:27
 **/

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(
            method = RequestMethod.POST
    )
    public User register(@RequestBody User user) {
        System.out.println(user);
        userService.addUser(user);
        return user;
    }

    @RequestMapping(
            method = RequestMethod.GET
    )
    public void test(@RequestParam("sheng") String test) {
        System.out.println(test);

    }
}
