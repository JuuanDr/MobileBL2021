package com.example.week11_29177;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.week11_29177.Adapter.userAdapter;
import com.example.week11_29177.Model.user;
import com.example.week11_29177.Rest.ApiClient;
import com.example.week11_29177.Rest.ApiInterface;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    userAdapter mAdapter;
    ArrayList<user> mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIns = findViewById(R.id.btnInsert);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Not Available yet", Toast.LENGTH_LONG).show();
            }
        });
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        getData();
    }

    private void getData() {
        Call<ArrayList<user>> userCallBack = mApiInterface.getUser();
        userCallBack.enqueue(new Callback<ArrayList<user>>() {
            @Override
            public void onResponse (Call<ArrayList<user>> call, Response<ArrayList<user>> response) {
                    mUser = response.body();
                    Log.d("Retrofit Get", "Jumlah data User: " + String.valueOf(mUser.size()));
                    mAdapter = new userAdapter(mUser);
                    mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<ArrayList<user>> call, Throwable t) {
                Log.e("Retrofit Get Fail", t.toString());
            }
        });
    }
}