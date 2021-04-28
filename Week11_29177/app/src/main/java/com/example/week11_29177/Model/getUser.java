package com.example.week11_29177.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class getUser {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<user> listDataUser;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public List<user> getListDataUser() {
        return listDataUser;
    }
    public void setListDataUser(List<user> listDataUser) {
        this.listDataUser = listDataUser;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
