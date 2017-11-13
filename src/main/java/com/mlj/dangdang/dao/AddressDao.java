package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Address;

import java.util.List;

public interface AddressDao {

    public void insert(Address address);

    public Address select(int addressId);

    public List<Address> selectAll(int userId);

    public void update(Address address);
}
