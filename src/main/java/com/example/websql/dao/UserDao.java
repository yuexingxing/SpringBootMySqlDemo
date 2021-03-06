package com.example.websql.dao;

import com.example.websql.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UserDao {

    List<User> queryUser();
    User queryUserById(String userId);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(String id);

}
