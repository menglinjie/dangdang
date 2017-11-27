package com.mlj.dangdang.model;

import com.mlj.dangdang.util.IdWorker;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int orderid;
    private long number;//订单号
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

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        IdWorker iw = new IdWorker(1);
        try {
            this.number = iw.nextId();
        } catch (Exception e) {
            e.printStackTrace();
        }
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

    @Override
    public String toString() {
        return "Order{" +
                "orderid=" + orderid +
                ", number=" + number +
                ", totleprice=" + totleprice +
                ", createTime=" + createTime +
                ", status=" + status +
                ", user=" + user +
                ", address=" + address +
                '}';
    }
}
