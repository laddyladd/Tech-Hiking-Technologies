package com.example.adam.localshare1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adam on 4/20/2016.
 */
public class selecteditem  extends AppCompatActivity implements View.OnClickListener {
    Button bb;
    Button bv;
    Button br;
    TextView textView15;
    TextView textView16;
    String damage;
    String delivery;
    String late;
    String description;
    TextView textView19;
    ArrayList<Item> itemm;
    ArrayList<String> pending;
    ArrayList<String> myItems;
    Integer where;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecteditem);
        textView15 = (TextView)findViewById(R.id.textView15);
        textView16 = (TextView)findViewById(R.id.textView16);
        textView19 = (TextView)findViewById(R.id.textView19);
        textView15.setText(getIntent().getStringExtra("Name"));
        textView16.setText(getIntent().getStringExtra("Price"));
        damage = getIntent().getStringExtra("Damage");
        delivery = getIntent().getStringExtra("Deliver");
        description = getIntent().getStringExtra("Description");
        textView19.setText(description);
        late = getIntent().getStringExtra("Late");
        bb = (Button)findViewById(R.id.bb);
        bv = (Button)findViewById(R.id.bv);
        br = (Button)findViewById(R.id.br);
        bb.setOnClickListener(this);
        bv.setOnClickListener(this);
        br.setOnClickListener(this);
        bb.setTag(1);
        bv.setTag(2);
        br.setTag(4);
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
        int i = (int)view.getTag();
        if (i == 1)
        {
            finish();
        }
        else if (i == 2)
        {
            Intent j = new Intent(this, rentalterms.class);
            j.putExtra("Price", textView16.getText().toString());
            j.putExtra("Deliver", delivery);
            j.putExtra("Description", description);
            j.putExtra("Damage", damage);
            j.putExtra("Late", late);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
            //view rental terms
        }
        else if (i == 4)
        {
            Intent j = new Intent(this, rentitem.class);

            j.putExtra("Price", textView16.getText().toString());
            j.putExtra("Name", textView15.getText().toString());
            j.putExtra("Deliver", delivery);
            j.putExtra("Description", description);
            j.putExtra("Damage", damage);
            j.putExtra("Late", late);
            j.putStringArrayListExtra("pending", pending);
            j.putStringArrayListExtra("myItems", myItems);
            j.putExtra("itemm", new DataWrapper(itemm));
            j.putExtra("where", where);
            startActivityForResult(j, 1);
            //rent item
        }

    }
}