package com.example.testing.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testing.R;

public class PassportFragment extends Fragment implements View.OnClickListener {

    Button next_pass, previous_pass,skip_btn;
    public static final String PASSPORT_TAG = "passport";

    int mCurCheckPosition=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_passport, container, false);

        next_pass = v.findViewById(R.id.pass_next);
        previous_pass = v.findViewById(R.id.pass_previous);
        skip_btn = v.findViewById(R.id.skip);

        next_pass.setOnClickListener(this);
        previous_pass.setOnClickListener(this);
        skip_btn.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.pass_next:
                cahngeFragmnent();
                break;
            case R.id.pass_previous:
                cahngeBackFragmnent();
                break;
            case R.id.skip:
                cahngeFragmnent();
                break;
        }
    }


    public void cahngeFragmnent() {

        getFragmentManager()
                .beginTransaction()
                .hide(new PassportFragment())
                .add(R.id.fragment_container, new UploadFragment())
                .addToBackStack(null)
                .commit();
    }

    public void cahngeBackFragmnent() {

        getFragmentManager()
                .beginTransaction()
                .hide(new PassportFragment())
                .add(R.id.fragment_container, new JobFragment())
                .addToBackStack(null)
                .commit();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
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