package com.example.kalli.localshare;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by kalli on 5/8/16.
 */
public class MyItems extends BaseActivity implements View.OnClickListener, ListView.OnItemClickListener {

    FrameLayout r;
    Button newItem;
    ListView myItemsListView;
    ArrayList<Item> myItems;
    ArrayList<String> myItemsAsStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        // inflate the view
        r = (FrameLayout) findViewById(R.id.content_base);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_my_items, null);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content_base);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        newItem = (Button) findViewById(R.id.btn_add_new_item);
        newItem.setOnClickListener(this);
        myItemsListView = (ListView) findViewById(R.id.items_list);
        myItems = new ArrayList<Item>();
        myItemsAsStrings = new ArrayList<String>();

        Firebase itemsRef = new Firebase("https://localshare.firebaseio.com/items");

        // Attach an listener to read the data at our posts reference
        itemsRef.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                String postedByUser = (String) snapshot.child("postedByUser").getValue();

                Firebase ref = new Firebase("https://localshare.firebaseio.com/");
                if (postedByUser != null && postedByUser.equals(ref.getAuth().getUid())) {
                    String itemUid = snapshot.getKey();
                    String itemName = (String) snapshot.child("name").getValue();
                    String itemDescription = (String) snapshot.child("description").getValue();
                    String itemPrice = (String) snapshot.child("pricePerDay").getValue();
                    String itemLateFee = (String) snapshot.child("lateFeePerDay").getValue();
                    String itemDamageFee = (String) snapshot.child("damageFee").getValue();
                    String itemDelivery = (String) snapshot.child("delivery").getValue();
                    String itemRentalTerms = (String) snapshot.child("rentalTerms").getValue();

                    Item item = new Item(itemUid, postedByUser, itemName, itemDescription, itemPrice, itemLateFee, itemDamageFee, null, itemDelivery, itemRentalTerms);
                    myItems.add(item);
                    myItemsAsStrings.add(item.getName());

                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                            getApplicationContext(), android.R.layout.simple_list_item_1, myItemsAsStrings) {

                        @Override
                        public View getView(int position, View convertView,
                                            ViewGroup parent) {
                            View view = super.getView(position, convertView, parent);

                            TextView textView = (TextView) view.findViewById(android.R.id.text1);

                        /*YOUR CHOICE OF COLOR*/
                            textView.setTextColor(Color.BLACK);

                            return view;
                        }
                    };
                /*SET THE ADAPTER TO LISTVIEW*/

                    myItemsListView.setAdapter(adapter);
                }

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
        myItemsListView.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == newItem.getId())
        {
            Intent j = new Intent(this, NewItem.class);
            startActivity(j);
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Item item = myItems.get(position);
        Intent i = new Intent(this, YourItemDetails.class);
        i.putExtra("itemUid", item.getUid());
        startActivity(i);

    }
}
