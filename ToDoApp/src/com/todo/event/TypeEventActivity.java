package com.todo.event;




import com.todo.Login;
import com.todo.R;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenu;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenuItem;
import com.touchmenotapps.widget.radialmenu.semicircularmenu.SemiCircularRadialMenuItem.OnSemiCircularRadialMenuPressed;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TypeEventActivity extends Activity {
	
	private SemiCircularRadialMenu mMenu;
	private SemiCircularRadialMenuItem mNote, mProject, mBirthday, mDates, mMeeting;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.typeevent);
		
		mNote = new SemiCircularRadialMenuItem("Note", getResources().getDrawable(R.drawable.note), "Note");
		mProject = new SemiCircularRadialMenuItem("Project", getResources().getDrawable(R.drawable.project), "Project");
		mBirthday = new SemiCircularRadialMenuItem("Birthday", getResources().getDrawable(R.drawable.birthday), "Birthday");
		mDates = new SemiCircularRadialMenuItem("Dates", getResources().getDrawable(R.drawable.dates), "Dates");
		mMeeting = new SemiCircularRadialMenuItem("Meeting", getResources().getDrawable(R.drawable.meeting), "Meeting");
				
		mMenu = (SemiCircularRadialMenu) findViewById(R.id.radial_menu);
		mMenu.addMenuItem(mNote.getMenuID(), mNote);
		mMenu.addMenuItem(mProject.getMenuID(), mProject);
		mMenu.addMenuItem(mBirthday.getMenuID(), mBirthday);
		mMenu.addMenuItem(mDates.getMenuID(), mDates);
		mMenu.addMenuItem(mMeeting.getMenuID(), mMeeting);
				
		mNote.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				
				
		                Intent myIntent = new Intent(mMenu.getContext(),NoteActivity.class);
		                startActivityForResult(myIntent, 0);
		               finish();
		            }

		      
				
			
		});
		
		mProject.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				
			

                Intent myIntent = new Intent(mMenu.getContext(),ProjectActivity.class);
                startActivityForResult(myIntent, 0);
               finish();
            
			}
		});
		
		mBirthday.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				

                Intent myIntent = new Intent(mMenu.getContext(),BirthdayActivity.class);
                startActivityForResult(myIntent, 0);
               finish();
            }
				
				
		});
		
		mDates.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				

                Intent myIntent = new Intent(mMenu.getContext(),DatesActivity.class);
                startActivityForResult(myIntent, 0);
               finish();
            }
				
				
		});
		
		mMeeting.setOnSemiCircularRadialMenuPressed(new OnSemiCircularRadialMenuPressed() {
			@Override
			public void onMenuItemPressed() {
				

                Intent myIntent = new Intent(mMenu.getContext(),MeetingActivity.class);
                startActivityForResult(myIntent, 0);
               finish();
            
				
				mMenu.dismissMenu();
			}
		});
	}
	@Override
	public void onBackPressed() {
		// Write your code here

		super.onBackPressed();
	}
}
