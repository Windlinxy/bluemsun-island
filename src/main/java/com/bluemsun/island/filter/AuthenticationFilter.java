package com.bluemsun.island.filter;

import com.bluemsun.island.enums.ReturnCode;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 登录验证
 * @author: Windlinxy
 * @create: 2021-10-14 22:32
 **/
public class AuthenticationFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        String token = request.getHeader("token");
        boolean jud = uri.contains("/users") &&  "POST".equals(request.getMethod())
                || uri.contains("/token")
                || uri.contains("/images");

        return jud;
    }


    private Map<String, Object> returnCode(ReturnCode status) {
        Map<String, Object> map = new HashMap<>(4);
        map.put("status", status.getCode());
        map.put("msg", status.getMessage());
        return map;
    }
}

