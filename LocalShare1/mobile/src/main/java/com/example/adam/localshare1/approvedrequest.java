package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Adam on 4/20/2016.
 */
public class approvedrequest extends AppCompatActivity implements View.OnClickListener{

    Button b;
    Button p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approvedrequest);
        b = (Button)findViewById(R.id.b);
        p = (Button)findViewById(R.id.p);
        b.setOnClickListener(this);
        p.setOnClickListener(this);
        b.setTag(1);
        p.setTag(2);

    }
    @Override
    public void onClick(View view)
    {
        int i = (int)view.getTag();
        if (i == 1)
        {
            finish();
        }
        else if (i == 2)
        {
            //toast that they paid
            Intent j = new Intent(this, rentercontact.class);
            startActivityForResult(j, 1);
        }
    }
}

