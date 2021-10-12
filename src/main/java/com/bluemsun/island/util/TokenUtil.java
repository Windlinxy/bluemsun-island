package com.bluemsun.island.util;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

/**
 * @program: BulemsunIsland
 * @description: Token工具类
 * @author: Windlinxy
 * @create: 2021-10-12 18:37
 **/
public class TokenUtil {

    public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();

    public static String getJwt(){
        byte[] secret = "2162d3e65a421bc0ac76ae5acfe29c650becb73f2a9b8ce57941036331b1aaa8".getBytes();
        SecretKey key = Keys.hmacShaKeyFor(secret);

        String jws = Jwts.builder()
                .setHeaderParam("kid", "123456")
                .setSubject("111")
                .setIssuer("ameow")
                .setNotBefore(new Date())
                .claim("weisha", "wozhidaole")
                .signWith(key)
                .compact();
        return jws;
    }

    public static void encyJWT(){
        Jws<Claims> jwsR;
        try {
            jwsR = Jwts.parser()
                    .setSigningKey(key)
                    .parseClaimsJws(jws);
            System.out.println("??/:"+jwsR);
            System.out.println("sha"+jwsR.getBody().get("weisha"));

        } catch (JwtException ex) {
            System.out.println("???");
        }

    }
}
