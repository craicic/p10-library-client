package com.gg.proj.business;

import com.gg.proj.business.mapper.ProfileMapper;
import com.gg.proj.consumer.ProfileConsumer;
import com.gg.proj.consumer.wsdl.profiles.User;
import com.gg.proj.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;


/**
 * Business class, its role is to call the mapper to map objects
 */
@Component
public class ProfileManager {

    private static final Logger log = LoggerFactory.getLogger(ProfileManager.class);

    private ProfileConsumer profileConsumer;

    private ProfileMapper profileMapper;

    @Autowired
    public ProfileManager(ProfileConsumer profileConsumer, ProfileMapper profileMapper) {
        this.profileConsumer = profileConsumer;
        this.profileMapper = profileMapper;
    }

    public UserModel getUser(Integer userId, UUID tokenUUID) {
        User user = profileConsumer.getUser(userId, tokenUUID);

        return profileMapper.userToUserModel(user);
    }
}
