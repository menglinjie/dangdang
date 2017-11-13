package com.mlj.dangdang.action;

import com.opensymphony.xwork2.ActionSupport;

public class Bookaction extends ActionSupport {

    private int categoryId;
    private int bookId;
    private int param;//1:查看编辑推荐 2：查看热销图书 3：查看最新上架图书 4：查看新书热卖榜
    private int orderBy;//排序 1：按上架时间排序(默认) 2：按销量排序 3：按字数排序

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getParam() {
        return param;
    }

    public void setParam(int param) {
        this.param = param;
    }

    /**
     * 查看图书列表（排序）
     *
     * @return
     */
    public String bookList() {
        return null;
    }

    /**
     * 查看单个图书
     *
     * @return
     */
    public String showBook() {
        return null;
    }

}
