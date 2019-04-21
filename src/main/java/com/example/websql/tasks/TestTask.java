package com.example.websql.tasks;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    //定义每3秒执行任务
    @Scheduled(fixedRate = 3000)
    public void reportCunnentTime() {
        System.out.println("现在时间: " + dateFormat.format(new Date()));
    }
}
