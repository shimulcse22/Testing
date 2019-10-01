package com.example.testing.Fragments;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testing.Activity.ApplyActivity;
import com.example.testing.Activity.ItemPageSelectListener;
import com.example.testing.Apis.RetrofitClient;
import com.example.testing.CountryModel;
import com.example.testing.JobModel;
import com.example.testing.Model;
import com.example.testing.R;
import com.example.testing.Shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobFragment extends Fragment implements View.OnClickListener {

    ArrayList<String> checkedJobs = new ArrayList<String>();
    Button next_job, previous_job;
    LinearLayout relativeLayout;
    Shared shared;
    String s;
    String t = "At Least Select One Service";
    Model model = Model.newInstance();

    ItemPageSelectListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ItemPageSelectListener) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_job, container, false);

        next_job = v.findViewById(R.id.job_next);
        previous_job = v.findViewById(R.id.job_previous);

        relativeLayout = v.findViewById(R.id.checkbox_layout_job);
        next_job.setOnClickListener(this);
        previous_job.setOnClickListener(this);
        s =shared.getDefaults("My_Lang",getContext());

        Call<List<JobModel>> call = RetrofitClient.getInstance().getApi().gettingJob();

        call.enqueue(new Callback<List<JobModel>>() {
            @Override
            public void onResponse(Call<List<JobModel>> call, Response<List<JobModel>> response) {

                for(JobModel jm : response.body()){
                    CheckBox cb = new CheckBox(getActivity());
                    if(s == "bn") {
                        cb.setText((CharSequence) jm.getName_Bn());
                    }
                    else{
                        cb.setText((CharSequence) jm.getName_En());
                    };
                    relativeLayout.addView(cb);
                    cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            String checkedText = compoundButton.getText()+ "";
                            if(b){
                                checkedJobs.add(checkedText);
                                Toast.makeText(getActivity(), compoundButton.getText(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                checkedJobs.remove(checkedText);
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<JobModel>> call, Throwable t) {
                Log.d("Fail",t.getMessage());
            }
        });
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.job_previous:
                listener.onSelectPreviousItem();
                break;
            case R.id.job_next:
                checkJobs();
                break;

        }

    }
    public void checkJobs(){
        if(checkedJobs.isEmpty()){
            Toast.makeText(getActivity(),"At Least Select One Service", Toast.LENGTH_SHORT).show();
        }
        else {
            model.setJob(checkedJobs);
            listener.onSelectNextItem();
        }
    }
}