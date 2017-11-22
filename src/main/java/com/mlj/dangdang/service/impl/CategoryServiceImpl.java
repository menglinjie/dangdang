package com.mlj.dangdang.service.impl;

import com.mlj.dangdang.dao.CategoryDao;
import com.mlj.dangdang.dao.Userdao;
import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.model.User;
import com.mlj.dangdang.service.CategoryService;
import com.mlj.dangdang.service.UserService;
import com.mlj.dangdang.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<Category> getAll(int categoryId) {
        return categoryDao.getAll(categoryId);
    }

    @Override
    public Page<Category> getBooks(int categoryId,
                                   int isPa,
                                   int orderBy,
                                   int pageNow) {
        int totalCount = categoryDao.count(categoryId, isPa);
        Page<Category> categoryPage = new Page<Category>(totalCount, pageNow);
        int startPos = categoryPage.getStartPos();
        List<Category> categoryList = categoryDao.books(categoryId, isPa, orderBy, startPos);
        categoryPage.setItems(categoryList);
        return categoryPage;
    }

}
