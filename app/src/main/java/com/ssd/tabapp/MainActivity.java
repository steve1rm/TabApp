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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupAppBar();
        setupTabs();
        setupDrawerLayout();
    }

    private void setupDrawerLayout() {
        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        mDrawerToggle = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.string.opened, R.string.closed);
        drawerLayout.setDrawerListener(mDrawerToggle);

         /* The reason for the warning here - because we set the NoActionBar in our style.
            you can just ignore this warning. */
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void setupTabs() {
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_recents));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_favourites));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_nearby));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_music));
        tabLayout.addTab(tabLayout.newTab().setCustomView(R.layout.tab_messages));
    }

    private void setupAppBar() {
        Toolbar toolbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        /* This little thing will display our actual hamburger icon*/
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mDrawerToggle.onConfigurationChanged(newConfig);
    }
}



