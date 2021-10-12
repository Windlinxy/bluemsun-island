package com.blumsun.island.util;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import org.junit.Test;
import com.bluemsun.island.util.TokenUtil;

/**
 * @program: BulemsunIsland
 * @description: token工具类测试类
 * @author: Windlinxy
 * @create: 2021-10-12 21:26
 **/
public class TokenUtilTest {
    @Test
    public void KeyTest(){
        TokenUtil.encyJWT();

    }
}
