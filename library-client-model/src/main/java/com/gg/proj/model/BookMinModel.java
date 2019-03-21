package com.gg.proj.model;

import java.util.List;
import java.util.Objects;

public class BookMinModel {

    private Integer id;
    private String author;
    private String title;
    private String isbn;
    private Integer quantity;
    private String summary;
    private Integer libraryId;

    public BookMinModel() {
    }

    public BookMinModel(Integer id, String author, String title, String isbn, Integer quantity, String summary, Integer libraryId) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.isbn = isbn;
        this.quantity = quantity;
        this.summary = summary;
        this.libraryId = libraryId;
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

    public Integer getLibraryId() {
        return libraryId;
    }

    public void setLibraryId(Integer libraryId) {
        this.libraryId = libraryId;
    }

    @Override
    public String toString() {
        return "BookMinModel{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", quantity=" + quantity +
                ", summary='" + summary + '\'' +
                ", libraryId=" + libraryId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookMinModel that = (BookMinModel) o;
        return id.equals(that.id) &&
                author.equals(that.author) &&
                title.equals(that.title) &&
                Objects.equals(isbn, that.isbn) &&
                quantity.equals(that.quantity) &&
                Objects.equals(summary, that.summary) &&
                libraryId.equals(that.libraryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, author, title, isbn, quantity, summary, libraryId);
    }
}
