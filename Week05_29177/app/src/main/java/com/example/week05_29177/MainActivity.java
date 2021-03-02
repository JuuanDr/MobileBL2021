package com.example.week05_29177;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    private SeekBar sbRed, sbGreen, sbBlue;
    private RadioGroup rgShape;
    private RadioButton rbPick;
    private ImageButton ibColor;

    private CustomView custView;
    private int red = 0;
    private int green = 0;
    private int blue = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sbRed = findViewById(R.id.sbRed);
        sbGreen = findViewById(R.id.sbGreen);
        sbBlue = findViewById(R.id.sbBlue);
        rgShape = findViewById(R.id.rgShape);
        ibColor = findViewById(R.id.ibColor);
        custView = findViewById(R.id.custView);
        custView = new CustomView(this);

        rgShape.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkId) {
                int intRG = rgShape.getCheckedRadioButtonId();
                rbPick = findViewById(intRG);
                String shape = rbPick.getText().toString();
                custView.changeShape(shape);
            }
        });

        sbRed.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                red = sbRed.getProgress();
                custView.changeColor(red, green, blue);
                ibColor.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
        sbGreen.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                green = sbGreen.getProgress();
                custView.changeColor(red, green, blue);
                ibColor.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
        sbBlue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                blue = sbBlue.getProgress();
                custView.changeColor(red, green, blue);
                ibColor.setBackgroundColor(Color.rgb(red,green,blue));
            }
        });
    }
}