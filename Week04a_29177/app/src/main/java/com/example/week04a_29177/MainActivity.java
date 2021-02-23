package com.example.week04a_29177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvJawaban;
    private EditText etIsian, etUrl;
    private Button btnKirim, btnBrowse;

    @Override
    public void onActivityResult(int reqCode, int resCode, Intent data){
        super.onActivityResult(reqCode,resCode,data);
        if(reqCode == 1){
            if(resCode == RESULT_OK){
                String jawaban = data.getStringExtra("Jawaban");
                tvJawaban.setText(jawaban);
            }
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etIsian = findViewById(R.id.etIsian);
        etUrl = findViewById(R.id.etUrl);
        btnKirim = findViewById(R.id.btnKirim);
        btnBrowse = findViewById(R.id.btnBrowse);
        tvJawaban = findViewById(R.id.tvJawaban);

        btnKirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent kirimIntent = new Intent(MainActivity.this, SecondActivity.class);
                String isian = etIsian.getText().toString();
                kirimIntent.putExtra("PesanDariMain", isian);
                startActivityForResult(kirimIntent, 1);
            }
        });
        btnBrowse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String urlText = etUrl.getText().toString();
                if(urlText.isEmpty()){
                    urlText = "http://www.umn.ac.id";
                }
                Intent browseIntent = new Intent(Intent.ACTION_VIEW);
                browseIntent.setData(Uri.parse(urlText));
                if(browseIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(browseIntent);
                }
            }
        });
    }
}