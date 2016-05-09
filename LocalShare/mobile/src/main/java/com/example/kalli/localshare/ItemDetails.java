package com.example.kalli.localshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by kalli on 5/9/16.
 */
public class ItemDetails extends AppCompatActivity {

    Button rentalTerms;
    Button viewAvailability;
    Button rent;
    TextView itemName;
    TextView postedBy;
    TextView itemDescription;
    TextView itemPrice;
    TextView itemStatus;
    TextView itemDelivery;

    final Firebase ref = new Firebase("https://localshare.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        Firebase.setAndroidContext(this);

        String itemUid = getIntent().getExtras().getString("itemUid");

        rentalTerms = (Button)findViewById(R.id.btn_rental_terms);
        viewAvailability = (Button)findViewById(R.id.btn_view_availability);
        rent = (Button)findViewById(R.id.btn_rent);

        itemName = (TextView)findViewById(R.id.itemName);

        //TODO convert this to poster's email
        postedBy = (TextView)findViewById(R.id.postedBy);

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
                String poster = (String) snapshot.child("postedByUser").getValue();
                String description = (String) snapshot.child("description").getValue();
                String price = (String) snapshot.child("pricePerDay").getValue();
                String status = (String) snapshot.child("status").getValue();
                String delivery = (String) snapshot.child("delivery").getValue();

                if(name != null)
                    itemName.setText(name);
                else
                    itemName.setText("");
                if(poster != null)
                    postedBy.setText(poster);
                else
                    postedBy.setText("");
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

//        rentalTerms.setOnClickListener(this);
//        viewAvailability.setOnClickListener(this);
//        rent.setOnClickListener(this);
    }


}