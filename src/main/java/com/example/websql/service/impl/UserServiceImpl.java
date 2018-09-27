package com.example.websql.service.impl;

import com.example.websql.dao.UserDao;
import com.example.websql.entity.User;
import com.example.websql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> queryUser() {
        return userDao.queryUser();
    }

    @Override
    public User queryUserById(int userId) {
        return userDao.queryUserById(userId);
    }

    @Transactional
    @Override
    public boolean insertUser(User user) {

        if (user == null) {
            return false;
        }


        int effectNum = userDao.insertUser(user);
        if (effectNum > 0) {
            return true;
        }

        return false;
    }

    @Transactional
    @Override
    public boolean updateUser(User user) {

        int effectNum = userDao.updateUser(user);
        if (effectNum > 0) {
            return true;
        }

        return false;
    }

    @Transactional
    @Override
    public boolean deleteUser(int id) {

        int effectNum = userDao.deleteUser(id);
        if (effectNum > 0) {
            return true;
        }

        return false;
    }
}
