package com.gg.proj.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class TokenModel {

    private Integer id;
    private UUID tokenUUID;
    private LocalDate expirationDate;
    private Integer userId;

    public TokenModel() {
    }

    public TokenModel(UUID tokenUUID, LocalDate expirationDate, Integer userId) {
        this.tokenUUID = tokenUUID;
        this.expirationDate = expirationDate;
        this.userId = userId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getTokenUUID() {
        return tokenUUID;
    }

    public void setTokenUUID(UUID tokenUUID) {
        this.tokenUUID = tokenUUID;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "TokenModel{" +
                "id=" + id +
                ", tokenUUID=" + tokenUUID +
                ", expirationDate=" + expirationDate +
                ", userId=" + userId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TokenModel that = (TokenModel) o;
        return id.equals(that.id) &&
                tokenUUID.equals(that.tokenUUID) &&
                expirationDate.equals(that.expirationDate) &&
                userId.equals(that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, tokenUUID, expirationDate, userId);
    }
}