package com.example.adam.localshare1;

import android.location.Location;

/**
 * Created by Adam on 4/26/2016.
 */
public class Item
{
    int i;
    String d;
    Location L;
    String p;
    String n;
    String dd;
    String ddd;
    String ll;
    String s;
    public Item(int image, String Description, Location l, String price, String name, String delivery, String Damage, String latefee, String Status)
    {
        i = image;
        d = Description;
        L = l;
        p = price;
        n = name;
        dd = delivery;
        ddd = Damage;
        ll = latefee;
        s = Status; //status is for approved, denied, pending requests
    }
    public int getImage()
    {
        return i;
    }
    public String getDescription()
    {
        return d;
    }
    public Location getLocation()
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
