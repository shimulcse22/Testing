package com.example.testing.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.testing.Fragments.CountryFragment;
import com.example.testing.Fragments.JobFragment;
import com.example.testing.Fragments.PassportFragment;
import com.example.testing.Fragments.PersonFragment;
import com.example.testing.Fragments.UploadFragment;
import com.example.testing.Model;
import com.example.testing.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InformationActivity extends AppCompatActivity implements ItemPageSelectListener {
    ViewPager viewPager;
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
                            viewPager.setCurrentItem(2, false);
                            break;
                        case R.id.nav_passport:
                            viewPager.setCurrentItem(3, false);
                            break;
                        case R.id.nav_upload:
                            viewPager.setCurrentItem(4, false);
                            break;
                        case R.id.nav_country:
                            viewPager.setCurrentItem(0, false);
                            break;
                        case R.id.nav_job:
                            viewPager.setCurrentItem(1, false);
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
            viewPager.setCurrentItem(nextItem, true);
        }
    }

    @Override
    public void onSelectPreviousItem() {
        int nextItem = viewPager.getCurrentItem() - 1;
        if (nextItem >= 0) {
            viewPager.setCurrentItem(nextItem, true);
        }
    }
}