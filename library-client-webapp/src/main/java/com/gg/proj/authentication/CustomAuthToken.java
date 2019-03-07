package com.gg.proj.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.UUID;

public class CustomAuthToken extends UsernamePasswordAuthenticationToken {

    private UUID tokenUUID;

    public CustomAuthToken(String principal, String credentials, Collection<? extends GrantedAuthority> authorities, UUID tokenUUID) {
        super(principal, credentials, authorities);

        this.tokenUUID = tokenUUID;
    }

}