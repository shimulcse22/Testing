package com.example.testing.Fragments;

import android.content.Context;
import android.net.IpPrefix;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
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
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.testing.Activity.ItemPageSelectListener;
import com.example.testing.Apis.RetrofitClient;
import com.example.testing.ModelClasses.JobModel;
import com.example.testing.ModelClasses.Model;
import com.example.testing.R;
import com.example.testing.Shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JobFragment extends Fragment implements View.OnClickListener {

    ArrayList<String> checkedJobs = new ArrayList<String>();
    ArrayList<Long> checkCodes = new ArrayList<Long>();
    Button next_job, previous_job;
    LinearLayout relativeLayout;
    Shared shared;
    String s;
    String t = "At Least Select One Service";
    Model model = Model.newInstance();

    ItemPageSelectListener listener;
    JobModel jm;

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

        try{
            Call<List<JobModel>> call = RetrofitClient.getInstance(getContext()).getApi().gettingJob();

            call.enqueue(new Callback<List<JobModel>>() {
                @RequiresApi(api = Build.VERSION_CODES.N)
                @Override
                public void onResponse(Call<List<JobModel>> call, Response<List<JobModel>> response) {

                    for(JobModel jm : response.body()){
                        CheckBox cb = new CheckBox(getActivity());
                        if(s == "bn") {
                            cb.setText((CharSequence) jm.getName_Bn());
                            cb.setId(Math.toIntExact(jm.getJobID()));

                        }
                        else{
                            cb.setText((CharSequence) jm.getName_En());
                            cb.setId(Math.toIntExact(jm.getJobID()));
                        };

                        relativeLayout.addView(cb);
                        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                            @Override
                            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                                String checkedText = compoundButton.getText()+ "";
                                Long checkedId = Long.valueOf(compoundButton.getId());
                                if(b){
                                    checkedJobs.add(checkedText);
                                    checkCodes.add(checkedId);
                                    Toast.makeText(getActivity(), compoundButton.getText(), Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    checkedJobs.remove(checkedText);
                                    checkCodes.remove(checkedId);
                                }
                            }
                        });
                    }
                }

                @Override
                public void onFailure(Call<List<JobModel>> call, Throwable t) {
                    Log.d("Fail",t.getMessage());
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }catch (IOException e){
            e.printStackTrace();
        }
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
            model.setJobsList(checkedJobs);
            model.setApplideJobsList(checkCodes);
            listener.onSelectNextItem();
        }
    }
}