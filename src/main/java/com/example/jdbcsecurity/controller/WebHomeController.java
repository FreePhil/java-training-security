package com.example.jdbcsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/web")
public class WebHomeController {

    @GetMapping("hello")
    public String getMainPage() {
        return "index.html";
    }
}
