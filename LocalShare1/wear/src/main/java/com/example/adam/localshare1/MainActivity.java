package com.example.adam.localshare1;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.support.wearable.view.BoxInsetLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends WearableActivity implements ListView.OnItemClickListener {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private CommHandler commHandler;

    private BoxInsetLayout mContainerView;
    private TextView mTextView;

    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<Item> itemm;
    ArrayList<String> oString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        listView = (ListView) findViewById(R.id.listView);

        commHandler = new CommHandler(this);

        oString = new ArrayList<String>();
        itemm = new ArrayList<Item>();

        itemm.add(new Item(1, "A canoe for fishing.","1.3 Miles", "$25", "Canoe", "No", "None", "$30 per day", ""));
        // l = new Locations(-81.4094200, 38.2335930);

        itemm.add(new Item(1, "A bike for biking.",".7 Miles", "$15", "Bike", "Yes", "Max $50", "$10 per day", ""));
        // l = new Locations(-80.4094200, 36.2335930);

        itemm.add(new Item(1, "A gown for graduating.", "2.2 Miles", "$10", "Graduation Gown","Yes", "$30 if stained. $50 if ripped", "None",""));

        // l = new Locations(-80.4194200, 37.2355930);

        itemm.add(new Item(1, "A calculator for calculating.","3.4 Miles", "$5", "Ti-89 Calculator", "Yes", "$50", "$1 per day", ""));
        // l = new Locations(-80.4094200, 37.2235930);

        itemm.add(new Item(1, "A snowboard for shredding.","1.5 Miles", "$40", "Snowboard", "Yes", "Max $300", "$30 per day", ""));
        for (int i = 0; i < itemm.size(); i++) {
            oString.add(itemm.get(i).getName() + ": " + itemm.get(i).getPrice());
        }
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                oString);

        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onEnterAmbient(Bundle ambientDetails) {
        super.onEnterAmbient(ambientDetails);
        updateDisplay();
    }

    @Override
    public void onUpdateAmbient() {
        super.onUpdateAmbient();
        updateDisplay();
    }

    @Override
    public void onExitAmbient() {
        updateDisplay();
        super.onExitAmbient();
    }

    private void updateDisplay() {
        if (isAmbient()) {
            mContainerView.setBackgroundColor(getResources().getColor(android.R.color.black));
            mTextView.setTextColor(getResources().getColor(android.R.color.white));



        } else {
            mContainerView.setBackground(null);
            mTextView.setTextColor(getResources().getColor(android.R.color.black));

        }
    }

    public void updateListView(ArrayList<String> items){
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,
                items);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        commHandler.sendClickedItemID(position);
    }
}
