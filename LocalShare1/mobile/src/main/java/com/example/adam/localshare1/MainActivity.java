package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Locations l;
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
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        itemm = new ArrayList<>();


        where = 0;
        try
        {
            pending = new ArrayList<>(getIntent().getStringArrayListExtra("pending"));
            myItems = new ArrayList<>(getIntent().getStringArrayListExtra("myItems"));
            DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
            itemm = dw.getParliaments();
            where = getIntent().getIntExtra("where", 0);
            where += 1;
        }
        catch (Exception e)
        {
            System.out.println("WE ARE HERE");
            pending = new ArrayList<>();
            myItems = new ArrayList<>();
            //pending and myitems stay null
            //fill itemm with made up data
           // l = new Locations(-80.4094200, 37.2335930);

            itemm.add(new Item(1, "A canoe for fishing.","1.3 Miles", "$25", "Canoe", "No", "None", "$30 per day", ""));
           // l = new Locations(-81.4094200, 38.2335930);

            itemm.add(new Item(1, "A bike for biking.",".7 Miles", "$15", "Bike", "Yes", "Max $50", "$10 per day", ""));
           // l = new Locations(-80.4094200, 36.2335930);

            itemm.add(new Item(1, "A gown for graduating.", "2.2 Miles", "$10", "Graduation Gown","Yes", "$30 if stained. $50 if ripped", "None",""));

           // l = new Locations(-80.4194200, 37.2355930);

            itemm.add(new Item(1, "A calculator for calculating.","3.4 Miles", "$5", "Ti-89 Calculator", "Yes", "$50", "$1 per day", ""));
           // l = new Locations(-80.4094200, 37.2235930);

            itemm.add(new Item(1, "A snowboard for shredding.","1.5 Miles", "$40", "Snowboard", "Yes", "Max $300", "$30 per day", ""));

        }
        buttonai = (Button)findViewById(R.id.buttonl);

        buttonai.setOnClickListener(this);

    }

    @Override
    public void onClick(View view)
    {

            Intent j = new Intent(this, availableitems.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);

        startActivityForResult(j, 1);

    }
}
