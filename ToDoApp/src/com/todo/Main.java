package com.todo;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.todo.R;
import com.todo.event.ListEvent;
import com.todo.event.TypeEventActivity;
import com.todo.library.DatabaseHandler;
import com.todo.library.UserFunctions;

import java.util.HashMap;

public class Main extends Activity {
   

Button profile;
Button create;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        profile = (Button) findViewById(R.id.buttonprofil);
        profile.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), Profile.class);
                startActivityForResult(myIntent, 0);
                finish();
             }});
        
        
        Button Ajout = (Button) findViewById(R.id.buttoneventlist);
	      
		Ajout.setOnClickListener(new View.OnClickListener() {
		

			public void onClick(View view) {

				
				Intent i = new Intent(getApplicationContext(),
						ListEvent.class);
				startActivity(i);
			}
		});		
	
        
        create= (Button) findViewById(R.id.buttoncreatevent);
        create.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent myIntent = new Intent(view.getContext(), TypeEventActivity.class);
            startActivityForResult(myIntent, 0);
            finish();
         }});

        DatabaseHandler db = new DatabaseHandler(getApplicationContext());

        /**
         * Hashmap to load data from the Sqlite database
         **/
         HashMap<String,String> user = new HashMap<String, String>();
         user = db.getUserDetails();


        
/**
 * Sets user first name and last name in text view.
 **/
     //   final TextView login = (TextView) findViewById(R.id.textwelcome);
      //  login.setText("Welcome  "+user.get("fname"));
       // final TextView lname = (TextView) findViewById(R.id.lname);
       // lname.setText(user.get("lname"));


    }}