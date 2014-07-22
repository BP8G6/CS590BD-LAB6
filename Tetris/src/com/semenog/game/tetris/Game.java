package com.semenog.game.tetris;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class Game extends Activity {
	//Maze maze;
	GameView view;
	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		//Intent intent = getIntent();
		   startService(new Intent(this,ConnectionService.class));
		   
		  
		//Bundle extras = intent.getExtras();
		//this.maze = (Maze)getLastNonConfigurationInstance();
		
		view = new GameView(this);
		registerReceiver(receiver, new IntentFilter("myproject"));
		
		setContentView(view);
		
	}
	/*@Override
	protected void onResume() {
		super.onResume();
		
		//create a register   myproject is the same key used in connectionservice
		registerReceiver(receiver, new IntentFilter("myproject"));
	}*/
	
	private BroadcastReceiver receiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			Log.i("receivig", "Broadcast signal");
			Bundle bundle = intent.getExtras();
			if (bundle!=null) {
				
				//extra data inserted into the fired intent
				String data = bundle.getString("data");
				Log.i("data in main class", data);
				
				
				if ("Rotate".equalsIgnoreCase(data)) {
					Log.i("Balkrishna", "Motion Recognition");
					view.figure.rotate();
				}
				
				else if ("Left".equalsIgnoreCase(data)) {
					Log.i("Balkrishna", "Motion Recognition");
					--view.figure.pos.x;
				}
				
				else if ("Right".equalsIgnoreCase(data)) {
					Log.i("Balkrishna", "Motion Recognition");
					++view.figure.pos.x;
				}
				
				//Toast.makeText(getApplicationContext(), "Ok", Toast.LENGTH_SHORT).show();
			}else{
				Log.i("data in main class", "bundle null");
				//Toast.makeText(getApplicationContext(), "not", Toast.LENGTH_SHORT).show();
			}
			//handleResult(bundle);
		}

		
	};
	
	//public Object onRetainNonConfigurationInstance() {
		//return this.view;
	//}
}
