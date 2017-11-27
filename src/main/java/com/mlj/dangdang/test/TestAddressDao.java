package com.mlj.dangdang.test;

import com.mlj.dangdang.dao.AddressDao;
import com.mlj.dangdang.dao.Userdao;
import com.mlj.dangdang.model.Address;
import com.mlj.dangdang.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestAddressDao {

    @Autowired
    private AddressDao addressDao;
    @Autowired
    private Userdao userdao;

    @Test
    public void testInsert() {
        Address address = new Address();
        User user = userdao.selectById(29);
        address.setAddress("河南省许昌市建安区2222222222");
        address.setUser(user);
        address.setCode1(461000);
        address.setIsDefault(0);
        address.setMobile("15738360702");
        address.setPhone("154545");
        address.setUname("孟孟");
        int addressid = addressDao.insert(address);
        System.out.println(address.getId());
    }

    @Test
    public void testSelect() {
        Address address = addressDao.select(2);
        System.out.println(address);
    }

    @Test
    public void testSelectAll() {
        List<Address> addressList = addressDao.selectAll(29);
        for (Address a : addressList
                ) {
            System.out.println(a);
        }

    }

    @Test
    public void testUpdate() {
        Address address = new Address();
        User user = userdao.selectById(29);
        address.setId(2);
        address.setAddress("上海市龙茗路");
        address.setUser(user);
        address.setCode1(450000);
        address.setIsDefault(0);
        address.setMobile("15738360702");
        address.setPhone("154545");
        address.setUname("文卡aaaaa");
        addressDao.update(address);
        Address address1 = addressDao.select(2);
        System.out.println(address1);
    }

    @Test
    public void test1(){
        Address address = addressDao.selectDefalt(1);
        System.out.println(address);
    }
}
