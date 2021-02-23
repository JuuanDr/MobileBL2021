package com.example.week04a_29177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    private TextView tvDiterima;
    private EditText etJawaban;
    private Button btnBalas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvDiterima = findViewById(R.id.tvDiterima);
        etJawaban = findViewById(R.id.etJawaban);
        btnBalas = findViewById(R.id.btnBalas);

        Intent intentTerima = new Intent(getIntent());
        String pesanTerima = intentTerima.getStringExtra("PesanDariMain");
        tvDiterima.setText(pesanTerima);
    }

    public void kirimBalik(View view) {
        String jawaban = etJawaban.getText().toString();
        Intent intentBalas = new Intent();
        intentBalas.putExtra("Jawaban", jawaban);
        setResult(RESULT_OK, intentBalas);
        finish();
    }
}