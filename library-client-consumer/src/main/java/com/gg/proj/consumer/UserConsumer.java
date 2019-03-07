package com.gg.proj.consumer;

import com.gg.proj.consumer.wsdl.users.LoginUserRequest;
import com.gg.proj.consumer.wsdl.users.LoginUserResponse;
import com.gg.proj.consumer.wsdl.users.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

@Component
public class UserConsumer extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/users";

    public Token loginUser(String pseudo, String password) {
        LoginUserRequest request = new LoginUserRequest();
        log.info("Requesting login for user : " + pseudo);
        request.setPseudo(pseudo);
        request.setPassword(password);

        LoginUserResponse response = (LoginUserResponse) getWebServiceTemplate().
                marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response.getToken();
    }
}
