package com.mlj.dangdang.action;

import com.mlj.dangdang.model.User;
import com.mlj.dangdang.service.UserService;
import com.mlj.dangdang.util.MD5Util;
import com.mlj.dangdang.util.MailUitls;
import com.mlj.dangdang.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用户控制层
 */
public class UserAction extends ActionSupport {

    private String email;//邮箱
    private String password;//密码
    private String name;//昵称
    private int userId;
    private User user;
    private int checkEmail;//1:可以注册 0：不可以注册
    private String loginMessage;
    private int para;//页面状态 1：登陆后跳转到添加地址 无：跳转首页
    private int code;//标识用户id

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getPara() {
        return para;
    }

    public void setPara(int para) {
        this.para = para;
    }

    public int getCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(int checkEmail) {
        this.checkEmail = checkEmail;
    }

    public String getLoginMessage() {
        return loginMessage;
    }

    public void setLoginMessage(String loginMessage) {
        this.loginMessage = loginMessage;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * （邮箱 密码 昵称 验证码）
     * 注册后直接登录
     *
     * @return
     */
    public String rejister() {
        System.out.println("进入注册action");
        String pass = MD5Util.generate(user.getPassword());//加密后的密码
        user.setPassword(pass);
        userService.rejister(user);
        MailUitls.sendMail(user.getEmail(), user.getId());
        return "rejister";
    }

    /**
     * 用户登录
     * （）
     *
     * @return
     */
    public String login() {
        User u = userService.login(email);//根据邮箱查出来user
        //判断密码是否一致
        boolean isLogin = MD5Util.verify(password, u.getPassword());
        if (isLogin == true) {
            Struts2ScopeUtil.setSessionAttribute("user", u);//将user放入session
            loginMessage = "登陆成功！";
            if (para == 1) {
                return "addAddress";
            } else {
                return "main";
            }
        } else {
            loginMessage = "登录失败，请重新登录！";
            return "error";
        }
    }

    /**
     * 查找邮箱是否被使用
     *
     * @return
     */
    public void checkEmail() {
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");

        boolean b = userService.checkEmail(email);
        System.out.println(checkEmail);
        if (b == true) {
            checkEmail = 1;
            try {
                response.getWriter().write(checkEmail + "");//可以注册
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            checkEmail = 0;
            try {
                response.getWriter().write(checkEmail + "");//不能注册
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 注册后激活用户
     *
     * @return
     */
    public String activate() {
        userService.activate(1, code);
        //激活成功后直接登录
        Struts2ScopeUtil.setSessionAttribute("user", userService.get(code));//将user放入session
        return "success";
    }

}
