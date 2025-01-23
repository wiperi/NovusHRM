package com.wiperi.novuscrm.interceptor;

import com.wiperi.novuscrm.util.JWTUtils;
import com.wiperi.novuscrm.util.UserContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
    @Order(1)
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("AuthInterceptor preHandling");

        String token = request.getHeader("Authorization");


        if (token == null || !token.startsWith("Bearer")) {
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Unauthorized\"}");
            response.setStatus(401);
            return false;
        }

        token = token.substring(7);


        // check token
        try {
            var claims = JWTUtils.parseToken(token);
            var empId = Integer.valueOf(claims.get("empId").toString());
            UserContext.setUser(empId);
        } catch (JwtException e) {
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Unauthorized\"}");
            response.setStatus(401);
            return false;
        }

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("AuthInterceptor afterCompletion");
        UserContext.clear();
    }
}
