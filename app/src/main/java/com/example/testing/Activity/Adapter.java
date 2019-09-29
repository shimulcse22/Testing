package com.example.testing.Activity;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.testing.Fragments.CountryFragment;
import com.example.testing.Fragments.JobFragment;
import com.example.testing.Fragments.PassportFragment;
import com.example.testing.Fragments.PersonFragment;
import com.example.testing.Fragments.UploadFragment;

public class Adapter extends FragmentStatePagerAdapter {
    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CountryFragment();
            case 1:
                return new JobFragment();
            case 2:
                return new PersonFragment();
            case 3:
                return new PassportFragment();
            case 4:
                return new UploadFragment();
            default:
                throw new IllegalArgumentException();
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}
