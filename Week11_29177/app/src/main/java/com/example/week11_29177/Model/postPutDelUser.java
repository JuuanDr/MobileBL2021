package com.example.week11_29177.Model;

import com.google.gson.annotations.SerializedName;

public class postPutDelUser {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    user mUser;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public user getmUser() {
        return mUser;
    }
    public void setmUser(user mUser) {
        this.mUser = mUser;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
