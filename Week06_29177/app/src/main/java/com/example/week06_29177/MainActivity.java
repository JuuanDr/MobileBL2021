package com.example.week06_29177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import AnimasiDrawable.DrawableActivity;
import AnimasiFisika.FisikaActivity;
import AnimasiProperty.PropertyActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnToProperty, btnToDrawable, btnToFisika;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnToProperty = findViewById(R.id.btnToProperty);
        btnToDrawable = findViewById(R.id.btnToDrawable);
        btnToFisika = findViewById(R.id.btnToFisika);

        btnToProperty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProperty = new Intent(MainActivity.this, PropertyActivity.class);
                startActivity(toProperty);
            }
        });
        btnToDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProperty = new Intent(MainActivity.this, DrawableActivity.class);
                startActivity(toProperty);
            }
        });
        btnToFisika.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toProperty = new Intent(MainActivity.this, FisikaActivity.class);
                startActivity(toProperty);
            }
        });
    }
}