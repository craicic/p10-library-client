package com.gg.proj.business;

import com.gg.proj.business.mapper.BookMapper;
import com.gg.proj.consumer.BookConsumer;
import com.gg.proj.consumer.wsdl.GetBookResponse;
import com.gg.proj.consumer.wsdl.ListAllBooksResponse;
import com.gg.proj.consumer.wsdl.SearchBooksResponse;
import com.gg.proj.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookManager {

    private BookConsumer bookConsumer;

    private BookMapper bookMapper;

    @Autowired
    public BookManager(BookConsumer bookConsumer, BookMapper bookMapper) {
        this.bookConsumer = bookConsumer;
        this.bookMapper = bookMapper;
    }

    public BookModel getBookById(Integer id) {
        GetBookResponse response;
        response = bookConsumer.getBook(id);
        return bookMapper.bookXsdToBookModel(response.getBook());
    }

    public List<BookModel> getAllBooks() {
        ListAllBooksResponse response;
        response = bookConsumer.getAllBooks();
        return bookMapper.listXsdToListModel(response.getBooks());
    }

    public PagedBookModel getPagedBooks(int page, int size, String keyWord) {
        PagedBookModel pagedBookModel = new PagedBookModel();
        SearchBooksResponse response;
        response = bookConsumer.searchBooks(page, size, keyWord);
        pagedBookModel.put(bookMapper.listXsdToListModel(response.getBooks()),
                response.getTotalPages());

        return pagedBookModel;
    }

    public SearchResultModel searchBooks(int page, int size, String keyWord) {
        SearchBooksResponse response;
        response = bookConsumer.searchBooks(page, size, keyWord);

        List<BookModel> books = bookMapper.bookListToBookModelList(response.getBooks());
        List<LanguageModel> languages = bookMapper.languageListToLanguageModelList(response.getLanguages());
        List<LibraryModel> libraries = bookMapper.libraryListToLibraryModelList(response.getLibraries());
        List<TopicModel> topics = bookMapper.topicListToTopicModelList(response.getTopics());

        return new SearchResultModel(books,languages,libraries,topics,response.getTotalPages(),response.getKeyWord());

    }
}
