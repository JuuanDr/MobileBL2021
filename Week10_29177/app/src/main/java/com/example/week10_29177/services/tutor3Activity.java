package com.example.week10_29177.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.week10_29177.R;

public class tutor3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor3);
        Intent servIntent = new Intent(this, SimpleIntentService.class);
        startService(servIntent);
    }
}