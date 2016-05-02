package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 4/20/2016.
 */
public class pendingrequests extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener
{


    ListView listView;
    ArrayList<Item> items;
    String s;
    Button b;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pendingrequests);
        listView = (ListView)findViewById(R.id.listView);
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
        List<String> your_array_list = new ArrayList<String>();
        items = new ArrayList<>();


        //Kalli your stuff with database goes first into items arraylist and then i will sometimes send data for new
        //requests that i will add to the list and need to push to database as well
        try {
            items.add(new Item(1,getIntent().getStringExtra("Description"), null, getIntent().getStringExtra("Price")
                    ,getIntent().getStringExtra("Name"), getIntent().getStringExtra("Delivery"), getIntent().getStringExtra("Damage"),
                    getIntent().getStringExtra("Late"), "Pending"));
        }
        catch (Exception e)
        {
            //pass being lazy
        }
        itemm = new ArrayList<>();
        pending = new ArrayList<>();
        myItems = new ArrayList<>();
        where = 0;
        pending = getIntent().getStringArrayListExtra("pending");
        myItems = getIntent().getStringArrayListExtra("myItems");
        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
        itemm = dw.getParliaments();
        where = getIntent().getIntExtra("where", 0);
        try {
            if (where == 1) {
                pending.add(items.get(0).getName() + ":" + "Pending");
            } else {
                String s = pending.get(0);
                String[] x = s.split(":");
                pending.clear();
                pending.add(x[0] + ":Approved!");
            }
        }
        catch (Exception e)
        {
            //pass more lazy error handling
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                pending );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

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
    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l)
    {
        String s =(String) (listView.getItemAtPosition(i));
        String[] a = s.split(":");

        if (a[1].equals("Approved!")) {

            Intent j = new Intent(this, approvedrequest.class);
            j.putExtra("item", a[0]);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            j.putExtra("Name", itemm.get(itemm.size() - 1).getName());
            j.putExtra("Price",itemm.get(itemm.size() - 1).getPrice());
            j.putExtra("Description", itemm.get(itemm.size() - 1).getDescription());
            j.putExtra("Deliver", itemm.get(itemm.size() - 1).getDeilvery());
            j.putExtra("Damage", itemm.get(itemm.size() - 1).getDamage());
            j.putExtra("Late", itemm.get(itemm.size() - 1).getLate());
            startActivityForResult(j, 1);
        }

    }

}
