package com.example.kalli.localshare;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.ArrayAdapter;

import com.firebase.client.Firebase;

/**
 * Created by macbookair5 on 5/9/16.
 */


public class SetAvailability extends AppCompatActivity implements View.OnClickListener {

    Button reserve;

    Spinner startSpinnerMonth;
    Spinner startSpinnerDay;
    Spinner startSpinnerYear;
    Spinner endSpinnerMonth;
    Spinner endSpinnerDay;
    Spinner endSpinnerYear;

    private String[] months;
    private String[] days;
    private String[] years;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_availability);
        Firebase.setAndroidContext(this);

        startSpinnerMonth = (Spinner) findViewById(R.id.startSpinnerMonth);
        startSpinnerDay = (Spinner) findViewById(R.id.startSpinnerDay);
        startSpinnerYear = (Spinner) findViewById(R.id.startSpinnerYear);
        endSpinnerMonth = (Spinner) findViewById(R.id.endSpinnerMonth);
        endSpinnerDay = (Spinner) findViewById(R.id.endSpinnerDay);
        endSpinnerYear = (Spinner) findViewById(R.id.endSpinnerYear);

        reserve = (Button) findViewById(R.id.btn_reserve);
        reserve.setOnClickListener(this);

        months = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
        days = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12",
                "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
        years = new String[] { "2016", "2017", "2018"};
        ArrayAdapter<String> monthsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, months);
        ArrayAdapter<String> daysAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, days);
        ArrayAdapter<String> yearsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, years);

        startSpinnerMonth.setAdapter(monthsAdapter);
        endSpinnerMonth.setAdapter(monthsAdapter);

        startSpinnerDay.setAdapter(daysAdapter);
        endSpinnerDay.setAdapter(daysAdapter);

        startSpinnerYear.setAdapter(yearsAdapter);
        endSpinnerYear.setAdapter(yearsAdapter);

    }
    @Override
    public void onClick(View v) {

        if(v.getTag() == reserve.getTag())
        {
            int startMonth = Integer.parseInt(startSpinnerMonth.getSelectedItem().toString());
            int startDay = Integer.parseInt(startSpinnerDay.getSelectedItem().toString());
            int startYear = Integer.parseInt(startSpinnerYear.getSelectedItem().toString());
            int endMonth = Integer.parseInt(endSpinnerMonth.getSelectedItem().toString());
            int endDay = Integer.parseInt(endSpinnerDay.getSelectedItem().toString());
            int endYear = Integer.parseInt(endSpinnerYear.getSelectedItem().toString());

            Reservation res = new Reservation(Item.Status.UNAVAILABLE, startMonth, startDay, startYear, endMonth, endDay, endYear)
                    

        }

    }
}
