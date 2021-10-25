package com.blumsun.island.dao;

import com.bluemsun.island.dao.PostDao;
import com.bluemsun.island.dao.impl.PostDaoImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: BulemsunIsland
 * @description: postDao测试类
 * @author: Windlinxy
 * @create: 2021-10-24 21:58
 **/
public class PostDaoTest {

    @Test
    public void testGetOne(){
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:/spring/application.xml");
        PostDao postDao = context.getBean("postDao", PostDaoImpl.class);
        System.out.println(postDao.queryPostById(1));
    }
}
