package com.mlj.dangdang.action;

import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.service.CategoryService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryAction extends ActionSupport {
    private int categoryId;
    private List<Category> categories;

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Autowired
    private CategoryService categoryService;

    //查找所有类别（递归）
    public String showAll() {
        categories = categoryService.getAll(categoryId);
        return "success";
    }
}
