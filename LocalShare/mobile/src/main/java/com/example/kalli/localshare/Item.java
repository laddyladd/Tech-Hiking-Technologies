package com.example.kalli.localshare;

import java.io.Serializable;

/**
 * Created by kalli on 5/8/16.
 */
public class Item implements Serializable {
    String uid;
    String postedByUser;
    String name;
    String description;
    String pricePerDay;
    String lateFeePerDay;
    String damageFee;
    Status status;
    String delivery;
    String rentalTerms;


    public enum Status {
        AVAILABLE, RENTED, UNAVAILABLE
    }

    public Item(String uid, String postedByUser, String name, String description, String pricePerDay, String lateFeePerDay, String damageFee, Status status, String delivery, String rentalTerms) {
        this.uid = uid;
        this.postedByUser = postedByUser;
        this.name = name;
        this.description = description;
        this.pricePerDay = pricePerDay;
        this.lateFeePerDay = lateFeePerDay;
        this.damageFee = damageFee;
        if(status == null)
            this.status = Status.AVAILABLE;
        else
            this.status = status;
        this.delivery = delivery;
        this.rentalTerms = rentalTerms;
    }

    public String getUid() { return uid; }

    public void setUid(String uid) { this.uid=uid; }

    public String getPostedByUser() { return postedByUser; }

    public void setPostedByUser(String postedByUser) { this.postedByUser=postedByUser; }

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

    public String getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(String pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getLateFeePerDay() {
        return lateFeePerDay;
    }

    public void setLateFeePerDay(String lateFeePerDay) {
        this.lateFeePerDay = lateFeePerDay;
    }

    public String getDamageFee() {
        return damageFee;
    }

    public void setDamageFee(String damageFee) {
        this.damageFee = damageFee;
    }

    public String getDelivery() {
        return delivery;
    }

    public void setDelivery(String delivery) {
        this.delivery = delivery;
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

}