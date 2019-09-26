package com.example.testing.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testing.Activity.ApplyActivity;
import com.example.testing.R;

import java.util.ArrayList;

public class CountryFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    ArrayList<String> checkedCountries = new ArrayList<String>();
    ArrayList<String> getCheckedCountries;
    Button next_country,previous_country;
    int mCurCheckPosition =0;
    public static final String COUNTRY_TAG = "country";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_country,container,false);

        next_country = v.findViewById(R.id.country_next);
        previous_country = v.findViewById(R.id.country_previous);

        String [] countries = getResources().getStringArray(R.array.Countries);
        CheckBox [] dynamicCheckbox = new CheckBox[countries.length];

        LinearLayout relativeLayout = v.findViewById(R.id.checkbox_layout);

        next_country.setOnClickListener(this);
        previous_country.setOnClickListener(this);

        for(int i =0; i<countries.length;i++){
            CheckBox cb = new CheckBox(getActivity());
            cb.setText(countries[i]);
            dynamicCheckbox[i]=cb;
            relativeLayout.addView(cb);
            cb.setOnCheckedChangeListener(this);

        }
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.country_previous :
                startActivity(new Intent(getActivity(), ApplyActivity.class));
                break;
            case R.id.country_next :
                cahngeFragmnents(new JobFragment());
                break;

        }
    }

    public void cahngeFragmnents(Fragment fr) {
        getFragmentManager()
                .beginTransaction()
                .hide(new PersonFragment())
                .add(R.id.fragment_container, fr )
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String checkedText = compoundButton.getText()+ "";
        if(b){
            checkedCountries.add(checkedText);
            Toast.makeText(getActivity(), compoundButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", mCurCheckPosition);
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            mCurCheckPosition = savedInstanceState.getInt("curChoice", 0);

        }

    }
}