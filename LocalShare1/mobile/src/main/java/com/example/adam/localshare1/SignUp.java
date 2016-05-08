package com.example.adam.localshare1;

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

import java.util.Map;

/**
 * Created by kalli on 5/7/16.
 */
public class SignUp extends AppCompatActivity implements View.OnClickListener {

    Button signup;
    TextView login;
    EditText email;
    EditText password;
    EditText password2;
    final Firebase ref = new Firebase("https://localshare.firebaseio.com");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Firebase.setAndroidContext(this);

        signup = (Button)findViewById(R.id.btn_signup);
        signup.setOnClickListener(this);
        login = (TextView) findViewById(R.id.link_login);
        login.setOnClickListener(this);
        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        password2 = (EditText)findViewById(R.id.password2);
    }

public void login() {

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
            CharSequence text = "Error";
            int duration = Toast.LENGTH_LONG;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    });
}

    @Override
    public void onClick(View view)
    {
        if (view.getId() == login.getId()) {
            Intent j = new Intent(this, MainActivity.class);
            startActivity(j);
        } else if (view.getId() == signup.getId()) {

            if(password.getText().toString().equals(password2.getText().toString())) {


                ref.createUser(email.getText().toString(), password.getText().toString(), new Firebase.ValueResultHandler<Map<String, Object>>() {
                    @Override
                    public void onSuccess(Map<String, Object> result) {
                        login();
                    }
                    @Override
                    public void onError(FirebaseError firebaseError) {
                        Context context = getApplicationContext();
                        CharSequence text = "Error";
                        int duration = Toast.LENGTH_LONG;

                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                    }


                });
            } else {
                Context context = getApplicationContext();
                CharSequence text = "Passwords don't match";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }
        }
    }

}
