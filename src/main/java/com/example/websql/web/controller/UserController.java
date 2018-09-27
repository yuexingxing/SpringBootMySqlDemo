package com.example.websql.web.controller;

import com.example.websql.entity.User;
import com.example.websql.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    //查询所有数据
    @GetMapping(value = "/query_user")
    public Map<String, Object> queryUser() {

        List<User> list = userServiceImpl.queryUser();
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }

    @GetMapping(value = "/query_user_by_id")
    public Map<String, Object> queryUserById(@RequestParam("id") int id) {

        User user = userServiceImpl.queryUserById(id);
        Map<String, Object> map = new HashMap<>();
        map.put("data", user);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }

    @PostMapping(value = "/insert_user")
    public Map<String, Object> insertUser(@RequestParam("name") String name, @RequestParam("age") String age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        userServiceImpl.insertUser(user);

        Map<String, Object> map = new HashMap<>();
        map.put("data", null);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }

    @PostMapping(value = "/update_user")
    public Map<String, Object> insertUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") String age) {

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);

        userServiceImpl.updateUser(user);

        Map<String, Object> map = new HashMap<>();
        map.put("data", null);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }

    @PostMapping(value = "/delete_user")
    public Map<String, Object> insertUser(@RequestParam("id") int id) {

        userServiceImpl.deleteUser(id);

        Map<String, Object> map = new HashMap<>();
        map.put("data", null);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }
}
