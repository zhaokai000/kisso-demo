package com.example.kissodemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhaokai
 * @since 2022-06-17
 */
@Controller
@RequestMapping("/")
public class UrlController {

    @GetMapping("to-login")
    public String login() {
        return "view/login";
    }

}
