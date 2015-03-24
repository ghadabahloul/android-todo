package com.todo.event;

import java.io.InputStream;

import com.todo.R;



import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;



public class EventSingleitem  extends Activity {
	
	
	public static final String KEY_EVENT = "event"; // parent node
	public static final String KEY_idevent = "idevent";
	public static final String KEY_ID = "uid";
	public static final String KEY_TYPE = "type";
	public static final String KEY_DISC = "disc";
	public static final String KEY_DATE = "date";
	public static final String KEY_TITRE = "titre";
	
	
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	
	Button modif;
	Button supp;
	
	String titre;
	 String type;
	 String disc;
	 String date;
	 Context contextt;
	
	 @Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.eventsigngleitem);
			
			Intent in = getIntent();
			
			 titre= in.getStringExtra("titre");
			 type = in.getStringExtra("type");
			 date = in.getStringExtra("date");
			 disc = in.getStringExtra("disc");
			 
			 
			 TextView typee = (TextView) findViewById(R.id.btn_type);
			 EditText titree = (EditText) findViewById(R.id.editTexttitre);
			 EditText discc = (EditText) findViewById(R.id.editTextdisc);
			EditText datee = (EditText) findViewById(R.id.date);
			
			typee.setText(type);
			titree.setText(titre);
			discc.setText(disc);
			datee.setText(date);
			
			
			modif = (Button) findViewById(R.id.btn_modif);
			supp = (Button) findViewById(R.id.btn_supp);
			
			
			
			
			
			
			
			
			
			
			
	 }
	
	
	

}
