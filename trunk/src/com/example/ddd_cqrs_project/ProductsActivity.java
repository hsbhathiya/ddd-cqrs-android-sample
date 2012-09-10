package com.example.ddd_cqrs_project;

import java.util.ArrayList;
import java.util.HashMap;
import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.Toast;
 
public class ProductsActivity extends ListActivity{

	final Context context = this;
	
	
	// ArrayList holds the data (as HashMaps) to load into the ListView
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// SimpleAdapter does the work to load the data in to the ListView
	private SimpleAdapter sa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.products_layout);

		// HashMap links each line of data to the correct TextView
		HashMap<String, String> item;
		for (int i = 0; i < StatesAndCapitals.length; i++) {
			item = new HashMap<String, String>();
			item.put("line1", StatesAndCapitals[i][0]);
			item.put("line2", StatesAndCapitals[i][1]);
			list.add(item);
		}

		sa = new SimpleAdapter(this, list, R.layout.my_two_lines, new String[] {
				"line1", "line2" }, new int[] { R.id.line_a, R.id.line_b });

		setListAdapter(sa);
		
		wireUpSearchButton();
	}
	
	private void wireUpSearchButton() {
		Button button = (Button) findViewById(R.id.findButton);

		// add button listener
		button.setOnClickListener(new OnClickListener() {

			public void onClick(View arg0) {

				// custom dialog
				final Dialog dialog = new Dialog(context);
				dialog.setContentView(R.layout.custom);
				dialog.setTitle("Product search");

				// set the custom dialog components - text, image and button
				
				Button dialogButton = (Button) dialog.findViewById(R.id.searchButton);
				// if button is clicked, close the custom dialog
				dialogButton.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						show("Search selected!");
						dialog.dismiss();
					}
				});
				
				Button showAllButton = (Button) dialog.findViewById(R.id.showAll);
				// if button is clicked, close the custom dialog
				showAllButton.setOnClickListener(new OnClickListener() {
					public void onClick(View v) {
						show("Show All selected!");
						dialog.dismiss();
					}
				});

				dialog.show();
			}

		});
		
	}

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public boolean onOptionsItemSelected(MenuItem item)
    {
    	RelativeLayout bkgr = (RelativeLayout)findViewById(R.id.uilayout);
    	
    	switch(item.getItemId())
    	{
    		case R.id.add:
    			Toast.makeText(this, "Option Add to cart", Toast.LENGTH_SHORT).show();
    			return true;
    		case R.id.checkout:
    			checkout();
				return true;
    		case R.id.viewCart:
    			
    			viewCart();
    			
				return true;
    		
    			
    		default:
    			return super.onOptionsItemSelected(item);
    	}
    }

    private void checkout() {
    	Intent i = new Intent(this, ConfirmOrderActivity.class);
		startActivity(i);
	}

	private void viewCart() {
    	Intent i = new Intent(this, ViewCartActivity.class);
		startActivity(i);
	}

	private void show(String text)
	{
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	
	private String[][] StatesAndCapitals = {
			{ "Cell Phone with 32GB flash memory 01", "299,99 EUR" },
			{ "Cell Phone with 32GB flash memory 02", "299,99 EUR" },
			{ "Cell Phone with 32GB flash memory 03", "299,99 EUR" },
			{ "Electronic Gizmo 01", "0,99 EUR" },
			{ "Electronic Gizmo 02", "0,99 EUR" },
			{ "Electronic Gizmo 03", "0,99 EUR" },
			{ "PC Game including Zombies Part 01", "39,89 EUR" },
			{ "PC Game including Zombies Part 02", "39,89 EUR" },
			{ "PC Game including Zombies Part 03", "39,89 EUR" }, 
			{ "Software Engineering Audiobook 1", "17,50 EUR" },
			{ "Software Engineering Audiobook 2", "17,50 EUR" },
			{ "Software Engineering Audiobook 3", "17,50 EUR" },
			{ "Software Engineering Audiobook 4", "17,50 EUR" },
	};
}
