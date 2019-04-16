package com.example.websql.web.controller;

import com.example.websql.Res;
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
    public Res queryUser() {

        List<User> list = userServiceImpl.queryUser();
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);

        Res res = new Res();
        res.setData(map);
        res.setSuccess(0);
        return res;
    }

    @GetMapping(value = "/query_user_by_id")
    public Res queryUserById(@RequestParam("id") int id) {

        User user = userServiceImpl.queryUserById(id);

        Res res = new Res();
        res.setData(user);
        res.setSuccess(0);
        return res;
    }

    @PostMapping(value = "/insert_user")
    public Res insertUser(@RequestParam("name") String name, @RequestParam("age") String age) {

        User user = new User();
        user.setName(name);
        user.setAge(age);

        boolean flag = userServiceImpl.insertUser(user);

        Res res = new Res();
        res.setSuccess(flag ? 0 : 1);
        if (flag) {
            res.setMessage("插入成功!");
        }

        return res;
    }

    @PostMapping(value = "/update_user")
    public Map<String, Object> insertUser(@RequestParam("id") int id, @RequestParam("name") String name, @RequestParam("age") String age) {

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAge(age);

        boolean flag = userServiceImpl.updateUser(user);

        Map<String, Object> map = new HashMap<>();
        map.put("data", null);
        map.put("success", flag ? 1 : 0);
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
