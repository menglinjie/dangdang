package com.mlj.dangdang.model;

import java.io.Serializable;

public class OrderBook implements Serializable {

    private int id;
    private int count;//商品数量
    private double subtotle;//小计
    private Order order;
    private Book book;

    public double getSubtotle() {
        return subtotle;
    }

    public void setSubtotle(double subtotle) {
        this.subtotle = this.count * this.book.getPrice();//数量*单价
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
