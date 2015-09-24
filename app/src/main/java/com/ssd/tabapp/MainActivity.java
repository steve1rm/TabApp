package com.ssd.tabapp;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar)findViewById(R.id.appbar);
        setSupportActionBar(toolbar);

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
}
