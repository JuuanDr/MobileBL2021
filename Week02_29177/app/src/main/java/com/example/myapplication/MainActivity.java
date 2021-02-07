package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText etAngka1, etAngka2;
    TextView tvHasil, errMsg;
    Button btnTambah, btnKurang, btnKali, btnBagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etAngka1 = this.findViewById(R.id.etAngka1);
        etAngka2 = this.findViewById(R.id.etAngka2);
        tvHasil = this.findViewById(R.id.tvHasil);
        btnTambah = this.findViewById(R.id.operandTambah);
        btnKurang = this.findViewById(R.id.operandKurang);
        btnKali = this.findViewById(R.id.operandKali);
        btnBagi = this.findViewById(R.id.operandBagi);
        errMsg = this.findViewById(R.id.errorMessage);

        btnTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View tambah) {
                hitung( '+');
            }
        });
        btnKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View kurang) {
                hitung( '-');
            }
        });
        btnKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View kali) {
                hitung( '*');
            }
        });
        btnBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View bagi) {
                hitung('/');
            }
        });
    }

    protected void hitung(char operator){
        double hasil = 0.0;
        try {
            double angka1 = Double.parseDouble(etAngka1.getText().toString());
            double angka2 = Double.parseDouble(etAngka2.getText().toString());
            switch (operator) {
                case ('+'):
                    hasil = angka1 + angka2;
                    break;
                case ('-'):
                    hasil = angka1 - angka2;
                    break;
                case ('*'):
                    hasil = angka1 * angka2;
                    break;
                case ('/'):
                    hasil = angka1 / angka2;
            }
            errMsg.setText(String.valueOf(""));
        }
        catch (NumberFormatException ex){
            errMsg.setText(String.valueOf("Angka tidak boleh kosong"));
        }
        tvHasil.setText(String.valueOf(hasil));
    }
}