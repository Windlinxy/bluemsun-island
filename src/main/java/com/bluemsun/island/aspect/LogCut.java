package com.bluemsun.island.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @program: BulemsunIsland
 * @description: aop日志切面
 * @author: Windlinxy
 * @create: 2022-02-07 13:19
 **/
@Component
@Aspect
public class LogCut {
    @Pointcut("execution(* com.bluemsun.island.service.impl.*.*(..))")
    public void cut() {}

    @Before(value = "cut()")
    public void beforeInvoke() {
        System.out.println("============");
    }
}
