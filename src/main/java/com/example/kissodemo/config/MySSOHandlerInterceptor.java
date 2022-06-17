package com.example.kissodemo.config;

import com.baomidou.kisso.web.handler.SSOHandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaokai
 * @since 2022-06-17
 */
public class MySSOHandlerInterceptor implements SSOHandlerInterceptor {

    @Override
    public boolean preTokenIsNullAjax(HttpServletRequest request, HttpServletResponse response) {
        // 做一些其他的处理
        return false;
    }

    @Override
    public boolean preTokenIsNull(HttpServletRequest request, HttpServletResponse response) {
        // 做一些其他的处理
        return false;
    }
}
