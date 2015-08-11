package com.spinno.listory;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;

import butterknife.ButterKnife;
import it.neokree.materialtabs.MaterialTab;
import it.neokree.materialtabs.MaterialTabHost;
import it.neokree.materialtabs.MaterialTabListener;


public class GroupActivity extends FragmentActivity  implements  MaterialTabListener {



    private ViewPager pager;
    private ViewPagerAdapter pagerAdapter;
    MaterialTabHost tabHost;
    private Resources res;


    public static Activity mainActivitywithicon ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group);

        ButterKnife.bind(this);
        mainActivitywithicon = this ;

        res = this.getResources();


        tabHost = (MaterialTabHost) this.findViewById(R.id.tabHost);
        pager = (ViewPager) this.findViewById(R.id.pager);
        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);
        pager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                // when user do a swipe the selected tab change
                tabHost.setSelectedNavigationItem(position);
            }
        });
        // insert all tabs from pagerAdapter data
        for (int i = 0; i < pagerAdapter.getCount(); i++) {
            tabHost.addTab(
                    tabHost.newTab()
                            .setIcon(getIcon(i))
                            .setTabListener(this)
            );
        }
    }


    @Override
    public void onTabSelected(MaterialTab tab) {
// when the tab is clicked the pager swipe content to the tab position
        pager.setCurrentItem(tab.getPosition());
    }
    @Override
    public void onTabReselected(MaterialTab tab) {
    }
    @Override
    public void onTabUnselected(MaterialTab tab) {
    }






    private class ViewPagerAdapter extends FragmentStatePagerAdapter {
        String [] titles = {"Favourites" , "Men" ,"Women" ,"Home Stuff"};
        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }
        public Fragment getItem(int num) {
            switch (num){
                case  0:
                    return new FragmentOne();
                case  1:
                    return new FragmentGroup();
                case  2:
                    return new FragmentOne();
                case  3:
                    return new FragmentOne();
                default:
                    return new FragmentOne();
            }
        }
        @Override
        public int getCount() {
            return 4;
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }

    private Drawable getIcon(int position) {
        switch(position) {
            case 0:
                return res.getDrawable(R.drawable.clock_icon);
            case 1:
                return res.getDrawable(R.drawable.group_icon);
            case 2:
                return res.getDrawable(R.drawable.menu_icon);
            case 3:
                return res.getDrawable(R.drawable.setting_icon);
        }
        return null;
    }

}