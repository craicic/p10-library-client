package com.gg.proj.consumer;

import com.gg.proj.consumer.connectors.UserConnector;
import com.gg.proj.consumer.wsdl.users.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * Consumer class, it call the connector
 */
@Component
public class UserConsumer {

    private static final Logger log = LoggerFactory.getLogger(UserConsumer.class);

    private UserConnector userConnector;

    @Autowired
    public UserConsumer(UserConnector userConnector) {
        this.userConnector = userConnector;
    }

    public Token loginUser(String pseudo, String password) {
        return userConnector.loginUser(pseudo, password);
    }

}
