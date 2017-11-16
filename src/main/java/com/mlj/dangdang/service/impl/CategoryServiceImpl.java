package com.mlj.dangdang.service.impl;

import com.mlj.dangdang.dao.CategoryDao;
import com.mlj.dangdang.dao.Userdao;
import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.model.User;
import com.mlj.dangdang.service.CategoryService;
import com.mlj.dangdang.service.UserService;
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

}
