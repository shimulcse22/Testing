package com.example.testing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.testing.Model;
import com.example.testing.R;

public class HolderActivity extends AppCompatActivity {

    TextView name,fathername,mothername,height,weight,presentadd,permanentadd;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_holder);
        Model model = getIntent().getParcelableExtra("model");

        LinearLayout layout1 = findViewById(R.id.linearCountry);
        LinearLayout layout2 = findViewById(R.id.linearJob);

        for(int i = 0;i<model.getCountry().size();i++){
            TextView tx = new TextView(this);
            tx.setText(model.getCountry().get(i));
            layout1.addView(tx);

        }

        for(int j = 0;j<model.getJob().size();j++){
            TextView txj = new TextView(this);
            txj.setText(model.getJob().get(j));
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


        imageView = findViewById(R.id.image11);



        name.setText(model.getName());
        fathername.setText(model.getFathername());
        mothername.setText(model.getMothername());
        height.setText(model.getHeight());
        weight.setText(model.getWeight());
        presentadd.setText(model.getPresentadreess());
        permanentadd.setText(model.getPermanentaddress());

        Uri myUri = Uri.parse(model.getIm1());
        imageView.setImageURI(myUri);


        Log.d("DDDDDDDDDafter", model.toString());
    }

}
