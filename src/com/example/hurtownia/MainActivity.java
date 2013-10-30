package com.example.hurtownia;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {
	ListView listView ;
	Button Button;
	    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		RequestTask requestTask = new RequestTask();
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView = (ListView) findViewById(R.id.list);
		String[] ids = new String[1];
		ids[0] = "test";
		ListAdapter adapter = new ListAdapter(getBaseContext(),R.layout.row, ids);
        listView.setAdapter(adapter);
        
        Button = (Button)findViewById(R.id.Button);

        Button.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                	Intent intent = new Intent(MainActivity.this, ScannerActivity.class);  
                	MainActivity.this.startActivity(intent);
                }
        });
        
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
