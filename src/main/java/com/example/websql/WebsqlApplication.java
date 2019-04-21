package com.example.websql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling//开启定时器
@SpringBootApplication
public class WebsqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsqlApplication.class, args);
    }
}
