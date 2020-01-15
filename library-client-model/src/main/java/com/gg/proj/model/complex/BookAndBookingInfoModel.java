package com.gg.proj.model.complex;

import com.gg.proj.model.BookModel;
import com.gg.proj.model.LanguageModel;
import com.gg.proj.model.LibraryModel;
import com.gg.proj.model.TopicModel;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class BookAndBookingInfoModel {

    private BookModel bookModel;
    private LibraryModel libraryModel;
    private LanguageModel languageModel;
    private List<TopicModel> topicModelList;
    private LocalDate nextReturnDate;
    private Long bookingQueue;
    private boolean availableForBooking;
    private boolean queueTooLong;

    public BookAndBookingInfoModel() {
    }

    public BookAndBookingInfoModel(BookModel bookModel, LibraryModel libraryModel, LanguageModel languageModel, List<TopicModel> topicModelList, LocalDate nextReturnDate, Long bookingQueue, boolean availableForBooking, boolean queueTooLong) {
        this.bookModel = bookModel;
        this.libraryModel = libraryModel;
        this.languageModel = languageModel;
        this.topicModelList = topicModelList;
        this.nextReturnDate = nextReturnDate;
        this.bookingQueue = bookingQueue;
        this.availableForBooking = availableForBooking;
        this.queueTooLong = queueTooLong;
    }

    public BookModel getBookModel() {
        return bookModel;
    }

    public void setBookModel(BookModel bookModel) {
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

    public LocalDate getNextReturnDate() {
        return nextReturnDate;
    }

    public void setNextReturnDate(LocalDate nextReturnDate) {
        this.nextReturnDate = nextReturnDate;
    }

    public Long getBookingQueue() {
        return bookingQueue;
    }

    public void setBookingQueue(Long bookingQueue) {
        this.bookingQueue = bookingQueue;
    }

    public boolean isAvailableForBooking() {
        return availableForBooking;
    }

    public void setAvailableForBooking(boolean availableForBooking) {
        this.availableForBooking = availableForBooking;
    }

    public boolean isQueueTooLong() {
        return queueTooLong;
    }

    public void setQueueTooLong(boolean queueTooLong) {
        this.queueTooLong = queueTooLong;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookAndBookingInfoModel that = (BookAndBookingInfoModel) o;
        return availableForBooking == that.availableForBooking &&
                queueTooLong == that.queueTooLong &&
                bookModel.equals(that.bookModel) &&
                libraryModel.equals(that.libraryModel) &&
                languageModel.equals(that.languageModel) &&
                topicModelList.equals(that.topicModelList) &&
                Objects.equals(nextReturnDate, that.nextReturnDate) &&
                bookingQueue.equals(that.bookingQueue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookModel, libraryModel, languageModel, topicModelList, nextReturnDate, bookingQueue, availableForBooking, queueTooLong);
    }

    @Override
    public String toString() {
        return "BookAndBookingInfoModel{" +
                "bookModel=" + bookModel +
                ", libraryModel=" + libraryModel +
                ", languageModel=" + languageModel +
                ", topicModelList=" + topicModelList +
                ", nextReturnDate=" + nextReturnDate +
                ", bookingQueue=" + bookingQueue +
                ", availableForBooking=" + availableForBooking +
                ", queueTooLong=" + queueTooLong +
                '}';
    }
}
