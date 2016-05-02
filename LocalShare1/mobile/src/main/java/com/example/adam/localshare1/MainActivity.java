package com.example.adam.localshare1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button buttoni;
    Button buttona;
    Button buttonai;
    Button buttonp;
    Button buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        buttonai = (Button)findViewById(R.id.buttonl);

        buttonai.setOnClickListener(this);


    }

    @Override
    public void onClick(View view)
    {

            Intent j = new Intent(this, availableitems.class);
            startActivityForResult(j, 1);

    }
}
