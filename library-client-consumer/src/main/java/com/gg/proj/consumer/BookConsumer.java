package com.gg.proj.consumer;

import com.gg.proj.consumer.wsdl.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class BookConsumer extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(BookConsumer.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/books";

    public GetBookResponse getBook(Integer id) {
        GetBookRequest request = new GetBookRequest();
        log.info("Requesting infos on book id : " + id);
        request.setId(id);

        GetBookResponse response = (GetBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response;
    }

    public ListAllBooksResponse getAllBooks() {
        ListAllBooksRequest request = new ListAllBooksRequest();
        log.info("Listing all books exposed by web service");

        ListAllBooksResponse response = (ListAllBooksResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_LOCATION, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response;
    }

    public SearchBooksResponse searchBooks(int page, int size, String keyWord) {
        SearchBooksRequest request = new SearchBooksRequest();
        log.info("Request a paged list of books containing the key work : " + keyWord + ", at page " + page + " with " + size + " books per page");
        request.setPage(page);
        request.setSize(size);
        request.setKeyWord(keyWord);

        return (SearchBooksResponse) getWebServiceTemplate().marshalSendAndReceive(SERVICE_LOCATION, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));
    }
}