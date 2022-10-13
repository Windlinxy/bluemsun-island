package com.bluemsun.island.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final Logger logger= LoggerFactory.getLogger(this.toString());
    @Pointcut("execution(* com.bluemsun.island.service.impl.*.*(..))")
    public void cut() {}

    @Before(value = "cut()")
    public void beforeInvoke() {
        logger.info("==================Before=================");
    }

    @After(value = "cut()")
    public void afterInvoke() {
        logger.info("==================After=================");
    }

    @AfterReturning(value = "cut()")
    public void afterReturnInvoke() {
        logger.info("==================AfterReturning=================");
    }

    @AfterThrowing(value = "cut()",throwing = "e")
    public void afterThrowingInvoke(Exception e) {
        logger.info("================= ++++AfterThrowing++++ ===============");
        logger.info(e.getMessage());
        throw new RuntimeException();
    }

    @Around(value = "cut()")
    public void aroundInvoke(ProceedingJoinPoint joinPoint) {
        Object result;
        System.out.println("======Around======");
        try {
            result = joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }finally {

        }


    }
}
