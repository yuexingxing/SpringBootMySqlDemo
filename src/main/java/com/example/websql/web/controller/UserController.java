package com.example.websql.web.controller;

import com.example.websql.Res;
import com.example.websql.entity.User;
import com.example.websql.service.impl.UserServiceImpl;
import com.example.websql.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    //查询所有数据
    @GetMapping(value = "/users")
    public Res queryUser() {

        List<User> list = userServiceImpl.queryUser();
        Map<String, Object> map = new HashMap<>();
        map.put("data", list);

        return Res.build(0, 0, "查询成功", map);
    }

    /**
     * url为路由形式
     * 当没有查到数据时，返回仍为json对象格式
     */
    @RequestMapping(value = "/users/{user_id}")
    public Res queryUserById(@PathVariable String user_id) {

        User user = userServiceImpl.queryUserById(user_id);

        return Res.build(0, 0, "查询成功", user == null ? new HashMap<>() : user);
    }

    @PostMapping(value = "/add")
    public Res addUser(@RequestParam("name") String name, @RequestParam("password") String password) {

        if (name.isEmpty() || password.isEmpty()) {
            return Res.build(1, 0, "姓名或密码不能为空", null);
        } else {

            User user = new User();
            user.setUser_id(Utils.getUUID());
            user.setName(name);
            user.setPassword(password);

            boolean flag = userServiceImpl.insertUser(user);
            return Res.build(0, 0, flag ? "插入成功!" : "插入失败!", null);
        }
    }

    @PostMapping(value = "/update")
    public Res update(@RequestParam("user_id") String user_id, @RequestParam("name") String name, @RequestParam("password") String password) {

        User user = new User();
        user.setUser_id(user_id);
        user.setName(name);
        user.setPassword(password);

        boolean flag = userServiceImpl.updateUser(user);
        return Res.build(flag ? 0 : 1, 0, flag ? "更新成功" : "用户不存在或更新失败", null);
    }

    @PostMapping(value = "/delete")
    public Res insertUser(@RequestParam("user_id") String user_id) {

        boolean flag = userServiceImpl.deleteUser(user_id);
        return Res.build(flag ? 0 : 1, 0, flag ? "删除成功" : "删除失败", null);
    }
}
