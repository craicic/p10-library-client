package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.wsdl.profiles.GetProfileRequest;
import com.gg.proj.consumer.wsdl.profiles.GetProfileResponse;
import com.gg.proj.consumer.wsdl.profiles.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.UUID;

public class ProfileConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ProfileConnector.class);

    private static final String SERVICE_LOCATION = "http://localhost:8080/ws/profiles";

    public User getProfile(Integer userId, UUID tokenUUID) {
        GetProfileRequest request = new GetProfileRequest();
        log.info("Requesting profile for user : " + userId + " with token : " + tokenUUID.toString());
        request.setId(userId);
        request.setTokenUUID(tokenUUID.toString());

        GetProfileResponse response = (GetProfileResponse) getWebServiceTemplate().
                marshalSendAndReceive(SERVICE_LOCATION, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response.getUser();
    }

}
