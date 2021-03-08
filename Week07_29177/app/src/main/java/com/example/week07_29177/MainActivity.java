package com.example.week07_29177;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private Button btnPic, btnVid;
    private ImageView viewPic;
    private VideoView viewVid;

    static final int Req_Image_Capture = 1;
    static final int Req_Video_Capture = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnPic = findViewById(R.id.btnCapturePic);
        btnVid = findViewById(R.id.btnCaptureVid);
        viewPic = findViewById(R.id.picView);
        viewVid = findViewById(R.id.vidView);

        MediaController medCon = new MediaController(this);
        medCon.setMediaPlayer(viewVid);
        viewVid.setMediaController(medCon);

        btnPic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePicIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePicIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takePicIntent, Req_Image_Capture);
                }
            }
        });

        btnVid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takeVidIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
                if(takeVidIntent.resolveActivity(getPackageManager()) != null){
                    startActivityForResult(takeVidIntent, Req_Video_Capture);
                }
            }
        });
    }

    protected void onActivityResult(int reqCode, int resCode, Intent data) {
        super.onActivityResult(reqCode, resCode, data);
        if (reqCode == Req_Image_Capture && resCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap picBitmap = (Bitmap) extras.get("data");
            viewPic.setImageBitmap(picBitmap);
        } else if (reqCode == Req_Video_Capture && resCode == RESULT_OK) {
            Uri uri = data.getData();
            viewVid.setVideoURI(uri);
            viewVid.seekTo(100);
            viewVid.requestFocus();
            viewVid.start();
        }
    }
}