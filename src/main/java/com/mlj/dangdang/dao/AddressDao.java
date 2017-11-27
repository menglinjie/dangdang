package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Address;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AddressDao {

    public int insert(Address address);

    public Address select(@Param("addressId") int addressId);

    public List<Address> selectAll(@Param("userId") int userId);

    public void update(Address address);

    public Address selectDefalt(@Param("userId") int userId);//查找默认地址
}
