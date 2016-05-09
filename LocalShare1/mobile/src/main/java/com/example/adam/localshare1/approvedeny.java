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
public class approvedeny  extends AppCompatActivity implements View.OnClickListener
{
    Button bap;
    Button bd;
    Button bb;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    TextView textView9;
    TextView textView10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_approvedeny);

        bap = (Button)findViewById(R.id.bap);
        bd = (Button)findViewById(R.id.bd);
        bb = (Button)findViewById(R.id.bb);
        textView9 = (TextView)findViewById(R.id.textView9);
        textView10 = (TextView)findViewById(R.id.textView10);
        textView9.setText("Total Price: $25");
        textView10.setText("Days Requested: 6/5 - 6/10");
        bap.setOnClickListener(this);
        bd.setOnClickListener(this);
        bb.setOnClickListener(this);
        bap.setTag(1);
        bd.setTag(2);
        bb.setTag(3);
        String s = getIntent().getStringExtra("item");
        TextView d = (TextView)findViewById(R.id.textViewD);
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
        int i = (int)view.getTag();
        if (i == 1)
        {
            //approve request toastjnhhhhhhhhhhhhhhhhhhhhhhhhhy
        }
        else if (i == 2)
        {
            //deny request toast
        }
        Intent j = new Intent(this, menu.class);
        j.putStringArrayListExtra("pending", pending);
        j.putStringArrayListExtra("myItems", myItems);
        j.putExtra("itemm", new DataWrapper(itemm));
        j.putExtra("where", where);
        startActivityForResult(j, 1);
    }
}
