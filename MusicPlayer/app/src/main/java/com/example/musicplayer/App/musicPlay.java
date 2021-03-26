package com.example.musicplayer.App;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.musicplayer.R;

import java.io.IOException;
import java.util.LinkedList;

public class musicPlay extends AppCompatActivity {
    ImageView ivBackArrow,ivIcon, ivPlayPause, ivPrev, ivNext;
    TextView tvJudul;
    SeekBar seekBar;
    Uri musicUri;
    static MediaPlayer mediaPlayer;
    private Handler handler = new Handler();
    private int toogle = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_play);
        ivBackArrow = findViewById(R.id.ivBackArrow);
        ivIcon = findViewById(R.id.ivIcon);
        ivPlayPause = findViewById(R.id.ivPlayPause);
        seekBar = findViewById(R.id.seekBar);
        tvJudul = findViewById(R.id.tvJudul);

        ivBackArrow.setBackgroundResource(R.drawable.backarrow);
        ivIcon.setBackgroundResource(R.drawable.icon);
        ivPlayPause.setBackgroundResource(R.drawable.playerplay);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        SumberMusic sm = (SumberMusic) bundle.getSerializable("playMusic");
        tvJudul.setText(sm.getJudul());
        musicUri = Uri.parse(sm.getMusicUri());
        mediaPlayer = MediaPlayer.create(getApplicationContext(), musicUri);
        seekBar.setMax(mediaPlayer.getDuration() / 1000);

        ivBackArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        ivPlayPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(toogle == 0){
                    ivPlayPause.setBackgroundResource(R.drawable.playerpause);
                    toogle = 1;
                    mediaPlayer.start();
                }
                else {
                    ivPlayPause.setBackgroundResource(R.drawable.playerplay);
                    toogle = 0;
                    mediaPlayer.pause();
                }
            }
        });


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(mediaPlayer != null && fromUser)
                    mediaPlayer.seekTo(progress * 1000);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        musicPlay.this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if(mediaPlayer!=null){
                    int mCurrentPosition = mediaPlayer.getCurrentPosition() / 1000;
                    seekBar.setProgress(mCurrentPosition);
                }
                handler.postDelayed(this, 1000);
            }
        });
    }
}