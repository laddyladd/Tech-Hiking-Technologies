package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Adam on 4/20/2016.
 */
public class selecteditem  extends AppCompatActivity implements View.OnClickListener {
    Button bb;
    Button bv;
    Button bc;
    Button br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteditem);
        bb = (Button)findViewById(R.id.bb);
        bv = (Button)findViewById(R.id.bv);
        bc = (Button)findViewById(R.id.bc);
        br = (Button)findViewById(R.id.br);
        bb.setOnClickListener(this);
        bv.setOnClickListener(this);
        bc.setOnClickListener(this);
        br.setOnClickListener(this);
        bb.setTag(1);
        bv.setTag(2);
        bc.setTag(3);
        br.setTag(4);
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
            Intent j = new Intent(this, rentalterms.class);
            startActivityForResult(j, 1);
            //view rental terms
        }
        else if (i == 3) {
            Intent j = new Intent(this, calendar.class);
            startActivityForResult(j, 1);
            //view calendar
        }
        else if (i == 4)
        {
            Intent j = new Intent(this, rentitem.class);
            startActivityForResult(j, 1);
            //rent item
        }

    }
}