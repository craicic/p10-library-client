package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.ConsumerProperties;
import com.gg.proj.consumer.wsdl.books.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.EmptyStackException;

/**
 * This class performs the connection to the web service's book endpoint
 */
public class BookConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(BookConnector.class);

    private ConsumerProperties consumerProperties;

    private String serviceLocation;

    public BookConnector(@Autowired ConsumerProperties consumerProperties) {
        this.consumerProperties = consumerProperties;
        this.serviceLocation = this.consumerProperties.getUri() + "/books";
    }

    public BookConnector(WebServiceMessageFactory messageFactory, @Autowired ConsumerProperties consumerProperties) {
        super(messageFactory);
        this.consumerProperties = consumerProperties;
        this.serviceLocation = this.consumerProperties.getUri() + "/books";
    }

    /**
     * <p>Directly calls the Web-service's method getBook() from the Book service. It pass the id of a book
     * and the WS provide the matching book.</p>
     *
     * @param id the id of the book
     * @return a GetBookResponse.
     */
    public GetBookResponse getBook(Integer id) throws Exception {
        GetBookRequest request = new GetBookRequest();
        log.info("Requesting infos on book id : " + id);
        log.debug("Service is located at : " + serviceLocation);

        request.setId(id);

        GetBookResponse response = (GetBookResponse) getWebServiceTemplate()
                .marshalSendAndReceive(serviceLocation, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
        if (response.getBookFull() != null)
            return response;
        else {
            throw new Exception("Soap response was empty, seems you try to access invalid resources");
        }
    }

    /**
     * <p>Directly calls the Web-service's method listAllBooks() from the Book service. It ask the WS to provide a list
     * of all books stored in DB</p>
     *
     * @return ListAllBooksResponse containing the list of all book
     */
    public ListAllBooksResponse getAllBooks() {
        ListAllBooksRequest request = new ListAllBooksRequest();
        log.info("Listing all books exposed by web service");
        log.debug("Service is located at : " + serviceLocation);

        ListAllBooksResponse response = (ListAllBooksResponse) getWebServiceTemplate().marshalSendAndReceive(serviceLocation, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response;
    }

    /**
     * <p>Directly calls the Book WS. It ask WS to perform a search with following parameters.</p>
     *
     * @param page    the current page
     * @param size    the size of a page
     * @param keyWord the search keyword
     * @return SearchBooksResponse containing several list and information.
     */
    public SearchBooksResponse searchBooks(int page, int size, String keyWord) {
        SearchBooksRequest request = new SearchBooksRequest();
        log.info("Request a paged list of books containing the keyword : " + keyWord + ", at page " + page + " with " + size + " books per page");
        log.debug("Service is located at : " + serviceLocation);
        request.setPage(page);
        request.setSize(size);
        request.setKeyWord(keyWord);

        return (SearchBooksResponse) getWebServiceTemplate().marshalSendAndReceive(serviceLocation, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));
    }

    /**
     * <p>Directly calls the Book WS. It ask WS to perform a search with following parameters.</p>
     *
     * @param page       the current page
     * @param size       the size of a page
     * @param keyWord    the search keyword
     * @param languageId the id of selected language
     * @param libraryId  the id of selected library
     * @param topicId    the id of selected topic
     * @param available  is the book in stock?
     * @return FilterBooksResponse containing several list and information.
     */
    public FilterBooksResponse filterBooks(int page, int size, String keyWord, Integer languageId, Integer libraryId, Integer topicId, boolean available) {
        FilterBooksRequest request = new FilterBooksRequest();
        log.info("Requesting Web service's method FilterBooks. This Search contains the keyword : " + keyWord + ", at page " + page + " with " + size +
                " books per page -- languageId : [" + languageId + "] -- libraryId : [" + libraryId + "] -- topicId : [" + topicId + "]  -- Available == " + available);
        log.debug("Service is located at : " + serviceLocation);

        request.setPage(page);
        request.setSize(size);
        request.setKeyWord(keyWord);
        request.setLanguageId(languageId);
        request.setLibraryId(libraryId);
        request.setTopicId(topicId);
        request.setAvailable(available);
        return (FilterBooksResponse) getWebServiceTemplate().marshalSendAndReceive(serviceLocation, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));
    }

    public Library getLibrary(Integer libraryId) {
        GetLibraryRequest request = new GetLibraryRequest();
        log.info("Requesting Web service's method GetLibrary with the libraryId = [" + libraryId + "]");
        log.debug("Service is located at : " + serviceLocation);

        request.setId(libraryId);
        GetLibraryResponse response = (GetLibraryResponse) getWebServiceTemplate().marshalSendAndReceive(serviceLocation, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));
        return response.getLibrary();
    }

    public Language getLanguage(Integer languageId) {
        GetLanguageRequest request = new GetLanguageRequest();
        log.info("Requesting Web service's method GetLanguage with the languageId = [" + languageId + "]");
        log.debug("Service is located at : " + serviceLocation);

        request.setId(languageId);
        GetLanguageResponse response = (GetLanguageResponse) getWebServiceTemplate().marshalSendAndReceive(serviceLocation, request,
                new SoapActionCallback("http://proj.gg.com/service/library-client"));
        return response.getLanguage();
    }

    /**
     * <p>Directly calls the Web-service's method getBook() from the Book service. It pass the id of a book
     * and the WS provide the matching book.</p>
     *
     * @param id the id of the book
     * @return a GetBookResponse.
     */
    public GetBookAndBookingInfoResponse getBookAndBookingInfoById(Integer id) throws Exception {
        GetBookAndBookingInfoRequest request = new GetBookAndBookingInfoRequest();
        log.info("Requesting infos on book id : " + id);
        log.debug("Service is located at : " + serviceLocation);

        request.setBookId(id);

        GetBookAndBookingInfoResponse response = (GetBookAndBookingInfoResponse) getWebServiceTemplate()
                .marshalSendAndReceive(serviceLocation, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
        if (response.getBookAndBookingInfo() != null)
            return response;
        else {
            throw new Exception("Soap response was empty, seems you try to access invalid resources");
        }
    }
}
