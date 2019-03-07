package com.gg.proj.business.mapper;

import com.gg.proj.consumer.wsdl.profiles.User;
import com.gg.proj.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    UserModel userToUserModel(User user);
}
