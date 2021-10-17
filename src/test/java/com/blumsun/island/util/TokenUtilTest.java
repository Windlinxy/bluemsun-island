package com.blumsun.island.util;

import com.bluemsun.island.util.JwtUtil;
import org.junit.Test;

/**
 * @program: BulemsunIsland
 * @description: token工具类测试类
 * @author: Windlinxy
 * @create: 2021-10-12 21:26
 **/
public class TokenUtilTest {
    @Test
    public void KeyTest(){
//        String token = JwtUtil.sign(2);
//        System.out.println(token);
        System.out.println(JwtUtil.verify("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxIiwiZXhwIjoxNjM0MjI0NTY0LCJ1c2VySWQiOjF9.erIsAj704vzKDvUyfdPCR7qOkF_S4eu9y6aRwb9mZjs"));
    }

    @Test
    public void RoleTest(){
        System.out.println(JwtUtil.getRole("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJhdWQiOiIxIiwicm9sZSI6MCwiZXhwIjoxNjM0NDY0NzYxLCJ1c2VySWQiOjF9.Dza5sCoCM6826jVVQraPCvwi2MwTaIpARIOCrwyYvfo"));
    }
}
