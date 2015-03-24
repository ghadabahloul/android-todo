package com.todo.event;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;



import com.todo.Main;
import com.todo.R;
import com.todo.library.DatabaseHandler;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;



public class BirthdayActivity  extends Activity{
	InputStream is=null;
	String result=null;
	String line=null;
	int code;
	
	Button save ;
	Button cancel;
	Button cal;
	EditText titre;
	EditText disc;
	DatePicker datep;
	EditText date;
	
	

	  // variables to save user selected date and time
	 private int year, month, day;

	  private Calendar calendar;
	
 
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.birthday);
		
		 calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
	      month = calendar.get(Calendar.MONTH);
	      day = calendar.get(Calendar.DAY_OF_MONTH);
	  
	     date = (EditText) findViewById(R.id.date);
		 cal = (Button) findViewById(R.id.buttoncal);
	     // add a click listener to the button
	        cal.setOnClickListener(new View.OnClickListener() {
	            @SuppressWarnings("deprecation")
				public void onClick(View v) {
	            	showDialog(999);
	            	showDate(year, month+1, day);
	            }
	        });
	 
	      
	      
		titre = (EditText) findViewById(R.id.editTexttitre);
		disc = (EditText) findViewById(R.id.editTextdisc);
		date = (EditText) findViewById(R.id.date);
		cancel = (Button) findViewById(R.id.btn_cancel);
	
		 save = (Button) findViewById(R.id.btn_save);
		 
	
	
	
	
	
        cancel.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), TypeEventActivity.class);
                startActivityForResult(myIntent, 0);
                finish();
            }

        });
        
        
		save.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				
				
				DatabaseHandler db = new DatabaseHandler(getApplicationContext());
				  //Get user infomation from db to hashmap:
		        
				  HashMap<String, String> userDetailsHash = db.getUserDetails();
				 
				  final String uid = userDetailsHash.get("uid");
				 Log.i("uid",uid);
				
				
				ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
				
				String titree = titre.getText().toString();
				Log.i("ttttttttttitreeeeeee",titree);
				
				
				String discc= disc.getText().toString();
				Log.i("disccccccccc",discc);
				String datee = date.getText().toString();
				Log.i("daaaaaaaaate",datee);
				
				String type ="Birthday";

				
				//nameValuePairs.add(new BasicNameValuePair("idevent", idevent));
				nameValuePairs.add(new BasicNameValuePair("uid", uid));
				nameValuePairs.add(new BasicNameValuePair("type", type));
				nameValuePairs.add(new BasicNameValuePair("titre",titree));
				nameValuePairs.add(new BasicNameValuePair("disc", discc));
				nameValuePairs.add(new BasicNameValuePair("date", datee));
		
				
				
				
				try {
					/********************************************/
					
					
					
					HttpClient httpclient = new DefaultHttpClient();
			        HttpPost httppost = new HttpPost("http://192.168.1.3/ToDoApp/insertevent.php");
			        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
			        HttpResponse response = httpclient.execute(httppost); 
			        HttpEntity entity = response.getEntity();
			        is = entity.getContent();
			        Log.e("pass 1", "connection success ");
			}
				catch(Exception e)
				{
			        	Log.e("Fail 1", e.toString());
				    	Toast.makeText(getApplicationContext(), "Invalid IP Address",
						Toast.LENGTH_LONG).show();
				}   
				
				
				try
		        {
		            BufferedReader reader = new BufferedReader
					(new InputStreamReader(is,"iso-8859-1"),8);
		            StringBuilder sb = new StringBuilder();
		            while ((line = reader.readLine()) != null)
			    {
		                sb.append(line + "\n");
		            }
		            is.close();
		            result = sb.toString();
			    Log.e("pass 2", "connection success ");
			}
		        catch(Exception e)
			{
		            Log.e("Fail 2", e.toString());
			}     
		       
			try
			{
		            JSONObject json_data = new JSONObject(result);
		            code=(json_data.getInt("code"));
					
		            if(code==1)
		            {
				Toast.makeText(getBaseContext(), "Inserted Successfully",
					Toast.LENGTH_SHORT).show();
		            }
		            else
		            {
				 Toast.makeText(getBaseContext(), "Sorry, Try Again",
					Toast.LENGTH_LONG).show();
		            }
			}
			catch(Exception e)
			{
		            Log.e("Fail 3", e.toString());
			}
			
			AlertDialog.Builder builder = new AlertDialog.Builder(BirthdayActivity.this);
	        builder.setTitle("ToDo");
	        builder.setMessage(" Event Inserted Successfully ");
	        builder.setPositiveButton("show list", new DialogInterface.OnClickListener() {
	         
	          public void onClick(DialogInterface arg0, int arg1) {
	           
	        	  Intent dashboard = new Intent(getApplicationContext(), ListEvent.class);
					// Close all views before launching Dashboard
					dashboard.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(dashboard);
					// Close Registration Screen
					finish();
	          }
	        });
			
	        builder.show(); //To show the AlertDialog
		    }
		    
	
			
				
			
			});
				
				
			
        
        
        
        
        
        
		
}

	

	   @Override
	   protected Dialog onCreateDialog(int id) {
	   // TODO Auto-generated method stub
	      if (id == 999) {
	         return new DatePickerDialog(this, myDateListener, year, month, day);
	       }
	      return null;
	   }

	   private DatePickerDialog.OnDateSetListener myDateListener
	   = new DatePickerDialog.OnDateSetListener() {

	   @Override
	   public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
	      // TODO Auto-generated method stub
	      // arg1 = year
	      // arg2 = month
	      // arg3 = day
	      showDate(arg1, arg2+1, arg3);
	   }
	   };

	   private void showDate(int year, int month, int day) {
	      date.setText(new StringBuilder().append(year).append("-")
	      .append(month).append("-").append(day));
	   }

	   
                           
}
	
