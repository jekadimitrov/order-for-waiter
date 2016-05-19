package com.example.evgen.myrest;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by EVGEN on 25.04.2016.
 */
public class ViewPagerAdapter1 extends FragmentStatePagerAdapter {

    CharSequence Titles1[]; // This will Store the Titles of the Tabs which are Going to be passed when ViewPagerAdapter is created
    int NumbOfTabs1; // Store the number of tabs, this will also be passed when the ViewPagerAdapter is created


    // Build a Constructor and assign the passed Values to appropriate values in the class
    public ViewPagerAdapter1(FragmentManager fm1, CharSequence mTitles1[], int mNumbOfTabsumb1) {
        super(fm1);

        this.Titles1 = mTitles1;
        this.NumbOfTabs1 = mNumbOfTabsumb1;

    }

    //This method return the fragment for the every position in the View Pager
    @Override
    public Fragment getItem(int position) {

        if(position == 0) // if the position is 0 we are returning the First tab
        {
            MessageOrder1 message1 = new MessageOrder1();
            return message1;
        }
        else             // As we are having 2 tabs if the position is now 0 it must be 1 so we are returning second tab
        {
            MessageOrder2 message2 = new MessageOrder2();
            return message2;
        }


    }

    // This method return the titles for the Tabs in the Tab Strip

    @Override
    public CharSequence getPageTitle(int position) {
        return Titles1[position];
    }

    // This method return the Number of tabs for the tabs Strip

    @Override
    public int getCount() {
        return NumbOfTabs1;
    }
}
