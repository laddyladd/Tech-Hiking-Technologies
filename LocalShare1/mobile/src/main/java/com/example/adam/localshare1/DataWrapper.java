package com.example.adam.localshare1;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Adam on 5/2/2016.
 */
public class DataWrapper implements Serializable {

    private ArrayList<Item> parliaments;

    public DataWrapper(ArrayList<Item> data) {
        this.parliaments = data;
        System.out.println(parliaments.size() + "=================================================================");
    }

    public ArrayList<Item> getParliaments() {
        return this.parliaments;
    }

}