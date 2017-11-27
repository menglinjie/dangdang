package com.mlj.dangdang.service.impl;

import com.mlj.dangdang.dao.AddressDao;
import com.mlj.dangdang.dao.BookDao;
import com.mlj.dangdang.dao.OrderDao;
import com.mlj.dangdang.model.Address;
import com.mlj.dangdang.model.Book;
import com.mlj.dangdang.model.Order;
import com.mlj.dangdang.service.AddressService;
import com.mlj.dangdang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private OrderDao orderDao;


    @Override
    public Address add(Address address) {
        addressDao.insert(address);
        return address;
    }

    @Cacheable(cacheNames = "addressCache")
    @Override
    public Address get(int addressId) {
        return addressDao.select(addressId);
    }

    @Cacheable(cacheNames = "addressCache")
    @Override
    public List<Address> getAll(int userId) {
        return addressDao.selectAll(userId);
    }

    @Override
    public void update(Address address) {
        addressDao.update(address);
    }

    @Cacheable(cacheNames = "addressCache")
    @Override
    public Address getDefalt(int userId) {
        return addressDao.selectDefalt(userId);
    }

    @Override
    public void addOrder(Order order) {
        System.out.println(order);
        orderDao.add(order);
    }
}
