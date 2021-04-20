package com.example.week10_29177.services;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.week10_29177.R;

public class tutor4Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor4);
        Intent servIntent = new Intent(this, SimpleIntentService.class);
        startService(servIntent);
        Button btnStartService = findViewById(R.id.button_startservice);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tutor4Activity.this, CustomService.class);
                startService(intent);
            }
        });
    }
}