package com.todo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.todo.R;
import com.todo.library.DatabaseHandler;
import com.todo.library.UserFunctions;

import java.util.HashMap;

public class Profile extends Activity {
	 Button btnLogout;
	    Button changepas;


    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);
        changepas = (Button) findViewById(R.id.btchangepass);
        btnLogout = (Button) findViewById(R.id.logout);

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        /**
         * Hashmap to load data from the Sqlite database
         **/

        HashMap<String,String> user = new HashMap<String, String>();
        user = db.getUserDetails();

        /**
         * Displays the registration details in Text view
         **/

        final TextView fname = (TextView)findViewById(R.id.fname);
        final TextView lname = (TextView)findViewById(R.id.lname);
        final TextView uname = (TextView)findViewById(R.id.uname);
        final TextView email = (TextView)findViewById(R.id.email);
        final TextView created_at = (TextView)findViewById(R.id.regat);
        fname.setText(user.get("fname"));
        lname.setText(user.get("lname"));
        uname.setText(user.get("uname"));
        email.setText(user.get("email"));
        created_at.setText(user.get("created_at"));




        /**
         * Change Password Activity Started
         **/
        changepas.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){

                Intent chgpass = new Intent(getApplicationContext(), ChangePassword.class);

                startActivity(chgpass);
            }

        });

       /**
        *Logout from the User Panel which clears the data in Sqlite database
        **/
        btnLogout.setOnClickListener(new View.OnClickListener() {

            public void onClick(View arg0) {

                UserFunctions logout = new UserFunctions();
                logout.logoutUser(getApplicationContext());
                Intent login = new Intent(getApplicationContext(), Login.class);
                login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(login);
                finish();
            }
        });

        Button login = (Button) findViewById(R.id.main);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Main.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });


    }}
