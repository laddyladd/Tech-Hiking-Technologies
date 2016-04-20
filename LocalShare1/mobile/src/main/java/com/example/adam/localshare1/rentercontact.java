package com.example.adam.localshare1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Adam on 4/20/2016.
 */
public class rentercontact extends AppCompatActivity implements View.OnClickListener{


    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentercontact);
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
        //populate text boxes with info
    }
    @Override
    public void onClick(View view)
    {
        finish();
    }

}
