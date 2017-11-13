package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Book;

import java.util.List;

public interface BookService {

    //查看图书列表

    /**
     * 如果类别id为空，则按param查找（不分页，不排序）；如果类别id不为空，则按类别和orderid查找（分页，排序）；
     *
     * @param categoryId
     * @param param      //1:查看编辑推荐 2：查看热销图书 3：查看最新上架图书 4：查看新书热卖榜
     * @param orderBy    //排序 1：按上架时间排序(默认) 2：按销量排序 3：按字数排序
     * @return
     */
    public List<Book> bookList(int categoryId, int param, int orderBy);

    //查找单个图书
    public Book get(int bookId);
}
