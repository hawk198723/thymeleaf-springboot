package com.jason.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Controller
public class HelloController {
    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","<h1>wtf,spring boot thymeleaf</h1>");
        model.addAttribute("users", Arrays.asList("wow","hahah","Lol","wth"));
        return "test";
    }
}
