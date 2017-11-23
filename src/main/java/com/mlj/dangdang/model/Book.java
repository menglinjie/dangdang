package com.mlj.dangdang.model;

import java.util.Date;

public class Book {

    private int bookid;
    private String bname;
    private String author;
    private String publisher;//出版社
    private Date publishTime;//出版时间
    private double price;
    private double ddprice;
    private String brief;
    private int edition;//版次
    private Date printTime;//打印时间
    private int print;//印刷次数
    private String ISBN = new Date().toString();//编号
    private int words;
    private int pages;
    private String format;//装订方式
    private int paper;
    private String packa;//包装
    private int recommend = 0;//1:是被编辑推荐 0：没有被编辑推荐
    private String authorBrief;//作者简介
    private String comment;//媒体评论
    private int sales;//销量
    private String img;

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    private Category category;//所属类别


    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDdprice() {
        return ddprice;
    }

    public void setDdprice(double ddprice) {
        this.ddprice = ddprice;
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief;
    }

    public int getEdition() {
        return edition;
    }

    public void setEdition(int edition) {
        this.edition = edition;
    }

    public Date getPrintTime() {
        return printTime;
    }

    public void setPrintTime(Date printTime) {
        this.printTime = printTime;
    }

    public int getPrint() {
        return print;
    }

    public void setPrint(int print) {
        this.print = print;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getWords() {
        return words;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public int getPaper() {
        return paper;
    }

    public void setPaper(int paper) {
        this.paper = paper;
    }

    public String getPacka() {
        return packa;
    }

    public void setPacka(String packa) {
        this.packa = packa;
    }

    public int getRecommend() {
        return recommend;
    }

    public void setRecommend(int recommend) {
        this.recommend = recommend;
    }

    public String getAuthorBrief() {
        return authorBrief;
    }

    public void setAuthorBrief(String authorBrief) {
        this.authorBrief = authorBrief;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookid=" + bookid +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishTime=" + publishTime +
                ", price=" + price +
                ", ddprice=" + ddprice +
                ", brief='" + brief + '\'' +
                ", edition=" + edition +
                ", printTime=" + printTime +
                ", print=" + print +
                ", ISBN='" + ISBN + '\'' +
                ", words=" + words +
                ", pages=" + pages +
                ", format='" + format + '\'' +
                ", paper=" + paper +
                ", packa='" + packa + '\'' +
                ", recommend=" + recommend +
                ", authorBrief='" + authorBrief + '\'' +
                ", comment='" + comment + '\'' +
                ", sales=" + sales +
                ", img='" + img + '\'' +
                ", category=" + category +
                '}';
    }
}
