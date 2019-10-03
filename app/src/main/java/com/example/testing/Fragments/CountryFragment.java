package com.example.testing.Fragments;

import android.content.Context;
import android.content.Intent;
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
import androidx.fragment.app.Fragment;

import com.example.testing.Activity.ItemPageSelectListener;
import com.example.testing.Activity.LanguageActivity;
import com.example.testing.Apis.RetrofitClient;
import com.example.testing.ModelClasses.CountryModel;
import com.example.testing.ModelClasses.Model;
import com.example.testing.R;
import com.example.testing.Shared;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryFragment extends Fragment implements View.OnClickListener {

    ArrayList<String> checkedCountries = new ArrayList<String>();

    Shared shared;
    String s,text;
    //LanguageActivity languageActivity = new LanguageActivity();

    Button next_country,previous_country;

    LinearLayout relativeLayout;

    Model model = Model.newInstance();

    ItemPageSelectListener listener;

    List<CountryModel> countryModels ;




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (ItemPageSelectListener) context;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_country,container,false);

        next_country = v.findViewById(R.id.country_next);
        previous_country = v.findViewById(R.id.country_previous);
        next_country.setOnClickListener(this);
        previous_country.setOnClickListener(this);

        relativeLayout = v.findViewById(R.id.checkbox_layout);

        s =shared.getDefaults("My_Lang",getContext());

        text = getResources().getString(R.string.error_box);
        /*getting the value*/
        Call<List<CountryModel>>  call = RetrofitClient.getInstance().getApi().getingCountry();

        call.enqueue(new Callback<List<CountryModel>>() {
            @Override
            public void onResponse(Call<List<CountryModel>> call, Response<List<CountryModel>> response) {

                //List<CountryModel> cM = response.body();
                for(CountryModel countryModel : response.body()){
                    CheckBox cb = new CheckBox(getActivity());
                    if(s == "bn") {
                        cb.setText((CharSequence) countryModel.getName_Bn());
                    }
                    else{
                        cb.setText((CharSequence) countryModel.getName_En());
                    }
                    relativeLayout.addView(cb);
                    cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                            String checkedText = compoundButton.getText()+ "";
                            if(b){
                                checkedCountries.add(checkedText);
                                Toast.makeText(getActivity(), compoundButton.getText(), Toast.LENGTH_SHORT).show();
                            }
                            else {
                                checkedCountries.remove(checkedText);
                            }
                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<List<CountryModel>> call, Throwable t) {
                    Log.d("Fail",t.getMessage());
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.country_previous :
                startActivity(new Intent(getActivity(), LanguageActivity.class));
                break;
            case R.id.country_next :
                checkCountry();
                break;

        }
    }

    public void checkCountry(){
        if(checkedCountries.isEmpty()){
            Toast.makeText(getActivity(),text, Toast.LENGTH_SHORT).show();
        }
        else {
            model.setExpectedCountryList(checkedCountries);
            listener.onSelectNextItem();
        }
    }

}