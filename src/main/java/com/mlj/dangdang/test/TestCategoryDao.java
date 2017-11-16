package com.mlj.dangdang.test;

import com.mlj.dangdang.dao.CategoryDao;
import com.mlj.dangdang.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestCategoryDao {

    @Autowired
    private CategoryDao categoryDao;

    @Test
    public void testGetAll() {
        List<Category> categories = categoryDao.getAll(0);
        System.out.println("测试获取所有类别========》" + categories);

        for (Category c : categories
                ) {
            System.out.println(c.getCname() + "=========" + c.getCount());
            List<Category> childs = c.getCategoryList();
            for (Category c1 : childs
                    ) {
                System.out.println(c1.getCname());
            }

        }
    }

}
