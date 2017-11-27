package com.mlj.dangdang.action;

import com.mlj.dangdang.model.Address;
import com.mlj.dangdang.model.Cart;
import com.mlj.dangdang.model.Order;
import com.mlj.dangdang.model.User;
import com.mlj.dangdang.service.AddressService;
import com.mlj.dangdang.util.IdWorker;
import com.mlj.dangdang.util.Struts2ScopeUtil;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AddressAction extends ActionSupport {

    private Address address;
    private int addressId;
    private List<Address> addressList;
    private Order order1;

    public Order getOrder1() {
        return order1;
    }

    public void setOrder1(Order order1) {
        this.order1 = order1;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Autowired
    private AddressService addressService;

    public String add() {
        User user = (User) Struts2ScopeUtil.getSessionAttribute("user");
        if (address.getId() == 0) {
            address.setUser(user);
            address = addressService.add(address);
            return "add";
        } else {
            return "add";
        }


    }

    public String get() {
        address = addressService.get(addressId);
        HttpServletResponse response = ServletActionContext.getResponse();
        response.setCharacterEncoding("UTF-8");
        JSONObject json = JSONObject.fromObject(address);
        try {
            response.getWriter().print(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String getAll() {
        User user = (User) Struts2ScopeUtil.getSessionAttribute("user");
        if (user == null) {//判断用户是否登录
            Struts2ScopeUtil.setSessionAttribute("to", "1");//设置未登陆标识符
            return "login";//未登录跳转登录
        } else {
            addressList = addressService.getAll(user.getId());//获取该用户所有地址
            Address address1 = addressService.getDefalt(user.getId());//获取用户默认地址
            if (address1 != null) {
                address = address1;
            }
            return "addressList";
        }
    }


    public String addOrder() throws Exception {
        User user = (User) Struts2ScopeUtil.getSessionAttribute("user");
        IdWorker iw = new IdWorker(1);
        HttpServletRequest request = ServletActionContext.getRequest();

        Order order = new Order();
        Cart cart = (Cart) Struts2ScopeUtil.getSessionAttribute("cart");
        order.setTotleprice(cart.getTotalprice());
        order.setStatus(1);
        order.setAddress(address);
        order.setUser(user);
        order.setNumber(iw.nextId());
        addressService.addOrder(order);
        order1 = order;
        //清空购物车
        request.getSession().removeAttribute("cart");
        request.getSession().removeAttribute("cart2");
        return "order";
    }
}
