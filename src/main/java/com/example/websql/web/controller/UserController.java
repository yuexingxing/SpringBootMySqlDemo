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

        Res res = new Res();
        res.setData(map);
        res.setSuccess(0);
        return res;
    }

    /**
     * url为路由形式
     * */
    @RequestMapping(value = "/users/{user_id}")
    public Res queryUserById(@PathVariable String user_id) {

        User user = userServiceImpl.queryUserById(user_id);

        Res res = new Res();
        res.setData(user);
        res.setSuccess(0);
        return res;
    }

    @PostMapping(value = "/add")
    public Res addUser(@RequestParam("name") String name, @RequestParam("password") String password) {

        Res res = new Res();
        if (name.isEmpty() || password.isEmpty()) {
            res.setSuccess(1);
            res.setMessage("姓名或密码不能为空");
        } else {

            User user = new User();
            user.setUser_id(Utils.getUUID());
            user.setName(name);
            user.setPassword(password);

            boolean flag = userServiceImpl.insertUser(user);
            res.setSuccess(flag ? 0 : 1);
            if (flag) {
                res.setMessage("插入成功!");
            } else {
                res.setMessage("插入失败!");
            }
        }

        return res;
    }

    @PostMapping(value = "/update")
    public Res updateUser(@RequestParam("user_id") String user_id, @RequestParam("name") String name, @RequestParam("password") String password) {

        User user = new User();
        user.setUser_id(user_id);
        user.setName(name);
        user.setPassword(password);

        boolean flag = userServiceImpl.updateUser(user);

        Res res = new Res();
        res.setSuccess(flag ? 0 : 1);
        if (flag) {
            res.setMessage("更新成功!");
        } else {
            res.setMessage("用户不存在或更新失败");
        }

        return res;
    }

    @PostMapping(value = "/delete")
    public Map<String, Object> insertUser(@RequestParam("user_id") String user_id) {

        userServiceImpl.deleteUser(user_id);

        Map<String, Object> map = new HashMap<>();
        map.put("data", null);
        map.put("success", 1);
        map.put("code", "1001");

        return map;
    }
}
