package com.example.ddd_cqrs_project;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.Toast;
 
public class ShipmentsActivity extends ListActivity {

	// ArrayList holds the data (as HashMaps) to load into the ListView
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// SimpleAdapter does the work to load the data in to the ListView
	private SimpleAdapter sa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.shipments_layout);

		// HashMap links each line of data to the correct TextView
		HashMap<String, String> item;
		for (int i = 0; i < StatesAndCapitals.length; i++) {
			item = new HashMap<String, String>();
			item.put("line1", StatesAndCapitals[i][0]);
			item.put("line2", StatesAndCapitals[i][1]);
			item.put("line3", StatesAndCapitals[i][2]);
			list.add(item);
		}

		sa = new SimpleAdapter(this, list, R.layout.shipments_lines, new String[] {
				"line1", "line2", "line3" }, new int[] { R.id.shipmentId, R.id.orderId, R.id.status });

		setListAdapter(sa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.shipments_menu, menu);
		return true;
	}
	
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch(item.getItemId())
    	{
    		case R.id.sendShipment:
    			Toast.makeText(this, "Option Send", Toast.LENGTH_SHORT).show();
    			return true;
    			
    		case R.id.deliverShipment:
    			Toast.makeText(this, "Option Deliver", Toast.LENGTH_SHORT).show();
				return true;
				
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    }

    private void show(String text)
	{
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	private String[][] StatesAndCapitals = {
			{ "1", "2", "DELIVERED" },
			{ "2", "4", "  SENT  " },
			{ "3", "9", "WAITING"},
			{ "4", "11", "WAITING"} };
}