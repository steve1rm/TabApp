package com.ssd.tabapp;

import android.content.res.Configuration;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, mDrawerLayout, R.string.opened, R.string.closed);
        mDrawerLayout.setDrawerListener(mDrawerToggle);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        setupTabs();
    }

    private void setupTabs() {
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        TabLayout.Tab findTab = tabLayout.newTab();
        findTab.setCustomView(R.layout.tab_recents);
        tabLayout.addTab(findTab);

        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_favourites));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_nearby));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_music));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_messages));

/*
        tabLayout.addTab(tabLayout.newTab().setText(R.string.movies));
        tabLayout.addTab(tabLayout.newTab().setText("Music"));
        tabLayout.addTab(tabLayout.newTab().setText("Library"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.ic_action_ic_search_white_24dp));
        tabLayout.addTab(tabLayout.newTab().setText("Favourites"));
        TabLayout.Tab searchTab = tabLayout.newTab();

        searchTab.setIcon(R.drawable.ic_action_ic_search_white_24dp);
        searchTab.setText("Find");
        tabLayout.addTab(searchTab);
*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}
