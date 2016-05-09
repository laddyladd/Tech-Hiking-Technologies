package com.example.kalli.localshare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button loginButton;
    TextView signup;
    EditText email;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Firebase.setAndroidContext(this);

        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button)findViewById(R.id.login);
        loginButton.setOnClickListener(this);
        signup = (TextView) findViewById(R.id.link_signup);
        signup.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == signup.getId()) {
            Intent j = new Intent(this, SignUp.class);
            startActivity(j);
        } else if (view.getId() == loginButton.getId()){
            login();
        }

    }
    public void login() {
        final Firebase ref = new Firebase("https://localshare.firebaseio.com");
        ref.authWithPassword(email.getText().toString(), password.getText().toString(), new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                System.out.println("User ID: " + authData.getUid() + ", Provider: " + authData.getProvider());
                Intent j = new Intent(getApplicationContext(), AvailableItems.class);
                startActivity(j);
                finish();
            }
            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Context context = getApplicationContext();
                CharSequence text = "Error" + firebaseError;
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        });
    }
}
