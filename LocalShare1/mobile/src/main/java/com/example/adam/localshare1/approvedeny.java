package com.example.adam.localshare1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Adam on 4/20/2016.
 */
public class approvedeny  extends AppCompatActivity implements View.OnClickListener
{
    Button bap;
    Button bd;
    Button bb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approvedeny);

        bap = (Button)findViewById(R.id.bap);
        bd = (Button)findViewById(R.id.bd);
        bb = (Button)findViewById(R.id.bb);
        bap.setOnClickListener(this);
        bd.setOnClickListener(this);
        bb.setOnClickListener(this);
        bap.setTag(1);
        bd.setTag(2);
        bb.setTag(3);
        String s = getIntent().getStringExtra("item");
        TextView d = (TextView)findViewById(R.id.textViewD);
        d.setText("Description: It is a " + s);

    }
    @Override
    public void onClick(View view)
    {
        int i = (int)view.getTag();
        if (i == 1)
        {
            //approve request
        }
        else if (i == 2)
        {
            //deny request
        }
        else if (i == 3)
        {
            finish();
        }
    }
}
