package com.gg.proj.business;

import com.gg.proj.business.mapper.UserMapper;
import com.gg.proj.consumer.UserConsumer;
import com.gg.proj.consumer.wsdl.users.Token;
import com.gg.proj.model.TokenModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * Business class, its role is to call the mapper to map objects
 */
@Component
public class UserManager {

    private static final Logger log = LoggerFactory.getLogger(UserManager.class);

    private UserConsumer userConsumer;

    private UserMapper userMapper;

    @Autowired
    public UserManager(UserConsumer userConsumer, UserMapper userMapper) {
        this.userConsumer = userConsumer;
        this.userMapper = userMapper;
    }

    public TokenModel loginUser(String pseudo, String password) {
        Token token = userConsumer.loginUser(pseudo, password);

        return userMapper.tokenToTokenModel(token);
    }

    public String logoutUser(UUID tokenUUID) {
        String tokenUUIDStr = tokenUUID.toString();

        return userConsumer.logoutUser(tokenUUIDStr);
    }
}
