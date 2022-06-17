package com.example.kissodemo.config;

import com.baomidou.kisso.web.interceptor.SSOSpringInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author zhaokai
 * @since 2022-06-17
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        SSOSpringInterceptor ssoSpringInterceptor = new SSOSpringInterceptor();
        ssoSpringInterceptor.setHandlerInterceptor(new MySSOHandlerInterceptor());
        registry.addInterceptor(ssoSpringInterceptor).addPathPatterns("/**");
    }
}
