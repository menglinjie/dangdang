package com.mlj.dangdang.model;

import java.util.Date;

public class Order {

    private int id;
    private String number = new Date().toString() + this.getId();//订单号
    private double totleprice;//总价
    private Date createTime = new Date();
    private int status = 1;//1:已支付 0：未支付

    private User user;
    private Address address;


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getTotleprice() {
        return totleprice;
    }

    public void setTotleprice(double totleprice) {
        this.totleprice = totleprice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


}
