package com.mlj.dangdang.service;

import com.mlj.dangdang.model.Book;

import java.util.List;

public interface BookService {

    //查看首页图书推荐

    /**
     * @param param //1:查看编辑推荐 2：查看热销图书 3：查看最新上架图书 4：查看新书热卖榜
     * @return
     */
    public List<Book> bookList(int param);


}
