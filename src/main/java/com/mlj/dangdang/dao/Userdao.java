package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.User;
import org.apache.ibatis.annotations.Param;

public interface Userdao {

    //根据用户名查找用户（密码加密加盐登录）
    public User select(@Param("email") String email);

    //添加用户
    public void insert(User user);

    //查找邮箱是否被注册
    public User selectByEmail(String email);

    //根据id查找用户
    public User selectById(int id);

    //修改用户状态
    public void update(@Param("status") int status, @Param("userId") int userId);
}
