package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.ShopingItem;

import java.util.List;

public interface CartDao {

    //查询购物车
    public List<ShopingItem> select();

    //查询数量，顺序存放
    public List<Integer> count();

    //查询商品价格，顺序存放
    public List<Double> price();

    //查询当当价格，顺序存放
    public List<Double> ddprice();

    //添加购物车
    public void insert(ShopingItem cart);

    //修改
    public void update(int count,int status);
}
