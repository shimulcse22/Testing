package com.example.testing.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.testing.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InformationActivity extends AppCompatActivity implements ItemPageSelectListener{
    NonSwipeableViewPager viewPager;
    //LanguageActivity languageActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);
        BottomNavigationView bottomNav = findViewById(R.id.navID);
        bottomNav.setOnNavigationItemSelectedListener(navListener);
        viewPager = findViewById(R.id.view_pager);
        Adapter adapter = new Adapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(adapter.getCount());

        
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.nav_person:
                            viewPager.setCurrentItem(2,false);
                            break;
                        case R.id.nav_passport:
                            viewPager.setCurrentItem(3,false);
                            break;
                        case R.id.nav_upload:
                            viewPager.setCurrentItem(4,false);
                            break;
                        case R.id.nav_country:
                            viewPager.setCurrentItem(0,false);
                            break;
                        case R.id.nav_job:
                            viewPager.setCurrentItem(1,false);
                            break;
                    }
                    return true;
                }
            };

    @Override
    public void onSelectNextItem() {
        int count = viewPager.getAdapter().getCount();
        int nextItem = viewPager.getCurrentItem() + 1;
        if (nextItem < count) {
            viewPager.setCurrentItem(nextItem,false);
        }
    }

    @Override
    public void onSelectPreviousItem() {
        int nextItem = viewPager.getCurrentItem() - 1;
        if (nextItem >= 0) {
            viewPager.setCurrentItem(nextItem,false);
        }
    }
}