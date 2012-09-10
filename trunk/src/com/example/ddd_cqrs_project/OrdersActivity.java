package com.example.ddd_cqrs_project;

import java.util.ArrayList;
import java.util.HashMap;


import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.SimpleAdapter;
 
public class OrdersActivity extends ListActivity {

	// ArrayList holds the data (as HashMaps) to load into the ListView
	ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
	// SimpleAdapter does the work to load the data in to the ListView
	private SimpleAdapter sa;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.orders_layout);

		// HashMap links each line of data to the correct TextView
		HashMap<String, String> item;
		for (int i = 0; i < StatesAndCapitals.length; i++) {
			item = new HashMap<String, String>();
			item.put("line1", StatesAndCapitals[i][0]);
			item.put("line2", StatesAndCapitals[i][1]);
			item.put("line3", StatesAndCapitals[i][2]);
			list.add(item);
		}

		sa = new SimpleAdapter(this, list, R.layout.order_list_lines, new String[] {
				"line1", "line2", "line3" }, new int[] { R.id.orderDate, R.id.statusOfTheOrder, R.id.priceTotal });

		setListAdapter(sa);
	}

	

	private String[][] StatesAndCapitals = {
			{ "2012-09-03 23:31:02.854", "ARCHIVED", "1349,95 EUR" },
			{ "2012-09-01 17:15:13.452", "DRAFT", "2159,92 EUR" },
			{ "2012-09-05 20:49:54.051", "SUBMITTED", "2429,92 EUR" },
			{ "2012-09-05 20:55:33.842", "SUBMITTED", "4319,85 EUR" } };
}
