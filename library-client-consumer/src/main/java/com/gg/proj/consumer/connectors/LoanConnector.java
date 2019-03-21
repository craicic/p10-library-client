package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.wsdl.loans.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import javax.naming.ldap.ExtendedRequest;

public class LoanConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(LoanConnector.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/loans";

    public FindAllLoansByUserIdResponse findAllLoansByUserId(Integer userId, String tokenUUID) {
        FindAllLoansByUserIdRequest request = new FindAllLoansByUserIdRequest();
        log.debug("Requesting all current loans for user : " + userId);
        request.setUserId(userId);
        request.setTokenUUID(tokenUUID);

        return (FindAllLoansByUserIdResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
    }


    public GetLoanResponse findById(int loanId, String tokenUUID) {
        GetLoanRequest request = new GetLoanRequest();
        request.setId(loanId);
        request.setTokenUUID(tokenUUID);

        GetLoanResponse response = (GetLoanResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));
        return response;
    }

    public void extend(Loan loan, String tokenUUID) {
        ExtendLoanRequest request = new ExtendLoanRequest();
        request.setLoan(loan);
        request.setTokenUUID(tokenUUID);

        ExtendLoanResponse response = (ExtendLoanResponse) getWebServiceTemplate()
                .marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

    }
}
