package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.BookingConnector;
import com.gg.proj.consumer.wsdl.bookings.Booking;
import com.gg.proj.consumer.wsdl.bookings.BookingInfo;
import com.gg.proj.consumer.wsdl.bookings.BookingMin;
import com.gg.proj.consumer.wsdl.bookings.PerformBookingResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.soap.SOAPException;
import java.util.List;

@Component
public class BookingConsumer {

    BookingConnector bookingConnector;

    @Autowired
    public BookingConsumer(BookingConnector bookingConnector) {
        this.bookingConnector = bookingConnector;
    }

    public PerformBookingResponse performBooking(BookingMin bookingMinDto, String tokenUUID) throws SOAPException {
        return bookingConnector.performBooking(bookingMinDto, tokenUUID);
    }

    public List<BookingInfo> getMyBookings(Integer userId, String tokenUUID) throws SOAPException {
        return bookingConnector.getMyBookings(userId, tokenUUID).getBookingsInfo();
    }

    public Integer cancelBooking(Booking booking, String tokenUUID) throws SOAPException {
        return bookingConnector.cancelBooking(booking, tokenUUID).getConfirmationCode();
    }
}
