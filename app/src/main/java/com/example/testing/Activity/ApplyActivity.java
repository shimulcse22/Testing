package com.example.testing.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testing.R;

public class ApplyActivity extends AppCompatActivity implements View.OnClickListener{

    private Button apply_buttton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply);

        apply_buttton = findViewById(R.id.applyButton);

        apply_buttton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.applyButton:

        }
    }
}
