package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Adam on 4/20/2016.
 */
public class calendar extends AppCompatActivity implements View.OnClickListener, Spinner.OnItemSelectedListener
{
    Button b;
    Spinner spinner;
    Spinner spinner2;
    Spinner spinner3;
    Spinner spinner4;
    Spinner spinner5;
    Spinner spinner6;
    int ms = 1;
    int mf = 1;
    int ds = 1;
    int df = 1;
    int ys = 2016;
    int yf = 2016;
    Button s;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        b = (Button)findViewById(R.id.b);
        b.setOnClickListener(this);
        b.setTag(1);
        s = (Button)findViewById(R.id.s);
        s.setOnClickListener(this);
        s.setTag(2);
        spinner = (Spinner)findViewById(R.id.spinner);
        spinner2 = (Spinner)findViewById(R.id.spinner2);
        spinner3 = (Spinner)findViewById(R.id.spinner3);
        spinner4 = (Spinner)findViewById(R.id.spinner4);
        spinner5 = (Spinner)findViewById(R.id.spinner5);
        spinner6 = (Spinner)findViewById(R.id.spinner6);
        spinner.setTag(1);
        spinner2.setTag(2);
        spinner3.setTag(3);
        spinner4.setTag(4);
        spinner5.setTag(5);
        spinner6.setTag(6);
        spinner.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
        spinner4.setOnItemSelectedListener(this);
        spinner5.setOnItemSelectedListener(this);
        spinner6.setOnItemSelectedListener(this);

        ArrayList<Integer> arrm = new ArrayList<>();
        for (int i =1; i < 13; i++)
        {
            arrm.add(i);
        }
        ArrayList<Integer> arrd = new ArrayList<>();
        for (int i =1; i < 32; i++)
        {
            arrd.add(i);
        }
        ArrayList<Integer> arry = new ArrayList<>();
        for (int i =2016; i < 2021; i++)
        {
            arry.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, arrm);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner4.setAdapter(adapter);

        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, arrd);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);
        spinner5.setAdapter(adapter2);

        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<Integer>(
                this, android.R.layout.simple_spinner_item, arry);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);
        spinner6.setAdapter(adapter3);
        itemm = new ArrayList<>();
        pending = new ArrayList<>();
        myItems = new ArrayList<>();
        where = 0;
        pending = getIntent().getStringArrayListExtra("pending");
        myItems = getIntent().getStringArrayListExtra("myItems");
        DataWrapper dw = (DataWrapper) getIntent().getSerializableExtra("itemm");
        itemm = dw.getParliaments();
        where = getIntent().getIntExtra("where", 0);
    }

    @Override
    public void onClick(View view)
    {
        if ((int)view.getTag() == 2)
        {

            DateFormat dff = new SimpleDateFormat("dd:MM:yyyy");
            Date dateobj = new Date();
            String[] x = dff.format(dateobj).split(":");
            Intent intent = new Intent();

            if (ds >= Integer.parseInt(x[0]) || (ms >= Integer.parseInt(x[1]) && ys >= Integer.parseInt(x[2])))
            {
                int yt = yf - ys;
                yt *= 365;
                int mt = mf - ms;
                mt *= 30;
                int dt = df - ds;
                int total = yt + mt + dt;
                if (total > 0)
                {
                    intent.putExtra("Formatted Dates", ms + "/" + ds + "/" + ys + "___" + mf + "/" + df +"/" + yf);
                    intent.putExtra("Number of Days", total + "");
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        }
        finish();
    }

    @Override
    public void onItemSelected(AdapterView<?> a, View v, int i, long l)
    {
        switch((int)a.getTag()) {
            case 1:
                ms = (Integer) a.getSelectedItem();
                break;
            case 2:
                ds = (Integer) a.getSelectedItem();
                break;
            case 3:
                ys = (Integer)a.getSelectedItem();
                break;
            case 4:
                mf = (Integer)a.getSelectedItem();
                break;
            case 5:
                df = (Integer)a.getSelectedItem();
                break;
            case 6:
                yf = (Integer)a.getSelectedItem();
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView parent) {
        // Do nothing.
    }
}
