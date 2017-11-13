package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Category;

import java.util.List;

public interface CategoryDao {

    public List<Category> getById(int categoryId);


}
