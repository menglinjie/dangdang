package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Cart;
import com.mlj.dangdang.model.CartItem;
import com.mlj.dangdang.model.ShopingItem;

import java.util.List;

public interface CartService {

    //添加购物车
    public Cart add(int bookId, Cart oldCart);

    //修改数量
    public void update(int bookId, Cart oldCart, int amount);

    //删除购物车商品
    public void delete(int bookId, Cart oldCart);
}
