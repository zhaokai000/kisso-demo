package com.example.kissodemo.controller;

import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.enums.TokenOrigin;
import com.baomidou.kisso.security.token.SSOToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaokai
 * @since 2022-06-17
 */
@RestController
@RequestMapping("/")
@Slf4j
public class SSOController {

    @PostMapping("do-login")
    public boolean doLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        log.info("username is: {} and password is: {}", username, password);
        if (StringUtils.isBlank(username) || StringUtils.isBlank(password)) {
            throw new NullPointerException();
        }
        SSOToken token = SSOToken.create().setId(0).setIssuer(username).setOrigin(TokenOrigin.COOKIE).setUserAgent(request);
        SSOHelper.setCookie(request, response, token);
        return true;
    }

}
