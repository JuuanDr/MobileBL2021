package com.example.week03_29177;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class DaftarKataAdapter extends RecyclerView.Adapter<DaftarKataAdapter.KataViewHolder> {
    private final LinkedList<String> daftarKata;
    private LayoutInflater mInflater;

    DaftarKataAdapter(Context ctx, LinkedList<String> isiDaftarKata){
        mInflater = LayoutInflater.from(ctx);
        daftarKata = isiDaftarKata;
    }

    @NonNull
    @Override
    public DaftarKataAdapter.KataViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.daftarkata_item,parent,false);
        return new KataViewHolder(itemView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull DaftarKataAdapter.KataViewHolder holder, int position) {
        String now = daftarKata.get(position);
        holder.kataItemView.setText(now);
    }

    @Override
    public int getItemCount() {
        return daftarKata.size();
    }

    class KataViewHolder extends  RecyclerView.ViewHolder implements View.OnClickListener{
        public final TextView kataItemView;
        final DaftarKataAdapter mAdapter;

        public KataViewHolder(@NonNull View itemView, DaftarKataAdapter adapter){
            super(itemView);
            kataItemView = itemView.findViewById(R.id.kata);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int pos = getLayoutPosition();
            String kalimat = daftarKata.get(pos);
            daftarKata.set(pos, kalimat + " pernah ditekan ");
            mAdapter.notifyDataSetChanged();
            Toast.makeText(v.getContext(), "Kata " + pos + " dipilih", Toast.LENGTH_SHORT).show();

        }
    }
}
