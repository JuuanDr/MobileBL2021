package com.example.week11_29177.Rest;


import com.example.week11_29177.Model.user;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("posts")
    Call<ArrayList<user>> getUser();
}
