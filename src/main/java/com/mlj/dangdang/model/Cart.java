package com.mlj.dangdang.model;

import java.util.Map;

public class Cart {

    private Map<Integer, ShopingItem> map;
    private double totalprice;//总价(根据key取出map价格相加)
    private double jiesheng;//节省（总价-根据key取出map dd价格相加）

    public Map<Integer, ShopingItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, ShopingItem> map) {
        this.map = map;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public double getJiesheng() {
        return jiesheng;
    }

    public void setJiesheng(double jiesheng) {
        this.jiesheng = jiesheng;
    }
}
