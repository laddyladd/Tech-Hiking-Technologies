package com.example.adam.localshare1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 4/20/2016.
 */
public class rentalterms extends AppCompatActivity implements View.OnClickListener
{
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentalterms);

        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
        //Populate text boxes with info from item. use myitems/approvedeny as example for how to send and receive data

    }

    @Override
    public void onClick(View view)
    {
        finish();
    }
}
