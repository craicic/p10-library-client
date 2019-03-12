package com.gg.proj.authentication;

import com.gg.proj.business.ProfileManager;
import com.gg.proj.business.UserManager;
import com.gg.proj.model.TokenModel;
import com.gg.proj.model.UserModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    private static final Logger log = LoggerFactory.getLogger(CustomAuthenticationProvider.class);


    private UserManager userManager;

    private HttpSession httpSession;

    private ProfileManager profileManager;

    @Autowired
    public CustomAuthenticationProvider(UserManager userManager, ProfileManager profileManager, HttpSession httpSession) {
        this.userManager = userManager;
        this.profileManager = profileManager;
        this.httpSession = httpSession;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String pseudo = authentication.getName();
        String password = authentication.getCredentials().toString();

        TokenModel token = userManager.loginUser(pseudo, password);

        if (token != null) {
            UserModel user = profileManager.getUser(token.getUserId(), token.getTokenUUID());
            UserInfo userInfo = new UserInfo(user.getUsername(), token.getTokenUUID(), user.getId());

            return new UsernamePasswordAuthenticationToken(userInfo, password, Collections.emptyList());
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
