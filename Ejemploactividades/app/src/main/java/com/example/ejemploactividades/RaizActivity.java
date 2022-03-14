package com.example.ejemploactividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class RaizActivity extends AppCompatActivity {
private TextView mRaizTextview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiz);
        Intent intent = getIntent();
        String raiz = intent.getStringExtra(SumaActivity.STATE_SUM_OUTPUT);
        mRaizTextview = findViewById(R.id.raiz_TextView);
        mRaizTextview.setText(raiz);



    }
}