package com.example.musicplayer.Profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.example.musicplayer.R;

public class Profile extends AppCompatActivity {
    ImageView ivBackArrow, ivProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ivBackArrow = findViewById(R.id.ivBackArrow);
        ivProfile = findViewById(R.id.ivProfile);

        ivBackArrow.setBackgroundResource(R.drawable.backarrow);
        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ivProfile.setBackgroundResource(R.drawable.profile);
    }
}