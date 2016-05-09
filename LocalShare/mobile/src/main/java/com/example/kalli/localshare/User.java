package com.example.kalli.localshare;

import java.io.Serializable;

/**
 * Created by kalli on 5/8/16.
 */
public class User implements Serializable {


    private String name;
    private String phone;
    private Address address;

    public User(String uid, String name, String phone, Address address) {

        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public Address getAddress() {
        return address;
    }

}
