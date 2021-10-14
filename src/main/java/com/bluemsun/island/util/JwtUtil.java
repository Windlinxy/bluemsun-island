package com.bluemsun.island.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Jwt工具类，生成JWT和认证
 *
 * @author dongk
 * @date 2021-02-05 11:10:08
 */

public class JwtUtil {

    /**
     * 密钥
     */
    private static final String SECRET = "asurplus_secret";

    /**
     * 过期时间（单位：秒）
     **/
    private static final long EXPIRE_TIME = 3600000L;


    public static String sign(long userId) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        // 附带username信息
        return JWT.create()
                .withHeader(map)
                .withAudience(String.valueOf(userId))
                .withClaim("userId", userId)
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(SECRET));
    }

    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            // 效验TOKEN
            DecodedJWT jwt = verifier.verify(token);
            return true;
        } catch (Exception exception) {
            return false;
        }
    }

}


