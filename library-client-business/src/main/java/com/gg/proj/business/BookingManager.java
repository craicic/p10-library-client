package com.gg.proj.business;

import com.gg.proj.business.mapper.BookingMapper;
import com.gg.proj.consumer.BookingConsumer;
import com.gg.proj.consumer.wsdl.bookings.BookingInfo;
import com.gg.proj.consumer.wsdl.bookings.BookingMin;
import com.gg.proj.consumer.wsdl.bookings.PerformBookingResponse;
import com.gg.proj.model.BookingModel;
import com.gg.proj.model.complex.BookingInfoModel;
import com.gg.proj.model.complex.BookingSummaryModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.security.auth.login.CredentialException;
import javax.xml.soap.SOAPException;
import java.util.List;
import java.util.UUID;

@Component
public class BookingManager {

    private static final Logger log = LoggerFactory.getLogger(BookingManager.class);


    BookingConsumer bookingConsumer;
    BookingMapper bookingMapper;

    @Autowired
    public BookingManager(BookingConsumer bookingConsumer, BookingMapper bookingMapper) {
        this.bookingConsumer = bookingConsumer;
        this.bookingMapper = bookingMapper;
    }

    public void performBooking(int bookId, Integer userId, UUID tokenUUID) throws CredentialException, SOAPException {
        log.info("Entering PerformBooking...  bookId=" + bookId + ", userId=" + userId);

        if (userId == null || tokenUUID == null)
            throw new CredentialException("User and tokenUUID can't be null");

        // Output dto mapping
        BookingModel model = new BookingModel();
        model.setBookId(bookId);
        model.setUserId(userId);

        BookingMin bookingMinDto = bookingMapper.bookingModelToBookingMinDto(model);

        PerformBookingResponse response = bookingConsumer.performBooking(bookingMinDto, tokenUUID.toString());

        // Input dto mapping
        BookingSummaryModel summaryModel;

        if (response != null) {
            summaryModel = bookingMapper.bookingSummaryDtoToModel(response.getBookingSummary());
            // Logging
            log.info("performBooking complete - summaryModel :" + summaryModel);
        } else {
            log.info("performBooking have failed");
        }
    }

    public List<BookingInfoModel> getMyBookings(Integer userId, UUID tokenUUID) throws SOAPException, CredentialException {
        log.info("Entering PerformBooking... userId=" + userId);

        if (userId == null || tokenUUID == null)
            throw new CredentialException("User and tokenUUID can't be null");

        List<BookingInfo> bookingInfoDtoList = bookingConsumer.getMyBookings(userId, tokenUUID.toString());

        // Mapping
        List<BookingInfoModel> bookingInfoModelList = bookingMapper.bookingInfoDtosToModels(bookingInfoDtoList);

        log.info("Fetched a list of " + bookingInfoModelList.size() + " element(s)");

        return bookingInfoModelList;
    }
}
