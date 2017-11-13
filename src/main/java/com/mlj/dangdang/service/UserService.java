package com.mlj.dangdang.service;

import com.mlj.dangdang.model.User;

public interface UserService {
    //用户登录
    public User login(String email);

    //用户注册(注册成功后自动登录)
    public void rejister(User user);

    //检测邮箱是否被注册
    public boolean checkEmail(String email);

    //根据id查用户
    public User get(int id);

    //激活用户
    public void activate(int status, int userId);
}
