package com.gg.proj.model.complex;

import com.gg.proj.model.BookModel;
import com.gg.proj.model.LanguageModel;
import com.gg.proj.model.LibraryModel;
import com.gg.proj.model.TopicModel;

import java.util.List;

public class SearchResultModel {

    private List<BookModel> books;

    private List<LanguageModel> languages;

    private List<LibraryModel> libraries;

    private List<TopicModel> topics;

    private Integer totalPages;

    private String keyWord;

    public SearchResultModel() {
    }

    public SearchResultModel(List<BookModel> books, List<LanguageModel> languages, List<LibraryModel> libraries, List<TopicModel> topics, Integer totalPages, String keyWord) {
        this.books = books;
        this.languages = languages;
        this.libraries = libraries;
        this.topics = topics;
        this.totalPages = totalPages;
        this.keyWord = keyWord;
    }

    public List<BookModel> getBooks() {
        return books;
    }

    public void setBooks(List<BookModel> books) {
        this.books = books;
    }

    public List<LanguageModel> getLanguages() {
        return languages;
    }

    public void setLanguages(List<LanguageModel> languages) {
        this.languages = languages;
    }

    public List<LibraryModel> getLibraries() {
        return libraries;
    }

    public void setLibraries(List<LibraryModel> libraries) {
        this.libraries = libraries;
    }

    public List<TopicModel> getTopics() {
        return topics;
    }

    public void setTopics(List<TopicModel> topics) {
        this.topics = topics;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }
}
