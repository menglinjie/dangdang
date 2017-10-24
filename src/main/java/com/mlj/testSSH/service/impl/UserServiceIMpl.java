package com.mlj.testSSH.service.impl;

import com.mlj.testSSH.dao.UserDao;
import com.mlj.testSSH.model.User;
import com.mlj.testSSH.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceIMpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.select(username, password);
        return user;
    }

    @Override
    public List<User> showAll() {
        return userDao.selectAll();
    }

    @Override
    public boolean rejister(User user) {
        boolean b;
        int count = userDao.insert(user);
        if (count == 0) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }


    @Override
    public boolean remove(int id) {
        int count = userDao.delete(id);
        boolean b;
        if (count == 0) {
            b = false;
        } else {
            b = true;
        }
        return b;
    }
}
