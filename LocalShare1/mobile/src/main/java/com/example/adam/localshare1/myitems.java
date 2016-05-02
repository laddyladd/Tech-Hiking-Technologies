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
public class myitems extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    ListView listView;
    String s;
    Button b;
    Button bb;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myitems);
        listView = (ListView) findViewById(R.id.listView);
        b = (Button) findViewById(R.id.buttonb);

        bb = (Button)findViewById(R.id.button4);

        b.setOnClickListener(this);

        bb.setOnClickListener(this);

        bb.setTag(1);






        itemm = new ArrayList<>();
        pending = new ArrayList<>(getIntent().getStringArrayListExtra("pending"));
        myItems = new ArrayList<>(getIntent().getStringArrayListExtra("myItems"));

        where = 0;

        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
        itemm = dw.getParliaments();
        where = getIntent().getIntExtra("where", 0);
        ArrayList<String> your_array_list;
        if (where > 1)
        {
            String x = myItems.get(0);
            String[] xx = x.split(":");
            your_array_list = new ArrayList<String>();
            your_array_list.add(xx[0] + ":Pending");
        }
        else
            your_array_list = new ArrayList<String>(myItems);



        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                your_array_list);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getTag() == 1)
        {
            Intent j = new Intent(this, newitem.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }
        else {
            finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l) {
        String s = (String) (listView.getItemAtPosition(i));
        String[] a = s.split(":");
        if (a[1].equals("Pending")) {
            Intent j = new Intent(this, approvedeny.class);
            j.putExtra("item", a[0]);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
        }

    }
}
