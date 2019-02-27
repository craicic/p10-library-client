package com.gg.proj.business;

import com.gg.proj.consumer.BookConsumer;
import com.gg.proj.consumer.wsdl.GetBookResponse;
import com.gg.proj.consumer.wsdl.ListAllBooksResponse;
import com.gg.proj.consumer.wsdl.SearchBooksResponse;
import com.gg.proj.model.BookModel;
import com.gg.proj.model.PagedBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookManager {

    private BookConsumer bookConsumer;

    private MapperWorker mapperWorker;

    @Autowired
    public BookManager(BookConsumer bookConsumer, MapperWorker mapperWorker) {
        this.bookConsumer = bookConsumer;
        this.mapperWorker = mapperWorker;
    }

    public BookModel getBookById(Integer id) {
        GetBookResponse response;
        response = bookConsumer.getBook(id);
        return mapperWorker.bookXsdToBookModel(response.getBook());
    }

    public List<BookModel> getAllBooks() {
        ListAllBooksResponse response;
        response = bookConsumer.getAllBooks();
        return mapperWorker.listXsdToListModel(response.getBooks());
    }

    public PagedBook searchBooks(int page, int size, String keyWord) {
        PagedBook pagedBook = new PagedBook();
        SearchBooksResponse response;
        response = bookConsumer.searchBooks(page, size, keyWord);
        pagedBook.put(mapperWorker.listXsdToListModel(response.getBooks()),
                response.getTotalPages());

        return pagedBook;
    }
}
