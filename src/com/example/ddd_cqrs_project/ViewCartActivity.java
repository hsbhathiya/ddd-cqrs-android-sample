package com.example.ddd_cqrs_project;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SimpleAdapter;
import android.widget.Toast;


public class ViewCartActivity extends ListActivity {

	// ArrayList holds the data (as HashMaps) to load into the ListView
	ArrayList<HashMap<String, String>> cartContentList = new ArrayList<HashMap<String, String>>();
	// SimpleAdapter does the work to load the data in to the ListView
	private SimpleAdapter sa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.view_cart_main);

		// HashMap links each line of data to the correct TextView
		HashMap<String, String> item;
		for (int i = 0; i < StatesAndCapitals.length; i++) {
			item = new HashMap<String, String>();
			item.put("line1", StatesAndCapitals[i][0]);
			item.put("line2", StatesAndCapitals[i][1]);
			item.put("line3", StatesAndCapitals[i][2]);
			cartContentList.add(item);
		}

		sa = new SimpleAdapter(this, cartContentList, R.layout.view_cart_lines, new String[] {
				"line1", "line2", "line3" }, new int[] { R.id.productInCart, R.id.totalPriceOfProducts, R.id.quantityOfProducts });

		// it assumes that the name of the list component is "list" - otherwise how it would know where to put the data
		setListAdapter(sa);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.view_cart_menu_main, menu);
		return true;
	}
	
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	switch(item.getItemId())
    	{
    		case R.id.checkout2:
    			checkout();
    			return true;
    		case R.id.clearCart2:
    			Toast.makeText(this, "Option Clear Cart", Toast.LENGTH_SHORT).show();
				return true;
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    }
    
    private void checkout() {
    	Intent i = new Intent(this, ConfirmOrderActivity.class);
		startActivity(i);
	}

    private void show(String text)
	{
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}

	private String[][] StatesAndCapitals = {
			{ "Cell Phone with 32GB flash memory 01", "299,99 EUR", "8" },
			{ "Electronic Gizmo 01", "0,99 EUR", "2" },
			{ "Electronic Gizmo 03", "0,99 EUR", "2" },
			{ "Electronic Gizmo 04", "0,99 EUR", "2" },
			{ "Electronic Gizmo 07", "0,99 EUR", "2" },
			{ "Software Engineering Audiobook 4", "17,50 EUR", "3"},
			{ "Software Engineering Audiobook 5", "17,50 EUR", "3"},
			{ "Software Engineering Audiobook 8", "17,50 EUR", "3"} };
}
