package com.example.week11_29177.Rest;


import com.example.week11_29177.Model.getUser;
import com.example.week11_29177.Model.postPutDelUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HTTP;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface ApiInterface {
    @GET("/posts")
    Call<getUser> getUser();
    @FormUrlEncoded
    @POST("/posts")
    Call<postPutDelUser> postUser(
                                    @Field("userId") String userId,
                                    @Field("id") String id,
                                    @Field("title") String title,
                                    @Field("body") String body);
    @FormUrlEncoded
    @PUT("/posts")
    Call<postPutDelUser> putUser(
                                    @Field("userId") String userId,
                                    @Field("id") String id,
                                    @Field("title") String title,
                                    @Field("body") String body);
    @FormUrlEncoded
    @HTTP(method = "DELETE", path = "/posts", hasBody = true)
    Call<postPutDelUser> deleteUser(@Field("id") String id);
}
