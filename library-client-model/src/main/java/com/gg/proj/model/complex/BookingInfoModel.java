package com.gg.proj.model.complex;

import com.gg.proj.model.BookMinModel;
import com.gg.proj.model.BookingModel;

import java.time.LocalDate;
import java.util.Objects;

public class BookingInfoModel {

    private BookingModel bookingModel;
    private BookMinModel bookMinModel;
    private int positionInQueue;
    private LocalDate nearestReturnDate;

    public BookingInfoModel() {
    }

    public BookingInfoModel(BookingModel bookingModel, BookMinModel bookMinModel, int positionInQueue, LocalDate nearestReturnDate) {
        this.bookingModel = bookingModel;
        this.bookMinModel = bookMinModel;
        this.positionInQueue = positionInQueue;
        this.nearestReturnDate = nearestReturnDate;
    }

    public BookingModel getBookingModel() {
        return bookingModel;
    }

    public void setBookingModel(BookingModel bookingModel) {
        this.bookingModel = bookingModel;
    }

    public BookMinModel getBookMinModel() {
        return bookMinModel;
    }

    public void setBookMinModel(BookMinModel bookMinModel) {
        this.bookMinModel = bookMinModel;
    }

    public int getPositionInQueue() {
        return positionInQueue;
    }

    public void setPositionInQueue(int positionInQueue) {
        this.positionInQueue = positionInQueue;
    }

    public LocalDate getNearestReturnDate() {
        return nearestReturnDate;
    }

    public void setNearestReturnDate(LocalDate nearestReturnDate) {
        this.nearestReturnDate = nearestReturnDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingInfoModel that = (BookingInfoModel) o;
        return positionInQueue == that.positionInQueue &&
                bookingModel.equals(that.bookingModel) &&
                bookMinModel.equals(that.bookMinModel) &&
                Objects.equals(nearestReturnDate, that.nearestReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingModel, bookMinModel, positionInQueue, nearestReturnDate);
    }

    @Override
    public String toString() {
        return "BookingInfoModel{" +
                "bookingModel=" + bookingModel +
                ", bookMinModel=" + bookMinModel +
                ", positionInQueue=" + positionInQueue +
                ", nearestReturnDate=" + nearestReturnDate +
                '}';
    }
}
