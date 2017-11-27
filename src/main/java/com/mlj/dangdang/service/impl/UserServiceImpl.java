package com.mlj.dangdang.service.impl;

import com.mlj.dangdang.dao.Userdao;
import com.mlj.dangdang.model.User;
import com.mlj.dangdang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private Userdao userdao;

    @Override
    public User login(String email) {
        return userdao.select(email);//用户存在
    }

    @Override
    public void rejister(User user) {
        userdao.insert(user);
    }

    @Override
    public boolean checkEmail(String email) {
        User user = userdao.selectByEmail(email);
        if (user != null) {//用户存在
            return false;//不能注册
        } else {
            return true;//可以注册
        }
    }

    @Cacheable(cacheNames = "userCache")
    @Override
    public User get(int id) {
        return userdao.selectById(id);
    }

    @Override
    public void activate(int status, int userId) {
        userdao.update(status, userId);
    }
}
