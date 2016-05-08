package com.example.adam.localshare1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Adam on 4/20/2016.
 */
public class myaccountold extends AppCompatActivity implements View.OnClickListener
{
    Button s;
    Button b;
    EditText editText;
    EditText editText2;
    EditText editText3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myaccount);
        s = (Button)findViewById(R.id.bs);
        b = (Button)findViewById(R.id.bbk);
        s.setOnClickListener(this);
        b.setOnClickListener(this);
        s.setTag(1);
        b.setTag(2);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);

        editText.setText("Adam Ladd");
        editText2.setText("703-930-5252, adaml17@vt.edu");
        editText3.setText("502 Jackson St. Apt E");
    }
    @Override
    public void onClick(View view)
    {
        int i = (int)view.getTag();
        if (i == 1)
        {
            //save changes
            //we do this by sending an  intent back to the first activity instead of just finishing like below
            //hw2...
        }
        else if (i == 2)
        {
            finish();
        }
    }

}
