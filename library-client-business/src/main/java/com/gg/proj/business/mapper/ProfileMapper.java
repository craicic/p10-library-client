package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.profiles.User;
import com.gg.proj.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    @Mapping(source = "pseudo", target = "username")
    UserModel userToUserModel(User user);
}
