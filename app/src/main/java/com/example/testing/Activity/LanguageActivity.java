package com.example.testing.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.testing.R;
import com.example.testing.Shared;

import java.security.KeyStore;
import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {

    Button cahngelangEng,bangButton;
    Shared shared;

    String engname = "en";
    String bnname = "bn";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_language);

        cahngelangEng = findViewById(R.id.english);
        bangButton = findViewById(R.id.bangla);
        cahngelangEng.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale(engname);
                Intent i = new Intent(LanguageActivity.this, InformationActivity.class);
                startActivity(i);


            }
        });
        bangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setLocale(bnname);
                Intent i = new Intent(LanguageActivity.this, InformationActivity.class);
                startActivity(i);

            }
        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));
    }


    public boolean setLocale(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration conf = new Configuration();
        conf.locale = locale;
        getBaseContext().getResources()
                .updateConfiguration(conf,getBaseContext().getResources().getDisplayMetrics());
        shared.setDefaults("My_Lang",language,getApplicationContext());
//        SharedPreferences.Editor editor = getSharedPreferences("Settings",MODE_PRIVATE).edit();
//        editor.putString("My_Lang",language);
//        editor.apply();
        return true;
    }
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", MODE_PRIVATE);
        String language = prefs.getString("My_Lang","");
        setLocale(language);
    }

}
