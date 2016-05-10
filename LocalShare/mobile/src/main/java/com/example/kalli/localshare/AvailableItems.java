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
import android.widget.EditText;
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
public class AvailableItems extends BaseActivity implements View.OnClickListener, ListView.OnItemClickListener {

    FrameLayout r;
    ListView itemListView;
    EditText search;
    Button searchB;
    ArrayList<Item> items;
    ArrayList<String> itemsAsStrings;
    ArrayAdapter<String> arrayAdapter;
    ArrayList<String> searcher;
    ArrayAdapter<String> adapter;
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
        searchB = (Button)findViewById(R.id.searchB);
        searchB.setOnClickListener(this);
        Firebase itemsRef = new Firebase("https://localshare.firebaseio.com/items");

        items = new ArrayList<Item>();
        //set up list of items
        itemsAsStrings = new ArrayList<String>();

        // Attach an listener to read the data at our posts reference
        itemsRef.addChildEventListener(new ChildEventListener() {
            // Retrieve new posts as they are added to the database
            @Override
            public void onChildAdded(DataSnapshot snapshot, String previousChildKey) {
                System.out.print(snapshot.getKey());
                String itemUid = (String) snapshot.child("uid").getValue();
                String itemPostedByUser = (String) snapshot.child("postedByUser").getValue();
                String itemName = (String) snapshot.child("name").getValue();
                String itemDescription = (String) snapshot.child("description").getValue();
                String itemPrice = (String) snapshot.child("pricePerDay").getValue();
                String itemLateFee = (String) snapshot.child("lateFeePerDay").getValue();
                String itemDamageFee = (String) snapshot.child("damageFee").getValue();
                String itemDelivery = (String) snapshot.child("delivery").getValue();
                String itemRentalTerms = (String) snapshot.child("rentalTerms").getValue();

                Item item = new Item(itemUid,itemPostedByUser, itemName, itemDescription, itemPrice, itemLateFee, itemDamageFee, Item.Status.AVAILABLE, itemDelivery, itemRentalTerms);
                items.add(item);
                itemsAsStrings.add(item.getName());
                arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,
                        itemsAsStrings);

                ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                        getApplicationContext(), android.R.layout.simple_list_item_1, itemsAsStrings){

                    @Override
                    public View getView(int position, View convertView,
                                        ViewGroup parent) {
                        View view =super.getView(position, convertView, parent);

                        TextView textView=(TextView) view.findViewById(android.R.id.text1);

                        /*YOUR CHOICE OF COLOR*/
                        textView.setTextColor(Color.BLACK);

                        return view;
                    }
                };
                /*SET THE ADAPTER TO LISTVIEW*/

                itemListView.setAdapter(adapter);
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
        String check = search.getText().toString().toLowerCase();
        searcher = new ArrayList<String>(itemsAsStrings);
        itemsAsStrings.clear();

        for (int i = 0; i < searcher.size(); i++) {
            if (check.equals("")) {//if blank reset all data
                itemsAsStrings.add(searcher.get(i));
            } else if (searcher.get(i).toLowerCase().contains(check) || check.equals(searcher.get(i).toLowerCase())) {
                itemsAsStrings.add(searcher.get(i));

            }
        }
        adapter.notifyDataSetChanged();

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {

        Item item = items.get(position);
        Intent i = new Intent(this, ItemDetails.class);
        i.putExtra("itemUid", item.getUid());
        startActivity(i);

    }

    public void moveToWatchClickedItem(int i){

    }
}
