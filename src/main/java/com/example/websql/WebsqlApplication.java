package com.example.websql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时器
@EnableScheduling
//开启异步调用方法
@EnableAsync

@SpringBootApplication
public class WebsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsqlApplication.class, args);
    }
}
