package com.example.week11_29177;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.week11_29177.Adapter.userAdapter;
import com.example.week11_29177.Model.getUser;
import com.example.week11_29177.Model.user;
import com.example.week11_29177.Rest.ApiClient;
import com.example.week11_29177.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btnIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnIns = findViewById(R.id.btnInsert);
        btnIns.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, InsertActivity.class));
            }
        });
        mRecyclerView = findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        refresh();
    }

    private void refresh() {
        Call<getUser> userCall = mApiInterface.getUser();
        userCall.enqueue(new Callback<getUser>() {
            @Override
            public void onResponse(Call<getUser> call, Response<getUser> response) {
                    List<user> userList = response.body().getListDataUser();
                    Log.d("Retrofit Get", "Jumlah data User: " + String.valueOf(userList.size()));
                    mAdapter = new userAdapter(userList);
                    mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<getUser> call, Throwable t) {
                Log.e("Retrofit Get Fail", t.toString());
            }
        });
    }
}