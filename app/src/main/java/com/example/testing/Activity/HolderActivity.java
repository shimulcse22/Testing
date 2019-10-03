package com.example.testing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import android.util.Log;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.testing.Apis.RetrofitClient;
import com.example.testing.ModelClasses.Model;
import com.example.testing.ModelClasses.PassportModel;
import com.example.testing.ModelClasses.SubmitModel;
import com.example.testing.R;
import java.util.Date;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class HolderActivity extends AppCompatActivity {

    TextView name,fathername,mothername,height,weight,presentadd,permanentadd;
    ImageView imageView;
    Model model;
    Button button;
    Uri myUri;
    Date DateOfBirth=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        model = getIntent().getParcelableExtra("model");

        LinearLayout layout1 = findViewById(R.id.linearCountry);
        LinearLayout layout2 = findViewById(R.id.linearJob);

        for(int i = 0;i<model.getExpectedCountryList().size();i++){
            TextView tx = new TextView(this);
            tx.setText("You Select This : "+model.getExpectedCountryList().get(i));
            layout1.addView(tx);

        }

        for(int j = 0;j<model.getJobsList().size();j++){
            TextView txj = new TextView(this);
            txj.setText("You Select this : "+model.getApplideJobsList().get(j));
            layout2.addView(txj);

        }
        name = findViewById(R.id.txtname);
        fathername = findViewById(R.id.txtfathername);
        mothername = findViewById(R.id.txtmothername);
        height = findViewById(R.id.txtheight);
        weight = findViewById(R.id.txtweihght);
        presentadd = findViewById(R.id.txtpresent);
        permanentadd = findViewById(R.id.txtpermanentadd);
        permanentadd = findViewById(R.id.txtpermanentadd);
        permanentadd = findViewById(R.id.txtpermanentadd);
        button = findViewById(R.id.btnSubmit);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registration();
            }
        });
        //imageView = findViewById(R.id.image11);
        name.setText(getResources().getString(R.string.name)+" : "+model.getFirstName());
        fathername.setText(model.getFatherName());
        mothername.setText(model.getMotherName());
        height.setText(model.getHeight());
        weight.setText(model.getWeight());
        presentadd.setText(model.getPresentAddress());
        permanentadd.setText(model.getPermanentAddress());

        myUri = Uri.parse(model.getPassportSizePhoto());
        Log.d("DDDDDDDDDafter", model.toString());
    }


    public void registration(){
        SubmitModel sm = new SubmitModel();
        PassportModel pm= new PassportModel();

        pm.setDateOfExpiry(null);
        pm.setIssueDate(null);
        pm.setPassportNumber(10863558);
        pm.setProfessionAsPassport("Doctor");
        pm.setIssuePlace("Dhaka");

        sm.setFirstName(model.getFirstName());
        sm.setLastName("shimul");
        sm.setFatherName(model.getFatherName());
        sm.setMotherName(model.getMotherName());
        //       SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
//        try {
//            DateOfBirth = format.parse(model.getDateOfBirth());
//            System.out.println(DateOfBirth);
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
        sm.setNationalIdNumber("10101");
        sm.setPresentAddress(model.getPresentAddress());
        sm.setPermanentAddress(model.getPermanentAddress());
        Double h = Double.parseDouble(model.getHeight());
        sm.setHeight(h);
        Double w = Double.parseDouble(model.getWeight());
        sm.setWeight(w);



        for(int i= 0;i<model.getExpectedCountryList().size();i++){
            sm.setExpectedCountryList(model.getExpectedCountryList());
        }


        Log.d("FULL", sm.toString());
        System.out.println(sm);
        Call<SubmitModel> call = RetrofitClient.getInstance().getApi().userRegistration(sm);

        call.enqueue(new Callback<SubmitModel>() {
            @Override
            public void onResponse(Call<SubmitModel> call, Response<SubmitModel> response) {

                if(!response.isSuccessful()){
                    Toast.makeText(HolderActivity.this,String.valueOf(response.code()),Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(HolderActivity.this,"Submitted Successfully",Toast.LENGTH_LONG).show();
                }
                Log.d("FULL2", String.valueOf(response.code()));
            }

            @Override
            public void onFailure(Call<SubmitModel> call, Throwable t) {
                Toast.makeText(HolderActivity.this,t.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                Log.d("EROR",t.getLocalizedMessage());
            }
        });
    }


}
