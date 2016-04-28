package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Adam on 4/20/2016.
 */
public class rentitem extends AppCompatActivity implements View.OnClickListener
{

    Button b;
    Button s;
    Button r;
    TextView textView15;
    TextView textView16;
    TextView textView19;

    String Dates;
    Integer Days;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rentitem);
        Dates = "";
        b = (Button)findViewById(R.id.b);
        s = (Button)findViewById(R.id.s);
        r = (Button)findViewById(R.id.r);
        textView15 = (TextView)findViewById(R.id.textView15);
        textView16 = (TextView)findViewById(R.id.textView16);
        textView19 = (TextView)findViewById(R.id.textView19);
        b.setOnClickListener(this);
        s.setOnClickListener(this);
        r.setOnClickListener(this);
        b.setTag(1);
        s.setTag(2);
        r.setTag(3);
        textView15.setText(getIntent().getStringExtra("Name"));
        textView16.setText(getIntent().getStringExtra("Price"));
        String description = getIntent().getStringExtra("Description");
        textView19.setText(description);
    }
    @Override
    public void onClick(View view)
    {
        int i = (int)view.getTag();
        if (i == 1)
        {
            finish();
        }
        else if (i == 2)
        {
            Intent j = new Intent(this, calendar.class);
            startActivityForResult(j, 1);
            //view rental terms
        }
        else if (i == 3) {
            if (!(Dates.equals("")) && !(Days.equals("")))
            {
                Intent j = new Intent(this, pendingrequests.class);
                //j.putExtra() I think i literally need to put all the data that goes with item yuck...
                j.putExtra("Name", getIntent().getStringExtra("Name"));
                j.putExtra("Price", getIntent().getStringExtra("Price"));
                j.putExtra("Description", getIntent().getStringExtra("Description"));
                j.putExtra("Deliver", getIntent().getStringExtra("Deliver"));
                j.putExtra("Damage", getIntent().getStringExtra("Damage"));
                j.putExtra("Late", getIntent().getStringExtra("Late"));

                startActivityForResult(j, 1);

            }
        }
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                Dates = data.getStringExtra("Formatted Dates");
                Days = Integer.parseInt(data.getStringExtra("Number of Days"));
                System.out.println(Dates + "                  " + Days);

            }
        }
    }
}
