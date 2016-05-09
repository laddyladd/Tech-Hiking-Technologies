package com.example.kalli.localshare;

import java.io.Serializable;

/**
 * Created by kalli on 5/8/16.
 */
public class Item implements Serializable {
    String name;
    String description;
    double pricePerDay;
    double lateFeePerDay;
    double damageFee;
    Address address;
    Status status;
    String rentalTerms;
    String phoneNumber;
    String email;

    public enum Status {
        AVAILABLE, RENTED, UNAVAILABLE
    }

    public Item(String name, String description, double pricePerDay, double lateFeePerDay, double damageFee, String street, String city, String state, String zip, Status status, String rentalTerms, String phoneNumber, String email) {
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.lateFeePerDay = lateFeePerDay;
        this.damageFee = damageFee;
        this.address = new Address(street, city, state, zip);
        this.status = status;
        this.rentalTerms = rentalTerms;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public double getLateFeePerDay() {
        return lateFeePerDay;
    }

    public void setLateFeePerDay(double lateFeePerDay) {
        this.lateFeePerDay = lateFeePerDay;
    }

    public double getDamageFee() {
        return damageFee;
    }

    public void setDamageFee(double damageFee) {
        this.damageFee = damageFee;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getRentalTerms() {
        return rentalTerms;
    }

    public void setRentalTerms(String rentalTerms) {
        this.rentalTerms = rentalTerms;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}