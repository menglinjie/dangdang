package com.mlj.testSSH.action;

import com.mlj.testSSH.model.User;
import com.mlj.testSSH.service.UserService;
import com.mlj.testSSH.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserAction extends ActionSupport {

    @Autowired
    private UserService userService;

    private User user;
    private String username;
    private String password;
    private int age;
    private List<User> users;
    private int id;
    private String deleteMessage;

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    /**
     * 注册
     *
     * @return
     */
    public String rejister() {
        boolean b = userService.rejister(user);
        if (b == true) {
            return "success";
        } else {
            return "error";
        }
    }

    /**
     * 登录
     *
     * @return
     */
    public String login() {
        User u = userService.login(username, password);
        if (u != null) {
            System.out.println("登陆成功");
            Struts2ScopeUtil.setSessionAttribute("username", username);
            return "success";
        } else {
            System.out.println("登录失败");
            return "error";
        }
    }

    public String showAll() {
        users = userService.showAll();
        return "showAll";
    }

    public String delete() {
        boolean b = userService.remove(id);
        if (b == false) {
            deleteMessage = "删除失败";
            return "error";
        } else {
            deleteMessage = "删除成功";
            return "success";
        }
    }
}
