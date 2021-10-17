package com.bluemsun.island.interceptor;

import com.bluemsun.island.enums.ReturnCode;
import com.bluemsun.island.util.JwtUtil;
import com.bluemsun.island.util.ResponseUtil;
import com.google.gson.Gson;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: BulemsunIsland
 * @description: 登录验证
 * @author: Windlinxy
 * @create: 2021-10-14 22:32
 **/
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uri = request.getRequestURI();
        System.out.println(uri);
        String token = request.getHeader("token");
        boolean jud = uri.contains("/users") &&  "POST".equals(request.getMethod())
                || uri.contains("/token")
                || uri.contains("/images")
                || "/bluemsun_island/".equals(uri)
                || "/".equals(uri);
        if(jud){
            return true;
        }else if(!JwtUtil.verify(token)) {
            returnCode(ReturnCode.ERROR_NO_LOGIN, response);
            return false;
//        }else if(JwtUtil.getRole(token)==0){
//            if(uri.contains("/"))
//        }
        }else {
            return true;
        }

    }


    private void returnCode(ReturnCode status,HttpServletResponse response) throws IOException {

        Map<String, Object> map = new HashMap<>(4);
        response.setCharacterEncoding("utf-8");
        map.put("status", status.getCode());
        map.put("msg", status.getMessage());
        Gson gson = new Gson();
        PrintWriter out;
        String jsonString;
        out = response.getWriter();
        jsonString = gson.toJson(map);
        out.println(jsonString);
        out.flush();
    }
}

