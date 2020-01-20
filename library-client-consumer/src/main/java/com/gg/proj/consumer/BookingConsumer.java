package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.BookingConnector;
import com.gg.proj.consumer.wsdl.bookings.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.soap.SOAPException;
import java.util.List;
import java.util.UUID;

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
}
