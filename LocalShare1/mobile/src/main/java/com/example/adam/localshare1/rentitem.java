package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Adam on 4/20/2016.
 */
public class rentitem extends AppCompatActivity implements View.OnClickListener
{

    Button b;
    Button s;
    Button r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentitem);
        b = (Button)findViewById(R.id.b);
        s = (Button)findViewById(R.id.s);
        r = (Button)findViewById(R.id.r);
        b.setOnClickListener(this);
        s.setOnClickListener(this);
        r.setOnClickListener(this);
        b.setTag(1);
        s.setTag(2);
        r.setTag(3);

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
            Intent j = new Intent(this, calendar.class);
            startActivityForResult(j, 1);
            //view rental terms
        }
        else if (i == 3) {
            //make sure dates have been selected
            //toast that request has been made
            //finish()
            //view calendar
        }
    }

}
