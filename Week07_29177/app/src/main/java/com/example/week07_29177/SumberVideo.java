package com.example.week07_29177;

import java.io.Serializable;
import android.net.Uri;

public class SumberVideo implements Serializable {
    private String judul;
    private String keterangan;
    private String vidURI;

    public SumberVideo(String judul, String keterangan, String vidURI){
        this.judul = judul;
        this.keterangan = keterangan;
        this.vidURI = vidURI;
    }

    public void setJudul(String judul){
        this.judul = judul;
    }
    public void setKeterangan(String judul){
        this.keterangan = keterangan;
    }
    public void setVideoURI(String judul){
        this.vidURI = vidURI;
    }

    public String getJudul(){
        return this.judul;
    }
    public String getKeterangan(){
        return this.keterangan;
    }
    public String getVideoURI(){
        return this.vidURI;
    }
    public String toString(){
        return this.getJudul() + "=>" + this.getKeterangan();
    }
}
