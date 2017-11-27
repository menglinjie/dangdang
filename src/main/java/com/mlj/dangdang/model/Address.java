package com.mlj.dangdang.model;

import java.io.Serializable;

public class Address implements Serializable{

    private int id;
    private String uname;
    private String address;
    private int code1;//邮政编码
    private String phone;
    private String mobile;
    private int isDefault = 0;//是否默认1：是 0：不是

    private User user;//用户

    public int getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(int isDefault) {
        this.isDefault = isDefault;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCode1() {
        return code1;
    }

    public void setCode1(int code1) {
        this.code1 = code1;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", uname='" + uname + '\'' +
                ", address='" + address + '\'' +
                ", code1=" + code1 +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", isDefault=" + isDefault +
                ", user=" + user +
                '}';
    }
}
