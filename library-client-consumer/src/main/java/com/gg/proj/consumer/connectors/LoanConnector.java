package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.wsdl.loans.FindAllLoansByUserIdRequest;
import com.gg.proj.consumer.wsdl.loans.FindAllLoansByUserIdResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class LoanConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LoanConnector.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/loans";

    public FindAllLoansByUserIdResponse findAllLoansByUserId(Integer userId, String tokenUUID) {
        FindAllLoansByUserIdRequest request = new FindAllLoansByUserIdRequest();
        log.info("Requesting all current loans for user : " + userId);
        request.setUserId(userId);
        request.setTokenUUID(tokenUUID);

        return (FindAllLoansByUserIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
    }
}
