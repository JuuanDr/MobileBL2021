package com.example.musicplayer.App;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.musicplayer.R;

public class Login extends AppCompatActivity {
    ImageView ivBackArrow, ivIcon;
    EditText etUsername, etPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ivBackArrow = findViewById(R.id.ivBackArrow);
        ivIcon = findViewById(R.id.ivIcon);
        etUsername = findViewById(R.id.etUsername);
        etPass = findViewById(R.id.etPass);
        btnLogin = findViewById(R.id.btnLogin);

        ivBackArrow.setBackgroundResource(R.drawable.backarrow);
        ivIcon.setBackgroundResource(R.drawable.icon);

        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String username = etUsername.getText().toString();
               String password = etPass.getText().toString();
               String accUsername = "uasmobile";
               String accPass = "uasmobilegenap";
               if(accUsername.equals(username) && accPass.equals(password)){
                   Intent goToPlayer = new Intent(Login.this, Player.class);
                   startActivity(goToPlayer);
                   finish();
               }
               else if(username.isEmpty() || password.isEmpty()){
                   Toast.makeText(getApplicationContext(),"Username and Password must NOT empty",Toast.LENGTH_SHORT).show();
               }
               else{
                   Toast.makeText(getApplicationContext(),"Invalid Username and Password",Toast.LENGTH_SHORT).show();
               }
               etUsername.setText("");
               etPass.setText("");
            }
        });
    }
}