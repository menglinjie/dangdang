package com.mlj.dangdang.action;

import com.mlj.dangdang.model.Book;
import com.mlj.dangdang.service.BookService;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Bookaction extends ActionSupport {

    private int categoryId;
    private int bookId;
    private int orderBy;//排序 1：按上架时间排序(默认) 2：按销量排序 3：按字数排序
    private List<Book> recommendbooks;
    private List<Book> hotbooks;
    private List<Book> newbooks;
    private List<Book> newhotbooks;
    private Book book;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Book> getRecommendbooks() {
        return recommendbooks;
    }

    public void setRecommendbooks(List<Book> recommendbooks) {
        this.recommendbooks = recommendbooks;
    }

    public List<Book> getHotbooks() {
        return hotbooks;
    }

    public void setHotbooks(List<Book> hotbooks) {
        this.hotbooks = hotbooks;
    }

    public List<Book> getNewbooks() {
        return newbooks;
    }

    public void setNewbooks(List<Book> newbooks) {
        this.newbooks = newbooks;
    }

    public List<Book> getNewhotbooks() {
        return newhotbooks;
    }

    public void setNewhotbooks(List<Book> newhotbooks) {
        this.newhotbooks = newhotbooks;
    }

    public int getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(int orderBy) {
        this.orderBy = orderBy;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }


    @Autowired
    private BookService bookService;

    /**
     * 查看首页图书编辑推荐
     *
     * @return
     */
    public String recommendBook() {
        recommendbooks = bookService.bookList(1);
        return "recommend";
    }

    /**
     * 查看首页热销图书
     *
     * @return
     */
    public String hotBook() {
        hotbooks = bookService.bookList(2);
        return "hot";
    }

    /**
     * 查看首页最新上架图书
     *
     * @return
     */
    public String newBook() {
        newbooks = bookService.bookList(3);
        return "new";
    }


    /**
     * 查看首页新书热卖榜
     *
     * @return
     */
    public String newhotBook() {
        newhotbooks = bookService.bookList(4);
        return "main";
    }

    /**
     * @return
     */
    public String showBook() {
        book = bookService.get(bookId);
        return "book";
    }

}
