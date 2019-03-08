package com.gg.proj.authentication;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.UUID;

public class UserInfo implements Principal {

    private String pseudo;

    private UUID tokenUUID;

    private Integer id;

    public UserInfo(String pseudo, UUID tokenUUID, Integer id) {
        this.pseudo = pseudo;
        this.tokenUUID = tokenUUID;
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public UUID getTokenUUID() {
        return tokenUUID;
    }

    public void setTokenUUID(UUID tokenUUID) {
        this.tokenUUID = tokenUUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean implies(Subject subject) {
        return false;
    }

    @Override
    public String getName() {
        return null;
    }
}
