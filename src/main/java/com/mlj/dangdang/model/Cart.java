package com.mlj.dangdang.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    //存放数据的Map
    private Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
    //总价
    private double totalprice;

    public Map<Integer, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<Integer, CartItem> map) {
        this.map = map;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }

    public Cart(Map<Integer, CartItem> map, double totalprice) {
        super();
        this.map = map;
        this.totalprice = totalprice;
    }

    public Cart() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    public String toString() {
        return "Cart [map=" + map + ", totalprice=" + totalprice + "]";
    }


}
