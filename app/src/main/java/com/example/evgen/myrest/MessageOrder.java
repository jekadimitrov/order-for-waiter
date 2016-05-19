package com.example.evgen.myrest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by EVGEN on 25.04.2016.
 */
public class MessageOrder extends AppCompatActivity {
    Toolbar toolbar1;
    ViewPager pager1;
    ViewPagerAdapter1 adapter;
    SlidingTabLayout tabs1;
    CharSequence Titles1[] = {"zakaz ", "Taxi", "Check"};
    int Numboftabs1 = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message_order);


        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar1 = (Toolbar) findViewById(R.id.tool_bar1);
        setSupportActionBar(toolbar1);


        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter1(getSupportFragmentManager(), Titles1, Numboftabs1);

        // Assigning ViewPager View and setting the adapter
        pager1 = (ViewPager) findViewById(R.id.pager1);
        pager1.setAdapter(adapter);

        // Assiging the Sliding Tab Layout View
        tabs1 = (SlidingTabLayout) findViewById(R.id.tabs1);
        tabs1.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs1.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.tabsScrollColor);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs1.setViewPager(pager1);

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; go home
                Intent intent = new Intent(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}