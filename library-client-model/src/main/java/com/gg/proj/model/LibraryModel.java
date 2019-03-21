package com.gg.proj.model;

import java.util.Objects;

public class LibraryModel {

    private Integer id;

    private String name;

    private String city;

    private Integer postalCode;

    private String address;

    private String phoneNumber;

    public LibraryModel() {
    }

    public LibraryModel(Integer id, String name, String city, Integer postalCode, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.postalCode = postalCode;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "LibraryModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", postalCode=" + postalCode +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LibraryModel that = (LibraryModel) o;
        return id.equals(that.id) &&
                name.equals(that.name) &&
                city.equals(that.city) &&
                postalCode.equals(that.postalCode) &&
                address.equals(that.address) &&
                phoneNumber.equals(that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, city, postalCode, address, phoneNumber);
    }
}
