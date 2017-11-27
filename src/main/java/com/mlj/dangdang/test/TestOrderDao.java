package com.mlj.dangdang.test;

import com.mlj.dangdang.dao.AddressDao;
import com.mlj.dangdang.dao.OrderDao;
import com.mlj.dangdang.dao.Userdao;
import com.mlj.dangdang.model.Address;
import com.mlj.dangdang.model.Order;
import com.mlj.dangdang.model.User;
import com.mlj.dangdang.util.IdWorker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestOrderDao {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private Userdao userdao;
    @Autowired
    private AddressDao addressDao;

    @Test
    public void testAdd() throws Exception {
        IdWorker iw2 = new IdWorker(2);
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setNumber(iw2.nextId());
        order.setStatus(1);
        order.setTotleprice(45);
        Address address = addressDao.select(1);
        User user = userdao.selectById(29);
        order.setAddress(address);
        order.setUser(user);
        orderDao.add(order);
    }

}
