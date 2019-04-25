package com.gg.proj.consumer.connectors;

import com.gg.proj.consumer.ConsumerProperties;
import com.gg.proj.consumer.wsdl.profiles.GetProfileRequest;
import com.gg.proj.consumer.wsdl.profiles.GetProfileResponse;
import com.gg.proj.consumer.wsdl.profiles.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.WebServiceMessageFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import java.util.UUID;

/**
 * This class performs the connection to the web service's profile endpoint
 */
public class ProfileConnector extends WebServiceGatewaySupport {

    private static final Logger log = LoggerFactory.getLogger(ProfileConnector.class);

    private String serviceLocation;

    private ConsumerProperties consumerProperties;

    public ProfileConnector(@Autowired ConsumerProperties consumerProperties) {
        this.consumerProperties = consumerProperties;
        this.serviceLocation = this.consumerProperties.getUri() + "/profiles";
    }

    public ProfileConnector(WebServiceMessageFactory messageFactory, @Autowired ConsumerProperties consumerProperties) {
        super(messageFactory);
        this.consumerProperties = consumerProperties;
        this.serviceLocation = this.consumerProperties.getUri() + "/profiles";
    }

    public User getProfile(Integer userId, UUID tokenUUID) {
        GetProfileRequest request = new GetProfileRequest();
        log.info("Requesting profile for user : " + userId + " with token : [" + tokenUUID.toString() + "]");
        request.setId(userId);
        request.setTokenUUID(tokenUUID.toString());

        GetProfileResponse response = (GetProfileResponse) getWebServiceTemplate().
                marshalSendAndReceive(serviceLocation, request,
                        new SoapActionCallback("http://proj.gg.com/service/library-client"));

        return response.getUser();
    }

}
