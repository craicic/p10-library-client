package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.users.Token;
import com.gg.proj.model.TokenModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    TokenModel tokenToTokenModel(Token token);
}
