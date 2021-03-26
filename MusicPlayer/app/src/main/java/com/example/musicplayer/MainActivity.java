package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.musicplayer.App.Login;
import com.example.musicplayer.App.Player;
import com.example.musicplayer.Profile.Profile;

public class MainActivity extends AppCompatActivity {
    Button btnLogin, btnProfile;
    ImageView ivIcon;

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
        this.finish();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnLogin = findViewById(R.id.btnLogin);
        btnProfile = findViewById(R.id.btnProfile);
        ivIcon = findViewById(R.id.ivIcon);

        ivIcon.setBackgroundResource(R.drawable.icon);
        btnProfile = findViewById(R.id.btnProfile);
        btnLogin = findViewById(R.id.btnLogin);


        btnProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToProfile = new Intent(MainActivity.this, Profile.class);
                startActivity(goToProfile);
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToApp = new Intent(MainActivity.this, Login.class);
                startActivity(goToApp);
            }
        });
    }
}