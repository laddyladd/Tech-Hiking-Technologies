package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Adam on 4/28/2016.
 */
public class menu extends AppCompatActivity implements View.OnClickListener{

    Button buttoni;
    Button buttona;
    Button buttonai;
    Button buttonp;
    Button buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttoni = (Button)findViewById(R.id.buttoni);
        buttona = (Button)findViewById(R.id.buttona);
        buttonai = (Button)findViewById(R.id.buttonai);
        buttonp = (Button)findViewById(R.id.buttonp);
        buttons = (Button)findViewById(R.id.buttons);

        buttoni.setTag(1);
        buttona.setTag(2);
        buttonai.setTag(3);
        buttonp.setTag(4);
        buttons.setTag(5);

        buttoni.setOnClickListener(this);
        buttona.setOnClickListener(this);
        buttonai.setOnClickListener(this);
        buttonp.setOnClickListener(this);
        buttons.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        int i = (int)view.getTag();

        if (i ==1)
        {
            Intent j = new Intent(this, myitems.class);
            startActivityForResult(j, 1);


        }
        else if (i == 2)
        {
            Intent j = new Intent(this, myaccount.class);
            startActivityForResult(j, 1);
        }
        else if (i == 3)
        {
            Intent j = new Intent(this, availableitems.class);
            startActivityForResult(j, 1);
        }
        else if (i == 4)
        {
            Intent j = new Intent(this, pendingrequests.class);
            startActivityForResult(j, 1);
        }

    }
}
