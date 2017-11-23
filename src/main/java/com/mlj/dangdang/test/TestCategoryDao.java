package com.mlj.dangdang.test;

import com.mlj.dangdang.dao.CategoryDao;
import com.mlj.dangdang.model.Book;
import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.service.CategoryService;
import com.mlj.dangdang.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.LinkedList;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class TestCategoryDao {

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private CategoryService categoryService;

    @Test
    public void testGetAll() {
        List<Category> categories = categoryDao.getAll(1);
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

//    @Test
//    public void testGetBooks() {
//        List<Book> books = new LinkedList<>();//类别下所有图书
//        List<Category> categories = categoryDao.getBooks(1, 0, 1, 3);
//        for (Category c : categories
//                ) {
//
//            System.out.println(c);
//
//            List<Book> books1 = c.getBookList();//大类别的所有图书
//            for (Book b : books1//遍历大类别的所有图书，放入图书list
//                    ) {
//                books.add(b);
//            }
//
//            for (Category c1 : c.getCategoryList()//遍历大类别下的所有子类别
//                    ) {
//                for (Book b1 : c1.getBookList()
//                        ) {
//                    books.add(b1);//将子类别的图书放入图书list
//                }
//            }
//
//        }
//
//
//        for (Category cc : categories
//                ) {
//            System.out.println("============" + cc.getCname() + cc.getCount());
//            for (Category cc1 : cc.getCategoryList()
//                    ) {
//                System.out.println("============" + cc1.getCname() + cc1.getCount());
//            }
//        }
//
//        for (Book bb : books
//                ) {
//            System.out.println("============" + bb.getBookid() + bb.getBname());
//        }
//    }

    @Test
    public void testBooks() {
        List<Category> categories = categoryDao.books(1, 0, 1, 0);
        for (Category c : categories
                ) {
            System.out.println(c.getBookList());
        }

    }

    @Test
    public void testCount() {
        int count = categoryDao.count(5, 1);
        System.out.println(count + "=========");
    }

    @Test
    public void testGetBooksSrevice() {
        Page<Category> categoryPage = categoryService.getBooks(0, 2, 0, 1);
        System.out.println(categoryPage.getTotalPageCount() + "========总页数");
        System.out.println(
                "=======是否有下一页" + categoryPage.isHasNext() + "=====是否有上一页" + categoryPage.isHasPre());

        for (Category c : categoryPage.getItems()
                ) {
            System.out.println(c);
        }
    }


}


