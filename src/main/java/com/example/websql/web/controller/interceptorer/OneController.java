package com.example.websql.web.controller.interceptorer;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/one")
public class OneController {

    @RequestMapping("/test")
    public String test() {

        return "拦截器测试";
    }
}
