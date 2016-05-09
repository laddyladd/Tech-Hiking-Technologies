package com.example.kalli.localshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import com.firebase.client.Firebase;

/**
 * Created by kalli on 5/8/16.
 */
public class NewItem extends BaseActivity implements View.OnClickListener {

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




        // inflate the view
        r = (FrameLayout) findViewById(R.id.content_base);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_new_item, null);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content_base);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

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
            String uid = ref.getAuth().getUid();
            String itemName = name.getText().toString();
            String itemDescription = description.getText().toString();
            String itemPricePerDay = pricePerDay.getText().toString();
            String itemLateFee = lateFee.getText().toString();
            String itemDamageFee = damageFee.getText().toString();
            String itemDelivery = delivery.getText().toString();
            String itemRentalTerms = rentalTerms.getText().toString();

            Item item = new Item(uid, itemName, itemDescription, itemPricePerDay, itemLateFee, itemDamageFee, null, itemDelivery, itemRentalTerms);

            //push and get the UID of item just pushed
            Firebase itemsRef = ref.child("items");
            Firebase newItemRef = itemsRef.push();
            newItemRef.setValue(item);
            String itemId = newItemRef.getKey();

            // save that reference on the user object
            Firebase userItemRef = ref.child("users/" + uid + "/items/" + itemId);
            userItemRef.setValue(itemId);

            Intent j = new Intent(this, MyItems.class);
            startActivity(j);
            finish();

        }
    }
}
