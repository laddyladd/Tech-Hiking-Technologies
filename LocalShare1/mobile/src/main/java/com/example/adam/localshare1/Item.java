package com.example.adam.localshare1;

import java.io.Serializable;

/**
 * Created by Adam on 4/26/2016.
 */
public class Item implements Serializable
{

    String d;
    String L;
    String p;
    String n;
    String dd;
    String ddd;
    String ll;
    String s;
    public Item(int image, String Description, String l, String price, String name, String delivery, String Damage, String latefee, String Status)
    {
        d = Description;
        L = l;
        p = price;
        n = name;
        dd = delivery;
        ddd = Damage;
        ll = latefee;
        s = Status; //status is for approved, denied, pending requests
    }

    public String getDescription()
    {
        return d;
    }
    public String getDistance()
    {
        return L;
    }
    public String getPrice()
    {
        return p;
    }
    public String getName() {return n;}
    public String getDeilvery(){return dd;}
    public String getDamage(){return ddd;}
    public String getLate(){return ll;}
    public String getStatus(){return s;}
}
