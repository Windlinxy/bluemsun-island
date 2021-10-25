package com.blumsun.island.dao;

import com.bluemsun.island.dao.UserDao;
import com.bluemsun.island.dao.impl.UserDaoImpl;
import com.bluemsun.island.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: BulemsunIsland
 * @description: 用户持久层单元测试
 * @author: Windlinxy
 * @create: 2021-10-07 21:07
 **/
public class UserDaoTest {
    @Autowired
    UserDaoImpl userDao ;
    @Test
    public void insertTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
        UserDao userDao = context.getBean("userDao", UserDaoImpl.class);
        userDao.insertUser(new User("u56","sad546677","624556789102"));
        System.out.println(1);
    }

    @Test
    public void insertTest2() {
        new UserDaoImpl().insertUser(new User("u","sad546","22346789102"));
    }

    @Test
    public void orderTest(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
        UserDao userDao = context.getBean("userDao", UserDaoImpl.class);
        System.out.println(userDao.queryAllUsersByOrder(0, 5, "id", "desc"));
    }
}
