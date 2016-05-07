package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Adam on 5/1/2016.
 */
public class newitem extends AppCompatActivity implements View.OnClickListener
{
    Button one;
    Button back;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    EditText name;
    EditText price;
    EditText description;
    EditText delivery;
    EditText damage;
    EditText late;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.example.adam.localshare1.R.layout.activity_newitem);
        one = (Button)findViewById(R.id.button2);
        back = (Button)findViewById(R.id.button3);
        one.setOnClickListener(this);
        back.setOnClickListener(this);
        one.setTag(1);
        //lots more needs to be done for final turn in
        name = (EditText)findViewById(R.id.editText4);
        price = (EditText)findViewById(R.id.editText5);
        description = (EditText)findViewById(R.id.editText6);
        delivery = (EditText)findViewById(R.id.editText9);
        damage = (EditText)findViewById(R.id.editText10);
        late = (EditText)findViewById(R.id.editText11);

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
        if ((int)view.getTag() == 1)
        {
            itemm.add(new Item(1, description.getText().toString(),"1237", price.getText().toString(),name.getText().toString(), delivery.getText().toString(), damage.getText().toString(), late.getText().toString(), ""));
            myItems.add(itemm.get(itemm.size() - 1).getName() + ":Available");
            System.out.println("OK CHECK SIZES::::");
        }
        Intent j = new Intent(this, menu.class);
        j.putStringArrayListExtra("pending", pending);
        j.putStringArrayListExtra("myItems", myItems);            System.out.println(itemm.size() + "::::" + myItems.size());

        j.putExtra("itemm", new DataWrapper(itemm));
        j.putExtra("where", where);
        startActivityForResult(j, 1);
    }
}
