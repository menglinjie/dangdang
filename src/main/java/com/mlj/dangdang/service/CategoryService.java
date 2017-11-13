package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Category;

import java.util.List;

public interface CategoryService {

    //递归查找所有类别
    public List<Category> getAll(int categoryId);

    //递归方法

    //查询父类id查看其下类别
    public List<Category> getById(int categoryId);
}
