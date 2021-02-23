package com.example.week04c_29177;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {
    EditText etTulisan = findViewById(R.id.etFrag1Tulisan);
    Button btnGanti = findViewById(R.id.btnFrag1Ganti);
    TextView tvTulisan = findViewById(R.id.tvFrag2Tulisan);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        FragmentManager fragMan = getSupportFragmentManager();
        FragmentTransaction fragTran = fragMan.beginTransaction();

        Fragment firstFrag = new FirstFragment();
        fragTran.replace(R.id.Frag1, firstFrag);

        Fragment secFrag = new SecondFragment();
        fragTran.replace(R.id.Frag2, secFrag);
        fragTran.commit();
    }
}