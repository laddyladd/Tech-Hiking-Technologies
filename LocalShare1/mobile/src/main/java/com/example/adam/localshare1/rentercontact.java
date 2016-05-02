package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adam on 4/20/2016.
 */
public class rentercontact extends AppCompatActivity implements View.OnClickListener{


    Button b;
    TextView phone;
    TextView email;
    TextView address;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentercontact);
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
        //populate text boxes with info
        phone = (TextView)findViewById(R.id.textView12);
        email = (TextView)findViewById(R.id.textView13);
        address = (TextView)findViewById(R.id.textView14);
        phone.setText(phone.getText() + "703-930-5252");
        email.setText(email.getText() + "adaml17@vt.edu");
        address.setText(address.getText() + "502 Jackson St. Apt E");
        itemm = new ArrayList<>();
        pending = new ArrayList<>();
        myItems = new ArrayList<>();
        where = 0;
        pending = getIntent().getStringArrayListExtra("pending");
        myItems = getIntent().getStringArrayListExtra("myItems");
        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
        itemm = dw.getParliaments();
        where = getIntent().getIntExtra("where", 0);

    }
    @Override
    public void onClick(View view)
    {
        Intent j = new Intent(this, menu.class);
        j.putStringArrayListExtra("pending", pending);
        j.putStringArrayListExtra("myItems", myItems);
        j.putExtra("itemm", new DataWrapper(itemm));
        j.putExtra("where", where);
        startActivityForResult(j, 1);
    }

}
