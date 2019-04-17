package com.example.websql.service;


import com.example.websql.entity.User;

import java.util.List;

public interface UserService{

    List<User> queryUser();
    User queryUserById(String userId);

    boolean insertUser(User user);

    boolean updateUser(User user);

    boolean deleteUser(String id);
}
