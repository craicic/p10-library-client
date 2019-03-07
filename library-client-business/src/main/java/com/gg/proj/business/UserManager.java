package com.gg.proj.business;

import com.gg.proj.business.mapper.UserMapper;
import com.gg.proj.consumer.UserConsumer;
import com.gg.proj.consumer.wsdl.users.Token;
import com.gg.proj.model.TokenModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserManager {

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
}
