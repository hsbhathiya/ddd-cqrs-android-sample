package com.example.ddd_cqrs_project;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;
import android.app.ListActivity;
import android.app.TabActivity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TabHost;
import android.widget.Toast;
import android.widget.TabHost.TabSpec;

public class MainActivity extends TabActivity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        TabHost tabHost = getTabHost();
 
        TabSpec photospec = tabHost.newTabSpec("Products");
        photospec.setIndicator("Products", getResources().getDrawable(R.drawable.icon_photos_tab));
        //photospec.setIndicator("Products");
        Intent photosIntent = new Intent(this, ProductsActivity.class);
        photospec.setContent(photosIntent);
 
        TabSpec songspec = tabHost.newTabSpec("Orders");
        songspec.setIndicator("Orders", getResources().getDrawable(R.drawable.icon_songs_tab));
        //songspec.setIndicator("Orders");
        Intent songsIntent = new Intent(this, OrdersActivity.class);
        songspec.setContent(songsIntent);
 
        TabSpec videospec = tabHost.newTabSpec("Shipments");
        videospec.setIndicator("Shipments", getResources().getDrawable(R.drawable.icon_videos_tab));
        //videospec.setIndicator("Shipments");
        Intent videosIntent = new Intent(this, ShipmentsActivity.class);
        videospec.setContent(videosIntent);
 
        // Adding all TabSpec to TabHost
        tabHost.addTab(photospec); 
        tabHost.addTab(songspec);
        tabHost.addTab(videospec);
    }
}