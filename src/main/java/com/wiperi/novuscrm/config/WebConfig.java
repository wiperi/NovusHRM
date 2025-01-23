package com.wiperi.novuscrm.config;

import com.wiperi.novuscrm.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private AuthInterceptor authInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html", "/", "/login", "/register", "/v3/api-docs/**", "/favicon.ico"
                , "/swagger-ui.html", "/swagger-ui/**", "/swagger-resources/**", "/webjars/**");

    }
}
