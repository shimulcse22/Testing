package com.example.testing.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.testing.Fragments.CountryFragment;
import com.example.testing.Fragments.JobFragment;
import com.example.testing.Fragments.PassportFragment;
import com.example.testing.Fragments.PersonFragment;
import com.example.testing.Fragments.UploadFragment;
import com.example.testing.Model;
import com.example.testing.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class InformationActivity extends AppCompatActivity implements PersonFragment.PersonInformation {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        BottomNavigationView bottomNav = findViewById(R.id.navID);

        bottomNav.setOnNavigationItemSelectedListener(navListener);
        loadFragment(new CountryFragment());
    }

    public boolean loadFragment(Fragment fr){
        if(fr !=null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fr)
                    .commit();
            return true;
        }
        return false;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                    Fragment selectedFragment = null;

                    switch (menuItem.getItemId()){
                        case R.id.nav_person:
                            selectedFragment = new PersonFragment();
                            break;
                        case R.id.nav_passport:
                            selectedFragment = new PassportFragment();
                            break;
                        case R.id.nav_upload:
                            selectedFragment = new UploadFragment();
                            break;
                        case R.id.nav_country:
                            selectedFragment = new CountryFragment();
                            break;
                        case R.id.nav_job:
                            selectedFragment = new JobFragment();
                            break;

                    }

                    getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, selectedFragment)
                            .addToBackStack(null)
                            .commit();
                    return true;
                }
            };

    @Override
    public void getPerSonInformation(Model model) {

        String name = model.getName();
        String email = model.getEmail();
        String mobile = model.getNumber();
    }
}
