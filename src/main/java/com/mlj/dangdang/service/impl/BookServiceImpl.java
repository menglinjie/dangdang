package com.mlj.dangdang.service.impl;

import com.mlj.dangdang.dao.BookDao;
import com.mlj.dangdang.dao.CategoryDao;
import com.mlj.dangdang.model.Book;
import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.service.BookService;
import com.mlj.dangdang.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;


    @Cacheable(cacheNames = "bookCache")
    @Override
    public List<Book> bookList(int param) {
        return bookDao.selectByparam(param);
    }

    @Cacheable(cacheNames = "bookCache")
    @Override
    public Book get(int bookId) {
        return bookDao.select(bookId);
    }


}
