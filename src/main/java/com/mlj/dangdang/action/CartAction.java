package com.mlj.dangdang.action;

import com.mlj.dangdang.model.Cart;
import com.mlj.dangdang.service.CartService;
import com.mlj.dangdang.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

public class CartAction extends ActionSupport {

    private int bookId;//图书id
    private int amount;//数量

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    @Autowired
    private CartService addcartService;

    public String addCart() {

        //获取旧的购物车
        Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("cart");
        if (oldCart == null) {//旧的购物车不存在，创建一个
            oldCart = new Cart();
        }
        Cart newCart = addcartService.add(bookId, oldCart);//添加购物车，返回一个新购物车
        System.out.println(newCart.getMap().get(bookId).getBook());
        Struts2ScopeUtil.setSessionAttribute("cart", newCart);//将新购物车放入session,覆盖旧的购物车
        return "cart";
    }

    public String update() {
        Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("cart");
        addcartService.update(bookId, oldCart, amount);
        Struts2ScopeUtil.setSessionAttribute("cart", oldCart);//将新购物车放入session,覆盖旧的购物车
        return "cart";
    }

    public String delete() {
        Cart oldCart = (Cart) Struts2ScopeUtil.getSessionAttribute("cart");
        addcartService.delete(bookId, oldCart);
        Struts2ScopeUtil.setSessionAttribute("cart", oldCart);//将新购物车放入session,覆盖旧的购物车
        //获取旧的2购物车
        Cart oldCart2 = (Cart) Struts2ScopeUtil.getSessionAttribute("cart2");
        if (oldCart2 == null) {//旧的购物车不存在，创建一个
            oldCart2 = new Cart();
        }
        Cart newCart2 = addcartService.add(bookId, oldCart2);
        Struts2ScopeUtil.setSessionAttribute("cart2", newCart2);//将新购物车放入session,覆盖旧的购物车
        return "cart";
    }
}
