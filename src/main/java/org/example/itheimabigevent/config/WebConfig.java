package org.example.itheimabigevent.config;

import org.example.itheimabigevent.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //登陆接口和注册接口不拦截
//        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/register","/user/login","/user/register/**","/user/login/**");

//        registry.addInterceptor(loginInterceptor).excludePathPatterns("/user/**");
        registry.addInterceptor(loginInterceptor).addPathPatterns("/article/list")
                .excludePathPatterns("/user/**");
    }
}
