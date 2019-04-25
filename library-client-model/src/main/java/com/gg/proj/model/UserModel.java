package com.gg.proj.model;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class UserModel {

    private Integer id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String mailAddress;

    private String phoneNumber;

    private Integer postalCode;

    private LocalDateTime lastConnection;

    private LocalDate registerDate;

    public UserModel() {
    }

    public UserModel(Integer id, String userName, String password, String firstName, String lastName,
                     String mailAddress, String phoneNumber, Integer postalCode, LocalDateTime lastConnection, LocalDate registerDate) {
        this.id = id;
        this.username = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
        this.postalCode = postalCode;
        this.lastConnection = lastConnection;
        this.registerDate = registerDate;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMailAddress() {
        return mailAddress;
    }

    public void setMailAddress(String mailAddress) {
        this.mailAddress = mailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public LocalDateTime getLastConnection() {
        return lastConnection;
    }

    public void setLastConnection(LocalDateTime lastConnection) {
        this.lastConnection = lastConnection;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mailAddress='" + mailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", postalCode=" + postalCode +
                ", lastConnection=" + lastConnection +
                ", registerDate=" + registerDate +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return username.equals(userModel.username) &&
                password.equals(userModel.password) &&
                firstName.equals(userModel.firstName) &&
                lastName.equals(userModel.lastName) &&
                mailAddress.equals(userModel.mailAddress) &&
                phoneNumber.equals(userModel.phoneNumber) &&
                postalCode.equals(userModel.postalCode) &&
                Objects.equals(lastConnection, userModel.lastConnection) &&
                Objects.equals(registerDate, userModel.registerDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, password, firstName, lastName, mailAddress, phoneNumber, postalCode, lastConnection, registerDate);
    }
}
