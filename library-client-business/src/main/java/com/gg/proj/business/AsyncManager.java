package com.gg.proj.business;

import com.gg.proj.business.mapper.LanguageMapper;
import com.gg.proj.business.mapper.LibraryMapper;
import com.gg.proj.consumer.BookConsumer;
import com.gg.proj.model.LanguageModel;
import com.gg.proj.model.LibraryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncManager {

    private static final Logger log = LoggerFactory.getLogger(AsyncManager.class);

    private LanguageMapper languageMapper;
    private LibraryMapper libraryMapper;
    private BookConsumer bookConsumer;

    public AsyncManager() {
    }

    @Autowired
    public AsyncManager(LanguageMapper languageMapper, LibraryMapper libraryMapper, BookConsumer bookConsumer) {
        this.languageMapper = languageMapper;
        this.libraryMapper = libraryMapper;
        this.bookConsumer = bookConsumer;
    }

    @Async
    public CompletableFuture<LibraryModel> getLibraryById(Integer libraryId) {
        log.debug("Asynchronous call to get library by id");
        LibraryModel libraryModel = libraryMapper.libraryToLibraryModel(bookConsumer.getLibrary(libraryId));
        return CompletableFuture.completedFuture(libraryModel);
    }

    @Async
    public CompletableFuture<LanguageModel> getLanguageById(Integer languageId) {
        log.debug("Asynchronous call to get language by id");
        LanguageModel languageModel = languageMapper.languageToLanguageModel(bookConsumer.getLanguage(languageId));
        return CompletableFuture.completedFuture(languageModel);
    }
}
