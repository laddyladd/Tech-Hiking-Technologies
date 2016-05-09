package com.example.kalli.localshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.firebase.client.Firebase;

/**
 * Created by kalli on 5/8/16.
 */
public class NewItem extends AppCompatActivity implements View.OnClickListener {

    final Firebase ref = new Firebase("https://localshare.firebaseio.com");

    FrameLayout r;
    Button save;
    EditText name;
    EditText description;
    EditText pricePerDay;
    EditText lateFee;
    EditText damageFee;
    EditText delivery;
    EditText rentalTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);
        setContentView(R.layout.activity_new_item);

        save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(this);

        name = (EditText) findViewById(R.id.name);
        description = (EditText) findViewById(R.id.description);
        pricePerDay = (EditText) findViewById(R.id.pricePerDay);
        lateFee = (EditText) findViewById(R.id.lateFee);
        damageFee = (EditText) findViewById(R.id.damageFee);
        delivery = (EditText) findViewById(R.id.delivery);
        rentalTerms = (EditText) findViewById(R.id.rentalTerms);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == save.getId())
        {
            String itemName = name.getText().toString();

            if(itemName == null || itemName.equals(""))
            {
                Context context = getApplicationContext();
                CharSequence text = "You must specify a name";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return;
            }

            String postedBy = ref.getAuth().getUid();
            String itemDescription = description.getText().toString();
            String itemPricePerDay = pricePerDay.getText().toString();
            String itemLateFee = lateFee.getText().toString();
            String itemDamageFee = damageFee.getText().toString();
            String itemDelivery = delivery.getText().toString();
            String itemRentalTerms = rentalTerms.getText().toString();

            //push and get the UID of item just pushed
            Firebase itemsRef = ref.child("items");
            Firebase newItemRef = itemsRef.push();
            String uid = newItemRef.getKey();
            System.out.print("new item ref get key: " + uid + " posted By: " + postedBy);
            Item item = new Item(uid, postedBy, itemName, itemDescription, itemPricePerDay, itemLateFee, itemDamageFee, null, itemDelivery, itemRentalTerms);

            newItemRef.setValue(item);

            Intent j = new Intent(this, MyItems.class);
            startActivity(j);
            finish();

        }
    }
}
