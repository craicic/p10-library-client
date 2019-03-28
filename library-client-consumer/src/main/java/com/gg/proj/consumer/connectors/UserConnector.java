package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.wsdl.users.LoginUserRequest;
import com.gg.proj.consumer.wsdl.users.LoginUserResponse;
import com.gg.proj.consumer.wsdl.users.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;


public class UserConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(UserConnector.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/users";

    public Token loginUser(String pseudo, String password) {
        LoginUserRequest request = new LoginUserRequest();
        log.info("Requesting login for user : " + pseudo + " and password : " + password);
        request.setPseudo(pseudo);
        request.setPassword(password);


        try {
            LoginUserResponse response = (LoginUserResponse) getWebServiceTemplate().
                    marshalSendAndReceive(SERVICE_LOCATION, request,
                            new SoapActionCallback("http://proj.gg.com/service/library-client"));

            return response.getToken();
        } catch (Exception e) {
            log.debug("An exception has been catch : " + e.getMessage());
            return null;
        }
    }

}