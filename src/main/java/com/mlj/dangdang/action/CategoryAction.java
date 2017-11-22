package com.mlj.dangdang.action;

import com.mlj.dangdang.model.Category;
import com.mlj.dangdang.service.CategoryService;
import com.mlj.dangdang.util.Page;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryAction extends ActionSupport {
    private int categoryId;//父类类别id
    private int childrenId;//子类类别id
    private List<Category> categories;//类别
    private Page<Category> categoryPage;//分页图书
    private int isPa;
    private int orderBy;
    private int pageNow;

    public int getChildrenId() {
        return childrenId;
    }

    public void setChildrenId(int childrenId) {
        this.childrenId = childrenId;
    }

    public Page<Category> getCategoryPage() {
        return categoryPage;
    }

    public void setCategoryPage(Page<Category> categoryPage) {
        this.categoryPage = categoryPage;
    }

    public int getIsPa() {
        return isPa;
    }

    public void setIsPa(int isPa) {
        this.isPa = isPa;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public int getPageNow() {
        return pageNow;
    }

    public void setPageNow(int pageNow) {
        this.pageNow = pageNow;
    }

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

    //根据类别查找图书
    public String bookList() {
        System.out.println(isPa + "==" + orderBy + "==" + pageNow + "==" + categoryId);
        categories = categoryService.getAll(categoryId);
        if (orderBy == 0) {//默认按时间排序
            orderBy = 1;
        }
        categoryPage = categoryService.getBooks(childrenId, isPa, orderBy, pageNow);
        System.out.println(categoryPage.getItems());
//        for (Book b:categoryPage.getItems()
//             ) {
//
//        }
        return "bookList";
    }
}
