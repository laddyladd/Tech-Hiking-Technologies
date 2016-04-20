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
public class availableitems extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    ListView listView;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availableitems);
        listView = (ListView) findViewById(R.id.listView);
        b = (Button) findViewById(R.id.buttonb);
        b.setOnClickListener(this);
        List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("Canoe: Distance 10 miles");
        your_array_list.add("bike: Distance 1 mile");
        your_array_list.add("graduation gown: Distance 3 miles");


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                your_array_list);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l) {
        String s = (String) (listView.getItemAtPosition(i));
        String[] a = s.split(":");
        Intent j = new Intent(this, selecteditem.class);
        j.putExtra("item", a[0]);
        startActivityForResult(j, 1);


    }
}
