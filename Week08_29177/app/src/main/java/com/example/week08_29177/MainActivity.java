package com.example.week08_29177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.week08_29177.tutor1.tutor1Activity;
import com.example.week08_29177.tutor2.tutor2Activity;
import com.example.week08_29177.tutor3.tutor3Activity;

public class MainActivity extends AppCompatActivity {
    Button btnTutor1, btnTutor2, btnTutor3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTutor1 = findViewById(R.id.btnTutor1);
        btnTutor2 = findViewById(R.id.btnTutor2);
        btnTutor3 = findViewById(R.id.btnTutor3);

        btnTutor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tutor1Activity.class));
            }
        });
        btnTutor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tutor2Activity.class));
            }
        });
        btnTutor3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, tutor3Activity.class));
            }
        });
    }
}