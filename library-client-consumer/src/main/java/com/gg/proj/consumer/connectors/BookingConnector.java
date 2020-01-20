package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.ConsumerProperties;
import com.gg.proj.consumer.wsdl.bookings.*;
import com.gg.proj.consumer.wsdl.books.GetBookAndBookingInfoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.xml.soap.SOAPException;

public class BookingConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(BookingConnector.class);
    private ConsumerProperties consumerProperties;
    private String serviceLocation;

    public BookingConnector(ConsumerProperties consumerProperties) {
        this.consumerProperties = consumerProperties;
        this.serviceLocation = this.consumerProperties.getUri() + "/bookings";
    }

    public BookingConnector(WebServiceMessageFactory messageFactory, ConsumerProperties consumerProperties) {
        super(messageFactory);
        this.consumerProperties = consumerProperties;
        this.serviceLocation = this.consumerProperties.getUri() + "/bookings";
    }

    public PerformBookingResponse performBooking(BookingMin bookingDto, String tokenUUID) throws SOAPException {
        PerformBookingRequest request = new PerformBookingRequest();
        log.debug("Service is located at : " + serviceLocation);

        request.setBookingMin(bookingDto);
        request.setTokenUUID(tokenUUID);

        PerformBookingResponse response = (PerformBookingResponse) getWebServiceTemplate()
                .marshalSendAndReceive(serviceLocation, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
        if (response.getBookingSummary() != null)
            return response;
        else {
            throw new SOAPException("Soap response was empty, seems you try to access invalid resources");
        }
    }

    public GetBookingListByUserIdResponse getMyBookings(Integer userId, String tokenUUID) throws SOAPException {
        GetBookingListByUserIdRequest request = new GetBookingListByUserIdRequest();

        request.setUserId(userId);
        request.setTokenUUID(tokenUUID);

        GetBookingListByUserIdResponse response = (GetBookingListByUserIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(serviceLocation, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
        if (response.getBookingsInfo() != null)
            return response;
        else {
            throw new SOAPException("Soap response was empty, seems you try to access invalid resources");
        }
    }

    public CancelBookingResponse cancelBooking(Booking booking, String tokenUUID) throws SOAPException {
        CancelBookingRequest request = new CancelBookingRequest();

        request.setBooking(booking);
        request.setTokenUUID(tokenUUID);

        CancelBookingResponse response = (CancelBookingResponse) getWebServiceTemplate()
                .marshalSendAndReceive(serviceLocation, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
        if (response != null)
            return response;
        else {
            throw new SOAPException("Soap response was empty, seems you try to access invalid resources");
        }
    }
}
