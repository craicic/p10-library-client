package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.BookConnector;
import com.gg.proj.consumer.wsdl.books.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class BookConsumer extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(BookConsumer.class);


    private BookConnector bookConnector;

    @Autowired
    public BookConsumer(BookConnector bookConnector) {
        this.bookConnector = bookConnector;
    }

    public GetBookResponse getBook(Integer id) {
        return bookConnector.getBook(id);
    }

    public ListAllBooksResponse getAllBooks() {
        return bookConnector.getAllBooks();
    }

    public SearchBooksResponse searchBooks(int page, int size, String keyWord) {
        return bookConnector.searchBooks(page, size, keyWord);
    }

    public FilterBooksResponse filterBooks(int page, int size, String keyWord, Integer languageId, Integer libraryId, Integer topicId, boolean available) {
        return bookConnector.filterBooks(page,size, keyWord, languageId, libraryId, topicId, available);
    }
}