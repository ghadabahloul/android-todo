package com.todo.event;



import java.util.ArrayList;
import java.util.HashMap;

import com.todo.R;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ListViewAdapterEvent extends BaseAdapter {

	
	// Declare Variables
			Context contexte;
			LayoutInflater inflater;
			ArrayList<HashMap<String, String>> dataa;
		
			HashMap<String, String> resultpp = new HashMap<String, String>();

			public ListViewAdapterEvent(Context context,
					ArrayList<HashMap<String, String>> arraylist) {
				this.contexte = context;
				dataa = arraylist;
				
			}
			

			public int getCount() {
				return dataa.size();
			}

			
			public Object getItem(int position) {
				return null;
			}

		
			public long getItemId(int position) {
				return 0;
			}
			
			public View getView(final int position, View convertView, ViewGroup parent) {
				// Declare Variables
				TextView type;
				TextView titre;
				
			

				inflater = (LayoutInflater) contexte
						.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

				View itemView = inflater.inflate(R.layout.list, parent, false);
				// Get the position
				resultpp = dataa.get(position);

				// Locate the TextViews in listview_item.xml
				type = (TextView) itemView.findViewById(R.id.ColType);
				titre= (TextView) itemView.findViewById(R.id.ColNumero);
				//typecarte = (TextView) itemView.findViewById(R.id.typee);
				


				// Capture position and set results to the TextViews
				type.setText(resultpp.get(ListEvent.date));
				titre.setText(resultpp.get(ListEvent.type));
				
			
				// Capture ListView item click
				itemView.setOnClickListener(new OnClickListener() {

					
					public void onClick(View arg0) {
						// Get the position
						resultpp = dataa.get(position);
						Intent intent = new Intent(contexte, EventSingleitem.class);
						// Pass all data rank
						intent.putExtra("date", resultpp.get(ListEvent.date));
						intent.putExtra("type", resultpp.get(ListEvent.type));
						intent.putExtra("titre", resultpp.get(ListEvent.titre));
						intent.putExtra("disc", resultpp.get(ListEvent.disc));
					
						
						// Pass all data population
					
					
						// Start SingleItemView Class
						contexte.startActivity(intent);

					}
				});
				return itemView;
			}


		

	}


