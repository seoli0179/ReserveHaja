package com.example.reservehaja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String indexPage(){
        return "index";
    }

    @GetMapping("/auth/login")
    public String loginPage(){
        return "/oauth2/login";
    }

    @GetMapping("/auth/join")
    public String joinPage(){
        return "/oauth2/join";
    }

    @GetMapping("/reserve")
    public String reservePage(){
        return "/reserve/reserve";
    }

}
