package com.yangzhong.itlias.interceptor;

import com.yangzhong.itlias.util.JWT;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        判断是不是登陆请求
        String uri = request.getRequestURI();
        if(uri.contains("/login")){
            return true;
        }
//        校验jwt令牌，看看有没有被修改
        String token = request.getHeader("token");
        if(token == null || token.isEmpty()){
            response.setStatus(401);
            return false;
        }
        try {
            Claims claims = JWT.parseToken(token);
            Integer empId = (Integer)claims.get("id");
            String empName= (String)claims.get("name");
            com.yangzhong.itlias.util.Thread.setCurrentId(empId);
            com.yangzhong.itlias.util.Thread.setCurrentEmpName(empName);
            return true;
        } catch (Exception e) {
            response.setStatus(401);
            return false;
        }
    }
}
