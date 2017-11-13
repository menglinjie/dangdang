package com.mlj.dangdang.test;


import com.mlj.dangdang.model.User;
import com.mlj.dangdang.service.UserService;
import com.mlj.dangdang.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestUserService {

    @Autowired
    private UserService userService;

    @Test
    public void testRegister() {
        User user = new User();
        user.setCreateTime(new Date());
        user.setEmail("1111");
        user.setName("mmm11");
        user.setPassword(MD5Util.generate("11111"));
        user.setStatus(1);

        userService.rejister(user);
        System.out.println(user.getId()+"============");
    }

    @Test
    public void testLogin() {
        User user = userService.login("111");
        boolean b = MD5Util.verify("11", user.getPassword());
        System.out.println(b);
       // System.out.println(user.getId() + user.getName());
    }

    @Test
    public void testGet() {
        User user = userService.get(2);
        System.out.println("=================" + user.getName());
    }

    @Test
    public void testGetByEmail() {
        boolean isExit = userService.checkEmail("2111");
        System.out.println(isExit);
    }
}
