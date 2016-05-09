package com.example.kalli.localshare;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by kalli on 5/9/16.
 */
public class RentalTerms extends AppCompatActivity {



        final Firebase ref = new Firebase("https://localshare.firebaseio.com");

        TextView itemName;
        TextView itemPrice;
        TextView itemLateFee;
        TextView itemDamageFee;
        TextView itemRentalTerms;
        String itemUid;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_rental_terms);
            Firebase.setAndroidContext(this);

            itemName = (TextView) findViewById(R.id.itemName);
            itemPrice = (TextView) findViewById(R.id.itemPrice);
            itemLateFee = (TextView) findViewById(R.id.itemLateFee);
            itemDamageFee = (TextView) findViewById(R.id.itemDamageFee);
            itemRentalTerms = (TextView) findViewById(R.id.itemRentalTerms);

            itemUid = getIntent().getExtras().getString("itemUid");

            Firebase itemRef = new Firebase("https://localshare.firebaseio.com/items/" + itemUid);
// Attach an listener to read the data at our posts reference
            itemRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot snapshot) {
                    String name = (String) snapshot.child("name").getValue();
                    String price = (String) snapshot.child("pricePerDay").getValue();
                    String late = (String) snapshot.child("lateFeePerDay").getValue();
                    String damage = (String) snapshot.child("damageFee").getValue();
                    String terms = (String) snapshot.child("rentalTerms").getValue();

                    if(name != null)
                        itemName.setText(name);
                    else
                        itemName.setText("");
                    if(price != null)
                        itemPrice.setText("Price per day: " + price);
                    else
                        itemPrice.setText("Price per day: ");
                    if(late != null)
                        itemLateFee.setText("Late fee per day: " + late);
                    else
                        itemLateFee.setText("Late fee per day: ");
                    if(damage != null)
                        itemDamageFee.setText("Damage fee: " + damage);
                    else
                        itemDamageFee.setText("Damage fee: ");
                    if(terms != null)
                        itemRentalTerms.setText("Other rental terms: " + terms);
                    else
                        itemRentalTerms.setText("Other rental terms: ");


                }
                @Override
                public void onCancelled(FirebaseError firebaseError) {
                    System.out.println("The read failed: " + firebaseError.getMessage());
                }
            });

        }



}
