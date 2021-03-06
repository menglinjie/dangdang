package com.mlj.dangdang.model;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {

    private int id;
    private String cname;
    private int count;//类别数量
    private List<Category> categoryList;//子类类别集合

    private List<Book> bookList;//类别下的图书集合


    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", cname='" + cname + '\'' +
                ", count=" + count +
                ", categoryList=" + categoryList +
                ", bookList=" + bookList +
                '}';
    }
}
