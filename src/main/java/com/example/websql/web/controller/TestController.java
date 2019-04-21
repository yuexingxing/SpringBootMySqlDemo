package com.example.websql.web.controller;

import com.alibaba.fastjson.JSON;
import com.example.websql.Res;
import com.example.websql.entity.Project;
import com.example.websql.entity.User;
import com.example.websql.redis.RedisUtil;
import com.example.websql.service.ProjectService;
import com.example.websql.service.impl.UserServiceImpl;
import com.example.websql.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @GetMapping(value = "/redis")
    public Res getProject() {

        List<User> list = userServiceImpl.queryUser();
        Jedis jedis = RedisUtil.getJedis();

        Map<String, String> userMap = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {

            User user = list.get(i);
            userMap.put("u" + i, JSON.toJSONString(user));
        }
        jedis.hmset("t_user", userMap);

        Res res = new Res();
        res.setSuccess(0);
        return res;
    }
}
