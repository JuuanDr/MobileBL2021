package com.example.musicplayer.App;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.PopupWindow;
import android.view.ViewGroup.LayoutParams;
import android.widget.Toast;

import com.example.musicplayer.MainActivity;
import com.example.musicplayer.Profile.Profile;
import com.example.musicplayer.R;

import java.util.LinkedList;

public class Player extends AppCompatActivity {
    ImageView ivOption;
    Button closePopupWindow;
    PopupWindow popupWindow;
    LinearLayout playerLayout;
    RecyclerView rvDaftarMusic;
    DaftarMusicAdapter mAdapter;
    LinkedList<SumberMusic> daftarMusic = new LinkedList<>();
    public static final int REQCODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
        checkExtStorage();
        ivOption = findViewById(R.id.ivOption);

        ivOption.setBackgroundResource(R.drawable.option);
        ivOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu dropDownMenu = new PopupMenu(getApplicationContext(), ivOption);
                dropDownMenu.getMenuInflater().inflate(R.menu.drop_down_menu, dropDownMenu.getMenu());
                dropDownMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        if(menuItem.getTitle().equals("Profile")){
                            Intent goToProfile = new Intent(Player.this, Profile.class);
                            startActivity(goToProfile);
                        }
                        else{
                            Intent goLogout = new Intent(Player.this, MainActivity.class);
                            startActivity(goLogout);
                            finish();
                        }
                        return false;
                    }
                });
                dropDownMenu.show();
            }
        });

        isiDaftarMusic();

        rvDaftarMusic = (RecyclerView) findViewById(R.id.recyclerView);
        mAdapter = new DaftarMusicAdapter(this, daftarMusic);
        rvDaftarMusic.setAdapter(mAdapter);
        rvDaftarMusic.setLayoutManager(new LinearLayoutManager(this));
    }

    private void isiDaftarMusic() {
        ContentResolver musicResolver = this.getContentResolver();
        Uri musicUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String[] projection ={
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.DATA
        };
        Cursor musicCursor = musicResolver.query(musicUri, projection, null, null, null);
        if(musicCursor!=null){
            while(musicCursor.moveToNext()){
                String thisTitle = musicCursor.getString(0);
                String thisUri = musicCursor.getString(1);
                daftarMusic.add(new SumberMusic(thisTitle, thisUri));
            };
            musicCursor.close();
        }
    }
    private void checkExtStorage() {
        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
            Toast.makeText(getApplicationContext(),"External Storage not Available",Toast.LENGTH_SHORT).show();
        }
        if (ContextCompat.checkSelfPermission(Player.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(Player.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQCODE);
        }
    }
    private static boolean isExternalStorageReadOnly(){
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static boolean isExternalStorageAvailable(){
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public void onStart(){
        super.onStart();
        LayoutInflater layoutInflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_window,null);
        closePopupWindow = popupView.findViewById(R.id.closePopupWindow);
        playerLayout = findViewById(R.id.playerLayout);

        popupWindow = new PopupWindow(popupView, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, true);

        playerLayout.post(new Runnable() {
            @Override
            public void run() {
                popupWindow.showAtLocation(playerLayout, Gravity.CENTER,0,0);
            }
        });

        closePopupWindow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
    }
}