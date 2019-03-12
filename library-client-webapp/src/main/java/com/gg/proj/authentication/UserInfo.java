package com.gg.proj.authentication;

import javax.security.auth.Subject;
import java.security.Principal;
import java.util.Objects;
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
        if (subject == null)
            return false;
        return subject.getPrincipals().contains(this);
    }

    @Override
    public String getName() {
        return pseudo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfo userInfo = (UserInfo) o;
        return pseudo.equals(userInfo.pseudo) &&
                tokenUUID.equals(userInfo.tokenUUID) &&
                id.equals(userInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pseudo, tokenUUID, id);
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "pseudo='" + pseudo + '\'' +
                ", tokenUUID=" + tokenUUID +
                ", id=" + id +
                '}';
    }
}
