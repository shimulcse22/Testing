package com.example.testing.Fragments;

import android.app.Activity;
import android.content.Context;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testing.Model;
import com.example.testing.R;

public class PersonFragment extends Fragment implements View.OnClickListener{
    private static final String NAME_KEY = "name";
    private static final String FATHER_KEY = "father";
    private static final String MOTHER_KEY = "mother";
    private static final String DATE_OF_BIRTH_KEY = "birth";
    private static final String AGE_KEY = "age";
    private static final String HEIGHT_KEY = "height";
    private static final String WEIGHT_KEY = "weight";
    private static final String PRESENT_KEY = "present";
    private static final String PERMANENT_KEY = "permanent";

    public static final String PERSON_TAG = "person";

    private EditText name,fatherName,motherName,age,dateOfBirth,height,weight,present,permanent;

    private Button previous_button,next_button;

    PersonInformation personInformation =null;

    Model model;

    public PersonFragment() {
        setArguments(new Bundle());
    }
    public interface PersonInformation{
        public void getPerSonInformation(Model model);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person,container,false);

        name = v.findViewById(R.id.editTextName);
        fatherName = v.findViewById(R.id.editTextFather);
        motherName = v.findViewById(R.id.editTextMother);
        dateOfBirth = v.findViewById(R.id.editTextBrith);
        age = v.findViewById(R.id.editTextAge);
        height = v.findViewById(R.id.editTextHeight);
        weight = v.findViewById(R.id.editTextWeight);
        present = v.findViewById(R.id.editTextPresent);
        permanent = v.findViewById(R.id.editTextPermanent);

        previous_button = v.findViewById(R.id.per_previous);
        next_button = v.findViewById(R.id.per_next);

        name.getText().toString();

        //Bundle mySavedInstanceState = getArguments();

        //String persistentVariable = mySavedInstanceState.getString(NAME_KEY);

        //name.setText(persistentVariable);



        next_button.setOnClickListener(this);
        previous_button.setOnClickListener(this);
        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            personInformation =(PersonInformation) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.per_next:
                changeFragmnent();
                break;
            case R.id.per_previous:
                changeBackFragmnent();
                break;
        }


    }
    public void changeFragmnent(){

        getFragmentManager()
                .beginTransaction()
                .hide(new PersonFragment())
                .add(R.id.fragment_container, new PassportFragment())
                .addToBackStack(null)
                .commit();
    }
    public void changeBackFragmnent(){

        getFragmentManager()
                .beginTransaction()
                .hide(new PersonFragment())
                .replace(R.id.fragment_container, new JobFragment())
                .addToBackStack(null)
                .commit();
    }

    //@Override
//    public void onPause() {
//        super.onPause();
//        String names = name.getText().toString();
//        String fathername = fatherName.getText().toString();
//        String mothername = motherName.getText().toString();
//        String dateofbirth = dateOfBirth.getText().toString();
//        String ages = age.getText().toString();
//        String heights = height.getText().toString();
//        String weghts = weight.getText().toString();
//        String presentaddress = present.getText().toString();
//        String permanentaddress = permanent.getText().toString();
//
//        getArguments().putString(NAME_KEY, names);
//        getArguments().putString(FATHER_KEY, fathername);
//        getArguments().putString(MOTHER_KEY, mothername);
//        getArguments().putString(DATE_OF_BIRTH_KEY, dateofbirth);
//        getArguments().putString(AGE_KEY, ages);
//        getArguments().putString(HEIGHT_KEY, heights);
//        getArguments().putString(WEIGHT_KEY, weghts);
//        getArguments().putString(PRESENT_KEY, presentaddress);
//        getArguments().putString(PERMANENT_KEY, permanentaddress);
//
//
//
//    }
}
