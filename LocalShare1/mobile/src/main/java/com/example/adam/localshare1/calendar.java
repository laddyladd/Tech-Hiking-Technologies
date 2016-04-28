package com.example.adam.localshare1;

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
public class calendar extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener
{
    ListView listView;
    String s;
    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        listView = (ListView)findViewById(R.id.listView);
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
       /** List<String> your_array_list = new ArrayList<String>();
        your_array_list.add("May 10, 2016");
        your_array_list.add("May 12, 2016");
        your_array_list.add("May 13, 2016");

        //We need an intent checker to tell if this came from rentItem activity.
        //if so set header to "Click dates for rental" or something

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                your_array_list );

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        */
    }

    @Override
    public void onClick(View view)
    {
        finish();
    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l)
    {
        String s =(String) (listView.getItemAtPosition(i));
        //add these strings to arraylist and return them to past activity onClick.
        //then update that textbox with those dates

    }


}
