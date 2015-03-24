package com.todo.event;




import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import com.todo.R;
import com.todo.library.DatabaseHandler;
import com.todo.library.JSONParser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class ListEvent extends Activity{
	
	ListView listview;
	ListViewAdapterEvent adapterr;
	
	
	static String idevent = "idevent";
	static String type = "type";
	static String titre = "titre";
	static String disc = "disc";
	static String date = "date";
	static String uid = "uid";
	
	// private static String url = "http://fidy.creativeloft.net/mescartes.php?uid=" +"uid" ;
	 
	 
	 JSONParser jParser = new JSONParser();
	 
		
		// contacts JSONArray
		JSONArray event = null;
		public static ArrayList<HashMap<String, String>> mylist;
		
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listevent);
		
		  mylist = new ArrayList<HashMap<String, String>>();
		  
		  
		  
		  try {
				
				DatabaseHandler db = new DatabaseHandler(getApplicationContext());
				  //Get user infomation from db to hashmap:
			 
				  HashMap<String, String> userDetailsHash = db.getUserDetails();
				 
				  final String uid = userDetailsHash.get("uid");
				  Log.i("uid :",uid);
				
				
				  
				JSONParser jParser = new JSONParser();

				
				//url= "http://172.16.248.158:80/fidy/mescartes.php?uid="+"uid";
				
				//System.out.printf("urllllllllllllll",url);
				
				 JSONObject json = jParser
		                    .getJSONFromUrl("http://192.168.1.2/ToDoApp/mesevents.php?uid='"+uid+"'");
		          Log.d("eveeeeeeeent", "json is "+json);
				
				
				event = json.getJSONArray("eveeeeeeeent");
				Log.i("event",event.toString());

				mylist= new ArrayList<HashMap<String, String>>();
				
				
				for (int j = 0; j< event.length(); j++) {
					JSONObject c = event.getJSONObject(j);

					// Storing each json item in variable
					//String idc = c.getString("idusercarte");
					String type = c.getString("type");
					Log.i("tyyyyyyyype",type);
					String titre = c.getString("titre");
					Log.i("tiiiiitre",titre);
					String disc = c.getString("disc");
					Log.i("nuuuuuumcarte",disc);
					String date = c.getString("date");
					Log.i("daaaaaaate",date);
					
					// creating new HashMap
					HashMap<String, String> map = new HashMap<String, String>();

					// adding each child node to HashMap key => value
					//map.put("idusercarte", idc);
					map.put("type", type);
					map.put("titre", titre);
					map.put("disc", disc);
					map.put("date", date);

					mylist.add(map);
					
					
					
					
				}
			} catch (JSONException e) {
				Log.e("log_tag", "Error parsing data " + e.toString());
			}

			// Locate the listview in listview_main.xml
			listview = (ListView) findViewById(R.id.list);
			listview.setEmptyView(findViewById(R.id.empty));
			// Pass the results into ListViewAdapter.java
			adapterr = new ListViewAdapterEvent(ListEvent.this, mylist);
			// Set the adapter to the ListView
			listview.setAdapter(adapterr);
	

		     
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}}
