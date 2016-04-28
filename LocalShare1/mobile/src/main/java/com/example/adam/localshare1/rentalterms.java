package com.example.adam.localshare1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Adam on 4/20/2016.
 */
public class rentalterms extends AppCompatActivity implements View.OnClickListener
{
    Button b;
    TextView p;
    TextView des;
    TextView del;
    TextView dam;
    TextView l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentalterms);

        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);

        p = (TextView)findViewById(R.id.p);
        des = (TextView)findViewById(R.id.des);
        del = (TextView)findViewById(R.id.del);
        dam = (TextView)findViewById(R.id.dam);
        l = (TextView)findViewById(R.id.l);
        p.setText(p.getText() + getIntent().getStringExtra("Price"));
        des.setText(des.getText() + getIntent().getStringExtra("Description"));
        del.setText(del.getText() + getIntent().getStringExtra("Deliver"));
        dam.setText(dam.getText() + getIntent().getStringExtra("Damage"));
        l.setText(l.getText() + getIntent().getStringExtra("Late"));

    }

    @Override
    public void onClick(View view)
    {
        finish();
    }
}
