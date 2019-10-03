package com.example.testing.Fragments;

import android.content.Context;

import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.testing.Activity.ItemPageSelectListener;
import com.example.testing.ModelClasses.Model;
import com.example.testing.R;
import java.util.Calendar;

public class PersonFragment extends Fragment implements View.OnClickListener {

    private EditText name, fatherName, motherName, dateOfBirth, height, weight, present, permanent;
    private Button previous_button, next_button;


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
        View v = inflater.inflate(R.layout.fragment_person, container, false);

        name = v.findViewById(R.id.editTextName);
        fatherName = v.findViewById(R.id.editTextFather);
        motherName = v.findViewById(R.id.editTextMother);
        dateOfBirth = v.findViewById(R.id.editTextBrith);
        height = v.findViewById(R.id.editTextHeight);
        weight = v.findViewById(R.id.editTextWeight);
        present = v.findViewById(R.id.editTextPresent);
        permanent = v.findViewById(R.id.editTextPermanent);

        previous_button = v.findViewById(R.id.per_previous);
        next_button = v.findViewById(R.id.per_next);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                model.setFirstName(name.getText().toString().trim());
            }
        });
        fatherName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                model.setFatherName(fatherName.getText().toString().trim());
            }
        });
        motherName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                model.setMotherName(motherName.getText().toString().trim());
            }
        });

        dateOfBirth.addTextChangedListener(new TextWatcher() {
            private String current = "";
            private String ddmmyyyy = "DDMMYYYY";
            private Calendar cal = Calendar.getInstance();

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int j, int i1, int i2) {
                if (!s.toString().equals(current)) {
                    String clean = s.toString().replaceAll("[^\\d.]|\\.", "");
                    String cleanC = current.replaceAll("[^\\d.]|\\.", "");

                    int cl = clean.length();
                    int sel = cl;
                    for (int i = 2; i <= cl && i < 6; i += 2) {
                        sel++;
                    }

                    if (clean.equals(cleanC)) sel--;

                    if (clean.length() < 8) {
                        clean = clean + ddmmyyyy.substring(clean.length());
                    } else {

                        int day = Integer.parseInt(clean.substring(0, 2));
                        int mon = Integer.parseInt(clean.substring(2, 4));
                        int year = Integer.parseInt(clean.substring(4, 8));

                        mon = mon < 1 ? 1 : mon > 12 ? 12 : mon;
                        cal.set(Calendar.MONTH, mon - 1);
                        year = (year < 1900) ? 1900 : (year > 2100) ? 2100 : year;
                        cal.set(Calendar.YEAR, year);

                        day = (day > cal.getActualMaximum(Calendar.DATE)) ? cal.getActualMaximum(Calendar.DATE) : day;
                        clean = String.format("%02d%02d%02d", day, mon, year);
                    }

                    clean = String.format("%s/%s/%s", clean.substring(0, 2),
                            clean.substring(2, 4),
                            clean.substring(4, 8));

                    sel = sel < 0 ? 0 : sel;
                    current = clean;
                    dateOfBirth.setText(current);
                    dateOfBirth.setSelection(sel < current.length() ? sel : current.length());
                    model.setDateOfBirth(dateOfBirth.getText().toString());
                }
            }


            @Override
            public void afterTextChanged(Editable editable) {
                model.setDateOfBirth(dateOfBirth.getText().toString());
            }
        });

        height.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                model.setHeight(height.getText().toString().trim());
            }
        });
        weight.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                model.setWeight(weight.getText().toString().trim());
            }
        });
        present.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                model.setPresentAddress(present.getText().toString().trim());
            }
        });
        permanent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                model.setPermanentAddress(permanent.getText().toString().trim());
            }
        });

        next_button.setOnClickListener(this);
        previous_button.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.per_next:
                checkPerson();
                break;
            case R.id.per_previous:
                listener.onSelectPreviousItem();
                break;
        }
    }

    public void checkPerson(){
        String names = name.getText().toString().trim();
        String father = fatherName.getText().toString().trim();
        String mother = motherName.getText().toString().trim();
        String date = dateOfBirth.getText().toString().trim();
        String heights = height.getText().toString().trim();
        String weights = weight.getText().toString().trim();
        String presents = present.getText().toString().trim();
        String permanents = permanent.getText().toString().trim();

        if (names.isEmpty()) {
            name.setError(getResources().getString(R.string.error_name));
            name.requestFocus();
            return;
        }
        if (father.isEmpty()) {
            fatherName.setError(getResources().getString(R.string.error_father));
            fatherName.requestFocus();
            return;
        }
        if (mother.isEmpty()) {
            motherName.setError(getResources().getString(R.string.error_mother));
            motherName.requestFocus();
            return;
        }
        if (date.isEmpty()) {
            dateOfBirth.setError(getResources().getString(R.string.error_birth));
            dateOfBirth.requestFocus();
        }
        if (heights.isEmpty()) {
            height.setError(getResources().getString(R.string.error_height));
            height.requestFocus();
            return;
        }
        if (weights.isEmpty()) {
            weight.setError(getResources().getString(R.string.error_weight));
            weight.requestFocus();
            return;
        }
        if (presents.isEmpty()) {
            present.setError(getResources().getString(R.string.error_pre_add));
            present.requestFocus();
            return;
        }

        if (permanents.isEmpty()) {
            permanent.setError(getResources().getString(R.string.error_pre_add));
            permanent.requestFocus();
            return;
        }

        listener.onSelectNextItem();

    }
}