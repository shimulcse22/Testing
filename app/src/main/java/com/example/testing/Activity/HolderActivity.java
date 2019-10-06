package com.example.testing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;

import android.os.Bundle;


import android.util.Log;

import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;
import com.example.testing.Apis.RetrofitClient;
import com.example.testing.ModelClasses.Model;
import com.example.testing.ModelClasses.PassportModel;
import com.example.testing.ModelClasses.SubmitModel;
import com.example.testing.R;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HolderActivity extends AppCompatActivity {

    TextView name,fathername,mothername,height,weight,presentadd,permanentadd,country,job,date;

    Model model;
    Button button;




    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        model = getIntent().getParcelableExtra("model");
        country =findViewById(R.id.addCountry);
        job =findViewById(R.id.addJob);
        name = findViewById(R.id.addFistname);
        fathername = findViewById(R.id.addFatherName);
        mothername = findViewById(R.id.addMotherName);
        date = findViewById(R.id.dateBirth);
        height = findViewById(R.id.txtHeight);
        weight = findViewById(R.id.txtWeight);
        presentadd = findViewById(R.id.txtPerAdd);
        permanentadd = findViewById(R.id.txtPreAdd);

        button = findViewById(R.id.submit);
        for(int i = 0;i<model.getExpectedCountryList().size();i++){
            country.setText(" : "+model.getExpectedCountryList());

        }

        for(int j = 0;j<model.getJobsList().size();j++){
            job.setText(" : "+model.getJobsList());
        }

        name.setText(" : "+model.getFirstName()+" "+model.getLastName());
        fathername.setText(" : "+model.getFatherName());
        mothername.setText(" : "+model.getMotherName());
        date.setText(" : "+model.getDateOfBirth());
        height.setText(" : "+model.getHeight());
        weight.setText(" : "+model.getWeight());
        presentadd.setText(" : "+model.getPresentAddress());
        permanentadd.setText(" : "+model.getPermanentAddress());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
        //imageView = findViewById(R.id.image11);

//        imagePass = Uri.parse(model.getPassportSizePhoto());
//
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),imagePass);
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//                byte[] byteArray = outputStream.toByteArray();
//
//                //Use your Base64 String as you wish
//                encodedStringPassport = Base64.encodeToString(byteArray, Base64.DEFAULT);
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
//
//        imageFull = Uri.parse(model.getFullSizePhoto());
//
//            try {
//                bitmap2 = MediaStore.Images.Media.getBitmap(getContentResolver(),imageFull);
//                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//                bitmap2.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
//                byte[] byteArray = outputStream.toByteArray();
//
//                //Use your Base64 String as you wish
//                encodedStringFullSize = Base64.encodeToString(byteArray, Base64.DEFAULT);
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//            }




        Log.d("", model.toString());
    }


    public void registration() {
        SubmitModel sm = new SubmitModel();
        PassportModel pm = new PassportModel();

        pm.setDateOfExpiry(model.getDateexpire());
        pm.setIssueDate(model.getIssuedate());
        pm.setPassportNumber(model.getPassportno());
        pm.setProfessionAsPassport(model.getProfessionAsPassport());
        pm.setIssuePlace(model.getIssueplace());

        sm.setFirstName(model.getFirstName());
        sm.setLastName(model.getLastName());
        sm.setFatherName(model.getFatherName());
        sm.setMotherName(model.getMotherName());
        sm.setNationalIdNumber(model.getNationalIdNo());
        sm.setDateOfBirth(model.getDateOfBirth());
        sm.setPresentAddress(model.getPresentAddress());
        sm.setPermanentAddress(model.getPermanentAddress());
        sm.setPassportModel(pm);
        sm.setOrganizationId((long) 1);

        Double h = Double.parseDouble(model.getHeight());
        sm.setHeight(h);
        Double w = Double.parseDouble(model.getWeight());
        sm.setWeight(w);


        for (int i = 0; i < model.getExpectedCountryList().size(); i++) {
            sm.setExpectedCountryList(model.getExpectedCountryList());
        }
        for (int j = 0; j < model.getJobsList().size(); j++) {
            sm.setExpectedJobList(model.getApplideJobsList());
        }

        Log.d("FULL", sm.toString());
        //System.out.println(sm);
        try {
            Call<SubmitModel> call = RetrofitClient.getInstance(getApplicationContext()).getApi().userRegistration(sm);

            call.enqueue(new Callback<SubmitModel>() {
                @Override
                public void onResponse(Call<SubmitModel> call, Response<SubmitModel> response) {

                    if (!response.isSuccessful()) {
                        Toast.makeText(HolderActivity.this, String.valueOf(response.code()), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(HolderActivity.this, "Submitted Successfully", Toast.LENGTH_LONG).show();
                    }
                    Log.d("FULL2", String.valueOf(response.code()));
                }

                @Override
                public void onFailure(Call<SubmitModel> call, Throwable t) {
                    Toast.makeText(HolderActivity.this, t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                    Log.d("EROR", t.getLocalizedMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
