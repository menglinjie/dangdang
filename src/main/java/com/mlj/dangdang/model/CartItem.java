package com.mlj.dangdang.model;


public class CartItem {
    //商品
    private Book book;
    //商品数量
    private Integer amount;
    //商品小计
    private double smallprice;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public double getSmallprice() {
        return smallprice;
    }

    public void setSmallprice(double smallprice) {
        this.smallprice = smallprice;
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
