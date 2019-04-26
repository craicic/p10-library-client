package com.gg.proj.model;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookModel {

    private Integer id;
    private String author;
    private String title;
    private String isbn;
    private Integer quantity;
    private String summary;
    private LocalDate publicationDate;
    private List<Integer> topicIds;
    private Integer libraryId;
    private Integer languageId;


    public BookModel() {
    }

    public BookModel(Integer id, String author, String title, String isbn, Integer quantity, String summary, LocalDate publicationDate,
                     List<Integer> topicIds, Integer libraryId, Integer languageId) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.summary = summary;
        this.publicationDate = publicationDate;
        this.topicIds = topicIds;
        this.libraryId = libraryId;
        this.languageId = languageId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDate publicationDate) {
        this.publicationDate = publicationDate;
    }

    public List<Integer> getTopicIds() {
        return topicIds;
    }

    public void setTopicIds(List<Integer> topicIds) {
        this.topicIds = topicIds;
    }

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }

    @Override
    public String toString() {
        return "BookModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                ", summary='" + summary + '\'' +
                ", publicationDate=" + publicationDate +
                ", topicIds=" + topicIds +
                ", libraryId=" + libraryId +
                ", languageId=" + languageId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookModel bookModel = (BookModel) o;
        return id.equals(bookModel.id) &&
                author.equals(bookModel.author) &&
                title.equals(bookModel.title) &&
                Objects.equals(isbn, bookModel.isbn) &&
                quantity.equals(bookModel.quantity) &&
                Objects.equals(summary, bookModel.summary) &&
                Objects.equals(topicIds, bookModel.topicIds) &&
                libraryId.equals(bookModel.libraryId) &&
                languageId.equals(bookModel.languageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, isbn, quantity, summary, topicIds, libraryId, languageId);
    }
}
