package com.mlj.dangdang.action;

import com.mlj.dangdang.model.Address;
import com.opensymphony.xwork2.ActionSupport;

public class AddressAction extends ActionSupport {

    private Address address;
    private int addressId;
    private int userId;

    public void setAddress(Address address) {
        this.address = address;
    }


    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    //添加地址
    public String addAddress() {
        return null;
    }

    //根据id查找地址
    public String getAddress() {
        return null;
    }

    //根据用户查找所有地址
    public String getAll(){
        return null;
    }

    //修改地址
    public String modify() {
        return null;
    }

}
