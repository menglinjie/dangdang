package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Category;

import java.util.List;

public interface CategoryService {

    //递归查找所有类别
    public List<Category> getAll(int categoryId);

}
