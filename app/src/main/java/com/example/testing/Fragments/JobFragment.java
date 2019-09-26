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

public class JobFragment extends Fragment implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {

    ArrayList<String> checkedJobs = new ArrayList<String>();
    ArrayList<String> getCheckedJobs;
    Button next_job,previous_job;
    public static final String JOB_TAG = "job";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_job,container,false);

        next_job = v.findViewById(R.id.job_next);
        previous_job = v.findViewById(R.id.job_previous);

        String [] jobs = getResources().getStringArray(R.array.Jobs);
        CheckBox [] dynamicCheckbox = new CheckBox[jobs.length];

        LinearLayout relativeLayout = v.findViewById(R.id.checkbox_layout_job);
        next_job.setOnClickListener(this);
        previous_job.setOnClickListener(this);

        for(int i =0; i<jobs.length;i++){
            CheckBox cb = new CheckBox(getActivity());
            cb.setText(jobs[i]);
            dynamicCheckbox[i]=cb;
            relativeLayout.addView(cb);
            cb.setOnCheckedChangeListener(this);

        }
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.job_previous :
                changeBackFragmnent();
                break;
            case R.id.job_next :
                cahngeFragmnent();
                break;

        }

    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        String checkedText = compoundButton.getText()+ "";
        if(b){
            checkedJobs.add(checkedText);
            Toast.makeText(getActivity(), compoundButton.getText(), Toast.LENGTH_SHORT).show();
        }
    }

    public void cahngeFragmnent(){

        getFragmentManager()
                .beginTransaction()
                .hide(new JobFragment())
                .add(R.id.fragment_container, new PersonFragment())
                .addToBackStack(null)
                .commit();
    }
    public void changeBackFragmnent(){

        getFragmentManager()
                .beginTransaction()
                .hide(new JobFragment())
                .add(R.id.fragment_container, new CountryFragment())
                .addToBackStack(null)
                .commit();
    }
}
