package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Address;

import java.util.List;

public interface AddressService {

    public void add(Address address);

    public Address get(int addressId);

    public List<Address> getAll(int userId);

    public void update(Address address);
}
