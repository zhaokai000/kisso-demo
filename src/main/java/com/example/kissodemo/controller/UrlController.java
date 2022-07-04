package com.example.kissodemo.controller;

import com.baomidou.kisso.SSOConfig;
import com.baomidou.kisso.SSOHelper;
import com.baomidou.kisso.annotation.LoginIgnore;
import com.baomidou.kisso.common.CookieHelper;
import com.baomidou.kisso.enums.TokenOrigin;
import com.baomidou.kisso.security.token.SSOToken;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author zhaokai
 * @since 2022-06-17
 */
@Controller
@Slf4j
@RequestMapping("/")
public class UrlController {

    private final String username = "ad";
    private final String password = "123";

    @GetMapping("login")
    @LoginIgnore
    public String login() {
        return "login";
    }

    @GetMapping("logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        SSOConfig config = SSOConfig.getInstance();

        CookieHelper.clearCookieByName(request, response, config.getCookieName(),
                config.getCookieDomain(), config.getCookiePath());

        return "redirect:login";
    }

    @GetMapping("index")
    @LoginIgnore
    public String index() {
        return "index";
    }

    @GetMapping("do-login")
    @LoginIgnore
    public String doLogin(HttpServletRequest request, HttpServletResponse response, String username, String password, Model model) {
        log.info("username is: {}, password is: {}", username, password);

        if (!this.username.equals(username) || !this.password.equals(password)) {
            if (StringUtils.isNotBlank(username) || StringUtils.isNotBlank(password)) {
                model.addAttribute("msg", "用户名或密码错误！");
            }
            return "login";
        }

        // 其他逻辑省略

        SSOToken token = SSOToken.create().setId(0).setIssuer(username).setOrigin(TokenOrigin.COOKIE).setUserAgent(request);
        SSOHelper.setCookie(request, response, token);

        model.addAttribute("username", SSOHelper.getKissoService().getSSOToken(request).getIssuer());
        return "index";
    }

}
