package com.example.week11_29177.Adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.week11_29177.EditActivity;
import com.example.week11_29177.Model.user;
import com.example.week11_29177.R;

import java.util.ArrayList;
import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder> {
    ArrayList<user> mUserList;

    public userAdapter(ArrayList<user> userList) {
        this.mUserList = userList;
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_list,parent,false);
        return new userViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        holder.mTextUserId.setText("User Id = " + mUserList.get(position).getUserId());
        holder.mTextId.setText("Id = " + mUserList.get(position).getId());
        holder.mTextTitle.setText("Tittle = " + mUserList.get(position).getTitle());
        holder.mTextBody.setText("Body = " + mUserList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public class userViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextUserId,mTextId,mTextTitle,mTextBody;

        public userViewHolder(View mView) {
            super(mView);
            mTextUserId = mView.findViewById(R.id.tvId);
            mTextId = mView.findViewById(R.id.tvId);
            mTextTitle = mView.findViewById(R.id.tvTitle);
            mTextBody = mView.findViewById(R.id.tvBody);
        }
    }
}
