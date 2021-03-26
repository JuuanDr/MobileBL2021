package com.example.musicplayer.App;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.musicplayer.R;

import java.util.LinkedList;

public class DaftarMusicAdapter extends RecyclerView.Adapter<DaftarMusicAdapter.ItemMusicHolder> {
    private LinkedList<SumberMusic> mDaftarMusic;
    private LayoutInflater mInflater;
    private Context mCtx;

    public DaftarMusicAdapter(Context ctx, LinkedList<SumberMusic> daftarMusic){
        this.mCtx = ctx;
        this.mDaftarMusic = daftarMusic;
        this.mInflater = LayoutInflater.from(ctx);
    }
    @NonNull
    @Override
    public ItemMusicHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.music_item_layout, parent, false);
        return new ItemMusicHolder(view, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemMusicHolder holder, int position) {
        SumberMusic mSumberVideo = mDaftarMusic.get(position);
        holder.tvJudul.setText(mSumberVideo.getJudul());
    }

    @Override
    public int getItemCount() {
        return mDaftarMusic.size();
    }

    class ItemMusicHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvJudul;
        private DaftarMusicAdapter mAdapter;
        private int pos;
        private SumberMusic mSumberMusic;

        public ItemMusicHolder(@NonNull  View view, DaftarMusicAdapter adapter) {
            super(view);
            mAdapter = adapter;
            tvJudul = (TextView) view.findViewById(R.id.tvJudul);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            pos = getLayoutPosition();
            mSumberMusic = mDaftarMusic.get(pos);
            Intent playMusic = new Intent(mCtx, musicPlay.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("playMusic", mSumberMusic);
            playMusic.putExtras(bundle);
            mCtx.startActivity(playMusic);
        }
    }
}