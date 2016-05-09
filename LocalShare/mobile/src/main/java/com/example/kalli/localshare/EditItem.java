package com.example.kalli.localshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by macbookair5 on 5/9/16.
 */
public class EditItem extends AppCompatActivity implements View.OnClickListener {

    EditText itemName;
    EditText itemDescription;
    EditText itemPricePerDay;
    EditText itemDelivery;
    Button save;
    String itemUid;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        Firebase.setAndroidContext(this);

        itemName = (EditText) findViewById(R.id.itemName);
        itemDescription = (EditText) findViewById(R.id.itemDescription);
        itemPricePerDay = (EditText) findViewById(R.id.itemPricePerDay);
        itemDelivery = (EditText) findViewById(R.id.itemDelivery);
        save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(this);

        itemUid = getIntent().getExtras().getString("itemUid");

        Firebase itemRef = new Firebase("https://localshare.firebaseio.com/items/" + itemUid);
        // Attach an listener to read the data at our posts reference
        itemRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String name = (String) snapshot.child("name").getValue();
                String description = (String) snapshot.child("description").getValue();
                String price = (String) snapshot.child("pricePerDay").getValue();
                String delivery = (String) snapshot.child("delivery").getValue();

                if (name != null)
                    itemName.setText(name);
                if (description != null)
                    itemDescription.setText(description);
                if (price != null)
                    itemPricePerDay.setText(price);
                if (delivery != null)
                    itemDelivery.setText(delivery);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

    }

    @Override
    public void onClick(View view) {
        Firebase itemRef = new Firebase("https://localshare.firebaseio.com/items/" + itemUid);

        itemRef.child("name").setValue(itemName.getText().toString());
        itemRef.child("description").setValue(itemDescription.getText().toString());
        itemRef.child("pricePerDay").setValue(itemPricePerDay.getText().toString());
        itemRef.child("delivery").setValue(itemDelivery.getText().toString());

        Intent i = new Intent(this, YourItemDetails.class);
        i.putExtra("itemUid", itemUid);
        startActivity(i);
        finish();

    }
}

