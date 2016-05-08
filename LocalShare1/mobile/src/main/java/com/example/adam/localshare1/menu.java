package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by Adam on 4/28/2016.
 */
public class menu extends AppCompatActivity implements View.OnClickListener{

    Button buttoni;
    Button buttona;
    Button buttonai;
    Button buttonp;
    Button buttons;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttoni = (Button)findViewById(R.id.buttoni);
        buttona = (Button)findViewById(R.id.buttona);
        buttonai = (Button)findViewById(R.id.buttonai);
        buttonp = (Button)findViewById(R.id.buttonp);
        buttons = (Button)findViewById(R.id.buttonsss);

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

        itemm = new ArrayList<>();
        pending = new ArrayList<>(getIntent().getStringArrayListExtra("pending"));
        myItems = new ArrayList<>(getIntent().getStringArrayListExtra("myItems"));
        where = 0;


        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
        itemm = dw.getParliaments();
        where = getIntent().getIntExtra("where", 0);
    }

    @Override
    public void onClick(View view)
    {
        int i = (int)view.getTag();
        System.out.println(i );
        if (i ==1)
        {
            Intent j = new Intent(this, myitems.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }
        else if (i == 2)
        {
            Intent j = new Intent(this, myaccount.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }
        else if (i == 3)
        {
            Intent j = new Intent(this, availableitemsold.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }
        else if (i == 4)
        {
            Intent j = new Intent(this, pendingrequests.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }
        else if (i == 5)
        {
            Intent j = new Intent(this, MainActivity.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }

    }
}
