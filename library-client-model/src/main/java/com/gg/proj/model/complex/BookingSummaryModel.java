package com.gg.proj.model.complex;
import com.gg.proj.model.BookingModel;
import java.time.LocalDate;
import java.util.Objects;

public class BookingSummaryModel {

    protected BookingModel booking;
    protected int positionInQueue;
    protected LocalDate nearestReturnDate;

    public BookingSummaryModel() {
    }

    public BookingSummaryModel(BookingModel booking, int positionInQueue, LocalDate nearestReturnDate) {
        this.booking = booking;
        this.positionInQueue = positionInQueue;
        this.nearestReturnDate = nearestReturnDate;
    }

    public BookingModel getBooking() {
        return booking;
    }

    public void setBooking(BookingModel booking) {
        this.booking = booking;
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
        BookingSummaryModel that = (BookingSummaryModel) o;
        return positionInQueue == that.positionInQueue &&
                booking.equals(that.booking) &&
                nearestReturnDate.equals(that.nearestReturnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booking, positionInQueue, nearestReturnDate);
    }

    @Override
    public String toString() {
        return "BookingSummaryModel{" +
                "booking=" + booking +
                ", positionInQueue=" + positionInQueue +
                ", nearestReturnDate=" + nearestReturnDate +
                '}';
    }
}
