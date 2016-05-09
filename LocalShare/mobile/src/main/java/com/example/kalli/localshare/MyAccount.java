package com.example.kalli.localshare;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

/**
 * Created by kalli on 5/8/16.
 */
public class MyAccount extends BaseActivity implements View.OnClickListener {

    FrameLayout r;
    EditText name;
    EditText phone;
    EditText street;
    EditText city;
    EditText state;
    EditText zip;
    Button save;
    final Firebase ref = new Firebase("https://localshare.firebaseio.com");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Firebase.setAndroidContext(this);

        r = (FrameLayout) findViewById(R.id.content_base);
        LayoutInflater vi = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = vi.inflate(R.layout.activity_my_account, null);
        ViewGroup insertPoint = (ViewGroup) findViewById(R.id.content_base);
        insertPoint.addView(v, 0, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT));

        name = (EditText) findViewById(R.id.name);
        phone = (EditText) findViewById(R.id.phone);
        street = (EditText) findViewById(R.id.street);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        zip = (EditText) findViewById(R.id.zip);
        save = (Button) findViewById(R.id.btn_save);
        save.setOnClickListener(this);

        String uid = ref.getAuth().getUid();
        Firebase usersRef = ref.child("users").child(uid);        // Attach an listener to read the data at our posts reference
        usersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                System.out.println("There are " + snapshot.getChildrenCount() + " blog posts");
                for (DataSnapshot postSnapshot: snapshot.getChildren()) {
                    String userName = (String) snapshot.child("name").getValue();
                    String userPhone = (String) snapshot.child("phone").getValue();
                    String userStreet = (String) snapshot.child("address/street").getValue();
                    String userCity = (String) snapshot.child("address/city").getValue();
                    String userState = (String) snapshot.child("address/state").getValue();
                    String userZip = (String) snapshot.child("address/zip").getValue();

                    name.setText(userName);
                    phone.setText(userPhone);
                    street.setText(userStreet);
                    city.setText(userCity);
                    state.setText(userState);
                    zip.setText(userZip);

                }
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {
                System.out.println("The read failed: " + firebaseError.getMessage());
                Context context = getApplicationContext();
                CharSequence text = "Error saving data";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == save.getId()) {
            String uid = ref.getAuth().getUid();

            Address address = new Address(street.getText().toString(), city.getText().toString(), state.getText().toString(), zip.getText().toString());

            User user = new User(uid, name.getText().toString(), phone.getText().toString(), address);

            Firebase usersRef = ref.child("users").child(uid);
            usersRef.child("name").setValue(user.getName());
            usersRef.child("phone").setValue(user.getPhone());
            usersRef.child("address/street").setValue(address.getStreet());
            usersRef.child("address/city").setValue(address.getCity());
            usersRef.child("address/state").setValue(address.getState());
            usersRef.child("address/zip").setValue(address.getZip());

            Context context = getApplicationContext();
            CharSequence text = "Saved";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }
}
