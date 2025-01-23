package com.wiperi.novuscrm.interceptor;

import com.wiperi.novuscrm.util.JWTUtils;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Override
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
            JWTUtils.parseToken(token);
        } catch (JwtException e) {
            response.setContentType("application/json");
            response.getWriter().write("{\"message\": \"Unauthorized\"}");
            response.setStatus(401);
            return false;
        }

        return true;
    }
}
