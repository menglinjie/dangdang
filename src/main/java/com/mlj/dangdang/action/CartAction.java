package com.mlj.dangdang.action;

import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport {

    private int bookId;
    private int count;
    private int status;

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 查看购物车（查看商品，查看总价，查看数量，查看节省金额）
     *
     * @return
     */
    public String showCart() {
        return null;
    }

    /**
     * 添加商品到购物车
     *
     * @return
     */
    public String addCart() {
        return null;
    }

    /**
     * 修改购物车商品（变更后要重新计算价格，修改对应的商品数量）
     * status 0 :删除 1：恢复
     *
     * @return
     */
    public String modify(int count, int status) {
        return null;
    }

}
