package com.gg.proj.authentication;

import com.gg.proj.business.ProfileManager;
import com.gg.proj.business.UserManager;
import com.gg.proj.model.TokenModel;
import com.gg.proj.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

import java.util.Collections;

public class CustomAuthenticationProvider implements AuthenticationProvider {

    private UserManager userManager;

    private ProfileManager profileManager;

    @Autowired
    public CustomAuthenticationProvider(UserManager userManager, ProfileManager profileManager) {

        this.userManager = userManager;
        this.profileManager = profileManager;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        CustomAuthToken auth = (CustomAuthToken) authentication;

        String pseudo = auth.getName();
        String password = auth.getCredentials().toString();

        TokenModel token = userManager.loginUser(pseudo, password);
        UserModel user = profileManager.getUser(token.getUserId(), token.getTokenUUID());

        if (user.getUsername().equals(pseudo) && user.getPassword().equals(password)) {
            return new CustomAuthToken(pseudo, password, Collections.emptyList(), token.getTokenUUID());
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(CustomAuthToken.class);
    }
}
