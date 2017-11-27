package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Address;
import com.mlj.dangdang.model.Order;

import java.util.List;

public interface AddressService {

    public Address add(Address address);

    public Address get(int addressId);

    public List<Address> getAll(int userId);

    public void update(Address address);

    public Address getDefalt(int userId);

    public void addOrder(Order order);
}
