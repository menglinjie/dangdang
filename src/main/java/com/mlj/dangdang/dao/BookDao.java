package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Book;

import java.util.List;

public interface BookDao {

    //根据类别查找图书（排序分页）
    public List<Book> selectByCategory(int categoryId, int orderBy);

    //根据参数查找图书列表（编辑推荐，热销，最新上架，新书热卖）
    public List<Book> selectByparam(int param);

    //根据id查找单个图书
    public Book select(int bookId);
}
