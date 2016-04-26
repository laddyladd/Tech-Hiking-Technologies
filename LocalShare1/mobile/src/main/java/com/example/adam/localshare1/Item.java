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
    public Item(int image, String Description, Location l, String price)
    {
        i = image;
        d = Description;
        L = l;
        p = price;
    }
    public int getImage()
    {
        return i;
    }
    public String getDestination()
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

}
