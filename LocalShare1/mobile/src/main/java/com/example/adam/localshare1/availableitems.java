package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 4/20/2016.
 */
public class availableitems extends AppCompatActivity implements View.OnClickListener, ListView.OnItemClickListener {

    ListView listView;
    ArrayList<String> original;
    ArrayList<String> temp;
    Button b;
    Button s;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availableitems);
        listView = (ListView) findViewById(R.id.listView);
        b = (Button) findViewById(R.id.buttonb);
        b.setOnClickListener(this);
        b.setTag(1);
        original = new ArrayList<String>();
        original.add("Canoe: Distance 10 miles");
        original.add("bike: Distance 1 mile");
        original.add("graduation gown: Distance 3 miles");
        temp = new ArrayList<String>(original);

         arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                original);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        editText = (EditText)findViewById(R.id.search);
        s = (Button)findViewById(R.id.button);
        s.setOnClickListener(this);
        s.setTag(2);

    }

    @Override
    public void onClick(View view) {
        if (view.getTag() == 1) {
            Intent j = new Intent(this, menu.class);
            startActivityForResult(j, 1);

        }
        else
        {
            String check = editText.getText().toString().toLowerCase();
            original.clear();
            for (int i = 0; i < temp.size(); i++)
            {
                if (check.equals("")) //if blank reset all data
                {
                    original.add(temp.get(i));

                }
                else
                {
                    String x[] = temp.get(i).split(":");
                    if (check.equals(x[0]))
                        original.add(temp.get(i));
                }
            }


            arrayAdapter.notifyDataSetChanged();

        }
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
