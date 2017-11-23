package com.mlj.dangdang.dao;

import com.mlj.dangdang.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookDao {

    //根据参数查找图书列表（编辑推荐1，热销2，最新上架3，新书热卖4）
    public List<Book> selectByparam(@Param("param") int param);


    //根据类别查找图书（排序分页）
    public List<Book> selectByCategory(int categoryId, int orderBy);


    //根据id查找单个图书
    public Book select(@Param("bookId") int bookId);
}
