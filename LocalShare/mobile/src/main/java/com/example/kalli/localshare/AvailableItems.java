package com.example.kalli.localshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by kalli on 5/8/16.
 */
public class AvailableItems extends BaseActivity implements View.OnClickListener, ListView.OnItemClickListener {

    FrameLayout r;
    ListView itemListView;
    EditText search;

    ArrayList<Item> items;
    ArrayList<String> itemsAsStrings;
    ArrayAdapter<String> arrayAdapter;
    CommHandler commHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        // inflate the view
        r = (FrameLayout) findViewById(R.id.content_base);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_available_items, null);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content_base);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        //find elements
        itemListView = (ListView) findViewById(R.id.items_list);
        search = (EditText) findViewById(R.id.search);
        Firebase itemsRef = new Firebase("https://localshare.firebaseio.com/items");

        items = new ArrayList<Item>();
        //set up list of items
        itemsAsStrings = new ArrayList<String>();

        // Attach an listener to read the data at our posts reference
        itemsRef.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                String itemUid = (String) snapshot.child("uid").getValue();
                String itemName = (String) snapshot.child("name").getValue();
                String itemDescription = (String) snapshot.child("description").getValue();
                String itemPrice = (String) snapshot.child("pricePerDay").getValue();
                String itemLateFee = (String) snapshot.child("lateFeePerDay").getValue();
                String itemDamageFee = (String) snapshot.child("damageFee").getValue();
                String itemDelivery = (String) snapshot.child("delivery").getValue();
                String itemRentalTerms = (String) snapshot.child("rentalTerms").getValue();

                Item item = new Item(itemUid, itemName, itemDescription, itemPrice, itemLateFee, itemDamageFee, null, itemDelivery, itemRentalTerms);
                items.add(item);
                itemsAsStrings.add(item.getName());
                arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
                        itemsAsStrings);
                itemListView.setAdapter(arrayAdapter);
            }
            @Override
            public void onChildChanged(DataSnapshot snapshot, String previousChildKey) {
                System.out.println("An item has been changed");
            }
            @Override
            public void onChildRemoved(DataSnapshot snapshot) {
                System.out.println("An item has been deleted");
            }
            @Override
            public void onChildMoved(DataSnapshot snapshot, String previousChildKey) {
                System.out.println("An item has been moved");
            }
            @Override
            public void onCancelled(FirebaseError message) {
                System.out.println("Firebase error " + message);
            }
        });


        itemListView.setOnItemClickListener(this);


    }

    @Override
    public void onClick(View view) {


    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
//        Intent intent = new Intent(this, SendMessage.class);
//        String message = "abc";
////        intent.putExtra(EXTRA_MESSAGE, message);
//        startActivity(intent);
    }
    public void moveToWatchClickedItem(int i){

    }
}
