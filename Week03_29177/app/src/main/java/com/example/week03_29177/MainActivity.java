package com.example.week03_29177;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

import java.util.LinkedList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private final LinkedList<String> mainDaftarKata = new LinkedList<>();
    private RecyclerView mainRecyclerView;
    private DaftarKataAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int jumlahKata = mainDaftarKata.size();
                mainDaftarKata.addLast("Kata " + jumlahKata + " telah ditambahkan");
                Objects.requireNonNull(mainRecyclerView.getAdapter()).notifyItemInserted(jumlahKata);
                mainRecyclerView.smoothScrollToPosition(jumlahKata);
            }
        });
        //Menyiapkan konten
        for(int i = 0; i < 21; i++){
            mainDaftarKata.add("Kata " + i);
        }

        mainRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        mainAdapter = new DaftarKataAdapter(this, mainDaftarKata);
        mainRecyclerView.setAdapter(mainAdapter);
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}