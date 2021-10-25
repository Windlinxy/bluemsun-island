package com.blumsun.island.service;

import com.bluemsun.island.entity.User;
import com.bluemsun.island.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: BulemsunIsland
 * @description: 用户服务测试类
 * @author: Windlinxy
 * @create: 2021-10-08 14:41
 **/
public class UserServiceTest {
    @Test
    public void addUserTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
        UserServiceImpl userService = context.getBean("userService", UserServiceImpl.class);
        userService.addUser(new User("wangyi","shijie","23333"));
    }
}
