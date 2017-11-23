package com.mlj.dangdang.service.impl;

import com.mlj.dangdang.dao.BookDao;
import com.mlj.dangdang.model.Book;
import com.mlj.dangdang.model.Cart;
import com.mlj.dangdang.model.CartItem;
import com.mlj.dangdang.service.CartService;
import com.mlj.dangdang.util.BigdecimalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartserviceImpl implements CartService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Cart add(int bookId, Cart oldCart) {
        System.out.println(bookDao);
        Book book = bookDao.select(bookId);
        //如果购物车内包含此商品，修改商品数量
        if (oldCart.getMap().containsKey(bookId)) {
            CartItem cartItem = oldCart.getMap().get(bookId);//得到cartitem
            cartItem.setAmount(cartItem.getAmount() + 1);//修改商品数量
            cartItem.setSmallprice(BigdecimalUtil.add(cartItem.getSmallprice()
                    , book.getDdprice()));//修改商品小计
        } else {//如果购物车内不包含此商品
            CartItem cartItem = new CartItem();//创建一个Cartitem
            cartItem.setBook(book);//商品放入
            cartItem.setAmount(1);
            cartItem.setSmallprice(book.getDdprice());
            oldCart.getMap().put(bookId, cartItem);//新的cartitem放入map
        }
        //计算购物车总价
        oldCart.setTotalprice(BigdecimalUtil.add(oldCart.getTotalprice(), book.getDdprice()));
        return oldCart;
    }

    @Override
    public void update(int bookId, Cart oldCart, int amount) {
        CartItem cartItem = oldCart.getMap().get(bookId);
        cartItem.setAmount(amount);//修改数量
    }

    @Override
    public void delete(int bookId, Cart oldCart) {
        oldCart.getMap().remove(bookId);
    }

}
