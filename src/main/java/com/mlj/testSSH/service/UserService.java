package com.mlj.testSSH.service;


import com.mlj.testSSH.model.User;

import java.util.List;

public interface UserService {

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password);

    /**
     * 查找所有用户
     *
     * @return
     */
    public List<User> showAll();

    /**
     * 注册
     *
     * @param user
     */
    public boolean rejister(User user);

    /**
     * 删除
     *
     * @param id
     */
    public boolean remove(int id);
}
