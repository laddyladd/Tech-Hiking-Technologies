package com.example.kalli.localshare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by kalli on 5/9/16.
 */
public class YourItemDetails extends AppCompatActivity implements View.OnClickListener {

    Button rentalTerms;
    Button setAvailability;
    Button edit;
    TextView itemName;

    TextView itemDescription;
    TextView itemPrice;
    TextView itemStatus;
    TextView itemDelivery;
    String itemUid;

    final Firebase ref = new Firebase("https://localshare.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_item_details);
        Firebase.setAndroidContext(this);

        itemUid = getIntent().getExtras().getString("itemUid");

        rentalTerms = (Button)findViewById(R.id.btn_rental_terms);
        setAvailability = (Button)findViewById(R.id.btn_availability);
        edit = (Button)findViewById(R.id.btn_edit);

        itemName = (TextView)findViewById(R.id.itemName);
        itemDescription = (TextView)findViewById(R.id.itemDescription);
        itemPrice = (TextView)findViewById(R.id.itemPrice);
        itemStatus = (TextView)findViewById(R.id.itemStatus);
        itemDelivery = (TextView)findViewById(R.id.itemDelivery);

        Firebase itemRef = new Firebase("https://localshare.firebaseio.com/items/" + itemUid);
        // Attach an listener to read the data at our posts reference
        itemRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                String name = (String) snapshot.child("name").getValue();
                String description = (String) snapshot.child("description").getValue();
                String price = (String) snapshot.child("pricePerDay").getValue();
                String status = (String) snapshot.child("status").getValue();
                String delivery = (String) snapshot.child("delivery").getValue();

                if(name != null)
                    itemName.setText(name);
                else
                    itemName.setText("");
                if(description != null)
                    itemDescription.setText("Description: " + description);
                else
                    itemDescription.setText("Description: ");
                if(price != null)
                    itemPrice.setText("Price per day: " + price);
                else
                    itemPrice.setText("Price per day: ");
                if(delivery != null)
                    itemDelivery.setText("Delivery: " + delivery);
                else
                    itemDelivery.setText("Delivery: ");
                if(status != null)
                    itemStatus.setText("Status: " + status);
                else
                    itemStatus.setText("Status: ");

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
            }
        });

        rentalTerms.setOnClickListener(this);
        setAvailability.setOnClickListener(this);
        edit.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        if(view.getId() == rentalTerms.getId())
        {
            Intent i = new Intent(this, EditRentalTerms.class);
            i.putExtra("itemUid", itemUid);
            startActivity(i);
        }
        else if (view.getId() == setAvailability.getId())
        {

        }
        else if (view.getId() == edit.getId())
        {

        }

    }
}
