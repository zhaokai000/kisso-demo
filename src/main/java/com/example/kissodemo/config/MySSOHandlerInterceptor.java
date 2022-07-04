package com.example.kissodemo.config;

import com.baomidou.kisso.web.handler.SSOHandlerInterceptor;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author zhaokai
 * @since 2022-06-17
 */
@Slf4j
public class MySSOHandlerInterceptor implements SSOHandlerInterceptor {

    @Override
    public boolean preTokenIsNullAjax(HttpServletRequest request, HttpServletResponse response) {
        // 做一些其他的处理
        log.warn("preTokenIsNullAjax false");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("preTokenIsNullAjax Forbidden");
        } catch (IOException e) {
            log.error("preTokenIsNullAjax error", e);
        }
        return false;
    }

    @Override
    public boolean preTokenIsNull(HttpServletRequest request, HttpServletResponse response) {
        // 做一些其他的处理
        log.warn("preTokenIsNull false");
        try {
            PrintWriter writer = response.getWriter();
            writer.write("preTokenIsNull Forbidden");
        } catch (IOException e) {
            log.error("preTokenIsNull error", e);
        }
        return false;
    }
}
