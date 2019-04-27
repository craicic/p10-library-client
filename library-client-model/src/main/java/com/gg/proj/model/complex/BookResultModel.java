package com.gg.proj.model.complex;

import com.gg.proj.model.BookModel;
import com.gg.proj.model.LanguageModel;
import com.gg.proj.model.LibraryModel;
import com.gg.proj.model.TopicModel;

import java.util.List;
import java.util.Objects;

public class BookResultModel {

    private LibraryModel libraryModel;

    private LanguageModel languageModel;

    private List<TopicModel> topicModelList;

    private BookModel bookModel;

    public BookResultModel() {
    }

    public BookResultModel(LibraryModel libraryModel, LanguageModel languageModel, List<TopicModel> topicModelList, BookModel bookModel) {
        this.libraryModel = libraryModel;
        this.languageModel = languageModel;
        this.topicModelList = topicModelList;
        this.bookModel = bookModel;
    }

    public LibraryModel getLibraryModel() {
        return libraryModel;
    }

    public void setLibraryModel(LibraryModel libraryModel) {
        this.libraryModel = libraryModel;
    }

    public LanguageModel getLanguageModel() {
        return languageModel;
    }

    public void setLanguageModel(LanguageModel languageModel) {
        this.languageModel = languageModel;
    }

    public List<TopicModel> getTopicModelList() {
        return topicModelList;
    }

    public void setTopicModelList(List<TopicModel> topicModelList) {
        this.topicModelList = topicModelList;
    }

    public BookModel getBookModel() {
        return bookModel;
    }

    public void setBookModel(BookModel bookModel) {
        this.bookModel = bookModel;
    }

    @Override
    public String toString() {
        return "BookResultModel{" +
                "libraryModel=" + libraryModel +
                ", languageModel=" + languageModel +
                ", topicModelList=" + topicModelList +
                ", bookModel=" + bookModel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookResultModel that = (BookResultModel) o;
        return libraryModel.equals(that.libraryModel) &&
                languageModel.equals(that.languageModel) &&
                bookModel.equals(that.bookModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(libraryModel, languageModel, bookModel);
    }
}
