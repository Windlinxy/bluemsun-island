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
 * @author windlinxy
 * @date 2021-10-05 11:10:08
 */
public class JwtUtil {

    /**
     * 密钥
     */
    private static final String SECRET = "windlin";

    /**
     * 过期时间（单位：秒）
     **/
    private static final long EXPIRE_TIME = 3600000L;


    /**
     * 生成token令牌
     *
     * @param userId 用户id
     * @param role   用户身份
     * @return java.lang.String token令牌
     * @date 18:08 2021/10/19
     **/
    public static String sign(long userId, int role) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
        // 附带username信息
        return JWT.create()
                .withHeader(map)
                .withAudience(String.valueOf(userId))
                .withClaim("userId", userId)
                .withClaim("role", role)
                .withExpiresAt(date)
                .sign(Algorithm.HMAC256(SECRET));
    }

    /**
     * 验证用户登录
     *
     * @param token 用户令牌
     * @return boolean 登录状态是否有效
     * @date 18:08 2021/10/19
     **/
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

    /**
     * 从token里获得使用则身份（0用户，-1管理员，1版主）
     *
     * @param token 用户令牌
     * @return int 用户identifyId
     * @date 18:07 2021/10/19
     **/
    public static int getRole(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("role").asInt();
    }

    /**
     * 从token里获取用户id
     *
     * @param token 用户令牌
     * @return int 用户id
     * @date 18:06 2021/10/19
     **/
    public static int getUserId(String token) {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = verifier.verify(token);
        return jwt.getClaim("userId").asInt();
    }
}


