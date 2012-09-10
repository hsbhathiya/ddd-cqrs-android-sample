package com.example.ddd_cqrs_project;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;


public class ConfirmOrderActivity extends ListActivity {

	// ArrayList holds the data (as HashMaps) to load into the ListView
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// SimpleAdapter does the work to load the data in to the ListView
	private SimpleAdapter sa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.confirm_order_main);

		// HashMap links each line of data to the correct TextView
		HashMap<String, String> item;
		for (int i = 0; i < StatesAndCapitals.length; i++) {
			item = new HashMap<String, String>();
			item.put("line1", StatesAndCapitals[i][0]);
			item.put("line2", StatesAndCapitals[i][1]);
			item.put("line3", StatesAndCapitals[i][2]);
			list.add(item);
		}

		sa = new SimpleAdapter(this, list, R.layout.confirm_order_lines, new String[] {
				"line1", "line2", "line3" }, new int[] { R.id.productInCart, R.id.totalPriceOfProducts, R.id.quantityOfProducts });

		setListAdapter(sa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.confirm_order_menu, menu);
		return true;
	}
	
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	final TextView statusValue = (TextView)findViewById(R.id.statusValue);
    	
    	switch(item.getItemId())
    	{
    		case R.id.confirmOrder:
    	    	statusValue.setText("SUBMITTED");
    			Toast.makeText(this, "Option Confirm", Toast.LENGTH_SHORT).show();
    			return true;
    			
    		case R.id.cancelOrder:
    	    	statusValue.setText("CANCELED");
    			Toast.makeText(this, "Option Cancel", Toast.LENGTH_SHORT).show();
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
			{ "Cell Phone with 32GB flash memory 01", "299,99 EUR", "8" },
			{ "Electronic Gizmo 02", "0,99 EUR", "1" },
			{ "Software Engineering Audiobook 4", "52.5 EUR", "3"},
			{ "Software Engineering Audiobook 10", "175 EUR", "10"} };
}
