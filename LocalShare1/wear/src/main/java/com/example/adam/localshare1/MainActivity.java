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
import java.util.Date;
import java.util.Locale;

public class MainActivity extends WearableActivity implements ListView.OnItemClickListener {

    private static final SimpleDateFormat AMBIENT_DATE_FORMAT =
            new SimpleDateFormat("HH:mm", Locale.US);

    private CommHandler commHandler;

    private BoxInsetLayout mContainerView;
    private TextView mTextView;

    ListView listView;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setAmbientEnabled();

        mContainerView = (BoxInsetLayout) findViewById(R.id.container);
        mTextView = (TextView) findViewById(R.id.text);
        listView = (ListView) findViewById(R.id.listView);

        commHandler = new CommHandler(this);

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
