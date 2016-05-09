package com.example.kalli.localshare;

import java.io.Serializable;

/**
 * Created by kalli on 5/8/16.
 */
public class Address implements Serializable {
    private String street;
    private String city;
    private String state;
    private String zip;

    public Address(String street, String city, String state, String zip)
    {
        this.street = street;
        this.city = city;
        this.state= state;
        this.zip = zip;
    }

    public String getStreet(){
        return street;
    }
    public String getCity(){
        return city;
    }
    public String getState(){
        return state;
    }
    public String getZip(){
        return zip;
    }
}
