package com.example.kalli.localshare;

import android.content.Intent;
import android.os.Bundle;
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
 * Created by kalli on 5/9/16.
 */
public class EditRentalTerms extends AppCompatActivity implements View.OnClickListener {


    final Firebase ref = new Firebase("https://localshare.firebaseio.com");

    TextView itemName;
    EditText itemPrice;
    EditText itemLateFee;
    EditText itemDamageFee;
    EditText itemRentalTerms;
    Button save;
    String itemUid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_rental_terms);
        Firebase.setAndroidContext(this);

        itemName = (TextView) findViewById(R.id.itemName);
        itemPrice = (EditText) findViewById(R.id.itemPrice);
        itemLateFee = (EditText) findViewById(R.id.itemLateFee);
        itemDamageFee = (EditText) findViewById(R.id.itemDamageFee);
        itemRentalTerms = (EditText) findViewById(R.id.itemRentalTerms);
        save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(this);

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

                if (name != null)
                    itemName.setText(name);
                else
                    itemName.setText("");
                if (price != null)
                    itemPrice.setText(price);
                if (late != null)
                    itemLateFee.setText(late);
                if (damage != null)
                    itemDamageFee.setText(damage);
                if (terms != null)
                    itemRentalTerms.setText(terms);


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

        itemRef.child("pricePerDay").setValue(itemPrice.getText().toString());
        itemRef.child("lateFeePerDay").setValue(itemLateFee.getText().toString());
        itemRef.child("damageFee").setValue(itemDamageFee.getText().toString());
        itemRef.child("rentalTerms").setValue(itemRentalTerms.getText().toString());

        Intent i = new Intent(this, YourItemDetails.class);
        i.putExtra("itemUid", itemUid);
        startActivity(i);

    }
}







