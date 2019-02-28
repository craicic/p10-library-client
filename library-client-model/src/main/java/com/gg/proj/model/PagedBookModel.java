package com.gg.proj.model;

import java.util.List;

public class PagedBookModel {

    private List<BookModel> bookList;
    private Integer totalPages;

    public PagedBookModel() {
    }

    public PagedBookModel(List<BookModel> bookList, Integer totalPages) {
        this.bookList = bookList;
        this.totalPages = totalPages;
    }

    public List<BookModel> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookModel> bookList) {
        this.bookList = bookList;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public void put(List<BookModel> bookList, Integer totalPages){
        this.bookList = bookList;
        this.totalPages = totalPages;
    }
}
