package com.example.kalli.localshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by kalli on 5/8/16.
 */
public class AvailableItems extends BaseActivity implements View.OnClickListener, ListView.OnItemClickListener {

    FrameLayout r;
    ListView itemListView;
    EditText search;

    ArrayList<Item> items;
    ArrayAdapter<String> arrayAdapter;
    CommHandler commHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // inflate the view
        r = (FrameLayout) findViewById(R.id.content_base);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_available_items, null);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content_base);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        //find elements
        itemListView = (ListView) findViewById(R.id.items_list);
        search = (EditText) findViewById(R.id.search);

        items = new ArrayList<Item>();

        //set up list of items
        ArrayList<String> itemsAsStrings = new ArrayList<String>();

        for (int i = 0; i < items.size(); i++)
        {
            itemsAsStrings.add(items.get(i).getName() + ": " + items.get(i).getPricePerDay());
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                itemsAsStrings);

        itemListView.setAdapter(arrayAdapter);
        itemListView.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View view) {


    }
    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l) {

//        Intent j = new Intent(this, selecteditem.class);
//        startActivityForResult(j, 1);


    }
    public void moveToWatchClickedItem(int i){

    }
}
