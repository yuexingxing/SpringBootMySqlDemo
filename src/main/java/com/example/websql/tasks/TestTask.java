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

    /**
     * cron表达式
     * 自动设置启动任务时间范围
     * 可以引用 cron 表达式 并且 位数为：6位
     * 例子如下： 4-40  *  *  *  *  ？
     * 4-40 表示一位
     * http://cron.qqe2.com
     * spring boot 是不支持年的
     */
    @Scheduled(cron = "4-40 * * * * ?")
    public void test() {
        System.out.println("现在时间: " + dateFormat.format(new Date()));
    }
}
