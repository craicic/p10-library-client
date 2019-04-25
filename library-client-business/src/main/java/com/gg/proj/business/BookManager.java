package com.gg.proj.business;

import com.gg.proj.business.mapper.BookMapper;
import com.gg.proj.consumer.BookConsumer;
import com.gg.proj.consumer.wsdl.books.FilterBooksResponse;
import com.gg.proj.consumer.wsdl.books.GetBookResponse;
import com.gg.proj.consumer.wsdl.books.ListAllBooksResponse;
import com.gg.proj.consumer.wsdl.books.SearchBooksResponse;
import com.gg.proj.model.BookModel;
import com.gg.proj.model.LanguageModel;
import com.gg.proj.model.LibraryModel;
import com.gg.proj.model.TopicModel;
import com.gg.proj.model.complex.PagedBookModel;
import com.gg.proj.model.complex.SearchResultModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Business class, its role is to call the mapper to map objects
 */
@Component
public class BookManager {
    private static final Logger log = LoggerFactory.getLogger(BookManager.class);

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
        return bookMapper.bookFullToBookModel(response.getBookFull());
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

        return new SearchResultModel(books, languages, libraries, topics, response.getTotalPages(), response.getKeyWord());

    }

    public PagedBookModel filterBooks(int page, int size, String keyWord, Integer languageId, Integer libraryId, Integer topicId, boolean available) {
        PagedBookModel pagedBookModel = new PagedBookModel();
        FilterBooksResponse response;
        response = bookConsumer.filterBooks(page, size, keyWord, languageId, libraryId, topicId, available);
        pagedBookModel.put(bookMapper.listXsdToListModel(response.getBooks()),
                response.getTotalPages());
        log.debug("Result found : " + pagedBookModel);
        return pagedBookModel;
    }
}
