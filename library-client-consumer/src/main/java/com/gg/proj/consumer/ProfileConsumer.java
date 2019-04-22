package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.ProfileConnector;
import com.gg.proj.consumer.wsdl.profiles.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 *
 * Consumer class, it call the connector
 */
@Component
public class ProfileConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProfileConsumer.class);

    private ProfileConnector profileConnector;

    @Autowired
    public ProfileConsumer(ProfileConnector profileConnector) {
        this.profileConnector = profileConnector;
    }

    public User getUser(Integer userId, UUID tokenUUID) {
        return profileConnector.getProfile(userId, tokenUUID);
    }

}
