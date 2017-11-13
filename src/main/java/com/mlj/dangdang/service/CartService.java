package com.mlj.dangdang.service;

import com.mlj.dangdang.model.ShopingItem;

import java.util.List;

public interface CartService {

    /**
     * 查看购物车商品和数量
     *
     * @return
     */
    public List<ShopingItem> showCart();


    /**
     * 计算购物车商品总价（count*price）
     *
     * @return
     */
    public double totlePrice();


    /**
     * 计算购物车商品dd价（count*price）
     *
     * @return
     */
    public double totleddPrice();

    /**
     * 计算节省价格（totleprice-ddtotleprice）
     *
     * @return
     */
    public double chajia();

    /**
     * 添加购物车（判断bookid若存在，count++）
     *
     * @param cart
     */
    public void addCart(ShopingItem cart);

    /**
     * 修改购物车（修改后，重新计算totleprice ddtotleprice）
     *
     * @param count
     * @param status
     */
    public void modify(int count, int status);
}
