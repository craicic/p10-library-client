package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.users.Token;
import com.gg.proj.model.TokenModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mappings({
            @Mapping(target = "tokenUUID", expression = "java(java.util.UUID.fromString(token.getTokenUUID()))")
            })
    TokenModel tokenToTokenModel(Token token);
}
