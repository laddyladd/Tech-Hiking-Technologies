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
    ArrayList<Item> original;
    ArrayList<String> oString;
    ArrayList<Item> temp;
    ArrayList<String> tString;
    Button b;
    Button s;
    EditText editText;
    ArrayAdapter<String> arrayAdapter;
    private CommHandler commHandler;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_availableitems);
        listView = (ListView) findViewById(R.id.listView);
        b = (Button) findViewById(R.id.buttonb);
        b.setOnClickListener(this);
        b.setTag(1);
        itemm = new ArrayList<>();
        pending = new ArrayList<>(getIntent().getStringArrayListExtra("pending"));
        myItems = new ArrayList<>(getIntent().getStringArrayListExtra("myItems"));
        where = 0;

        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
        itemm = dw.getParliaments();
        where = getIntent().getIntExtra("where", 0);
        original = new ArrayList<Item>(itemm);
        oString = new ArrayList<String>();
        tString = new ArrayList<String>();
        //1 is image ignore that null is location we need latitude/longitude and a location checker class for distance

        temp = new ArrayList<Item>(original);
        for (int i = 0; i < original.size(); i++)
        {
            oString.add(original.get(i).getName() + ": " + original.get(i).getPrice());
            tString.add(original.get(i).getName() + ": " + original.get(i).getPrice());
        }
         arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
        editText = (EditText)findViewById(R.id.search);
        s = (Button)findViewById(R.id.button);
        s.setOnClickListener(this);
        s.setTag(2);

        commHandler = new CommHandler(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getTag() == 1) {
            Intent j = new Intent(this, menu.class);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);

        }
        else
        {
            String check = editText.getText().toString().toLowerCase();
            original.clear();
            oString.clear();
            for (int i = 0; i < temp.size(); i++) {
                if (check.equals("")) {//if blank reset all data
                    original.add(temp.get(i));
                    oString.add(original.get(i).getName() + ": " + original.get(i).getPrice());
                } else if (check.equals(temp.get(i).getName().toLowerCase())) {
                    original.add(temp.get(i));
                    oString.add(temp.get(i).getName() + ": " + temp.get(i).getPrice());
                }
            }
            arrayAdapter.notifyDataSetChanged();

        }
    }

    @Override
    public void onItemClick(AdapterView<?> av, View v, int i, long l) {

        Intent j = new Intent(this, selecteditem.class);
        if (original.size() < temp.size())
        {
            j.putExtra("Name", original.get(i).getName());
            j.putExtra("Price", original.get(i).getPrice());
            j.putExtra("Description", original.get(i).getDescription());
            j.putExtra("Deliver", original.get(i).getDeilvery());
            j.putExtra("Damage", original.get(i).getDamage());
            j.putExtra("Late", original.get(i).getLate());
        }
        else{
        j.putExtra("Name", temp.get(i).getName());
        j.putExtra("Price", temp.get(i).getPrice());
        j.putExtra("Description", temp.get(i).getDescription());
        j.putExtra("Deliver", temp.get(i).getDeilvery());
        j.putExtra("Damage", temp.get(i).getDamage());
        j.putExtra("Late", temp.get(i).getLate());
        }
        j.putStringArrayListExtra("pending", pending);
        j.putStringArrayListExtra("myItems", myItems);
        j.putExtra("itemm", new DataWrapper(itemm));
        j.putExtra("where", where);
        startActivityForResult(j, 1);


    }

    public void moveToWatchClickedItem(int i){
        Intent j = new Intent(this, selecteditem.class);
        if (original.size() < temp.size())
        {
            j.putExtra("Name", original.get(i).getName());
            j.putExtra("Price", original.get(i).getPrice());
            j.putExtra("Description", original.get(i).getDescription());
            j.putExtra("Deliver", original.get(i).getDeilvery());
            j.putExtra("Damage", original.get(i).getDamage());
            j.putExtra("Late", original.get(i).getLate());
        }
        else{
            j.putExtra("Name", temp.get(i).getName());
            j.putExtra("Price", temp.get(i).getPrice());
            j.putExtra("Description", temp.get(i).getDescription());
            j.putExtra("Deliver", temp.get(i).getDeilvery());
            j.putExtra("Damage", temp.get(i).getDamage());
            j.putExtra("Late", temp.get(i).getLate());
        }
        j.putStringArrayListExtra("pending", pending);
        j.putStringArrayListExtra("myItems", myItems);
        j.putExtra("itemm", new DataWrapper(itemm));
        j.putExtra("where", where);
        startActivityForResult(j, 1);
    }
}
