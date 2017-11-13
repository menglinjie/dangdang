package com.mlj.dangdang.model;

public class ShopingItem {

    private Book book;//图书
    private int count;//数量
    private double price;
    private double ddprice;//当当价


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = book.getPrice() * count;
    }

    public double getDdprice() {
        return ddprice;
    }

    public void setDdprice(double ddprice) {
        this.ddprice = book.getDdprice() * count;
    }
}
