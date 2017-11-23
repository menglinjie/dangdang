package com.mlj.dangdang.test;

import com.mlj.dangdang.dao.BookDao;
import com.mlj.dangdang.dao.CategoryDao;
import com.mlj.dangdang.model.Book;
import com.mlj.dangdang.model.Category;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestBookDao {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testGetbyParam() {
        List<Book> books = bookDao.selectByparam(4);
        for (Book b:books
             ) {
            System.out.println(b);
        }
    }

    @Test
    public void testSelect(){
        System.out.println(bookDao.select(4));
    }
}
