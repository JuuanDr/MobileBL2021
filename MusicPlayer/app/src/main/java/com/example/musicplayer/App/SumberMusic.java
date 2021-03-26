package com.example.musicplayer.App;

import java.io.Serializable;

public class SumberMusic implements Serializable {
    private String judul;
    private String musicUri;

    public SumberMusic(String judul, String musicUri){
        this.judul = judul;
        this.musicUri = musicUri;
    }
    public void setJudul (String judul){
        this.judul = judul;
    }
    public void setMusicUri(String musicUri){
        this.musicUri = musicUri;
    }
    public String getJudul() {
        return this.judul;
    }
    public String getMusicUri(){
        return this.musicUri;
    }
}
