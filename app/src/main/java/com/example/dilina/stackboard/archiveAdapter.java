package com.example.dilina.stackboard;

/**
 * Created by Dilina on 10-Aug-17.
 */


import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.RequestManager;
import com.example.dilina.stackboard.archive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;

public class archiveAdapter extends RecyclerView.Adapter<archiveAdapter.ViewHolder> {

    private ArrayList<archive> values;

    archiveAdapter(ArrayList<archive> values) {
        this.values = values;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.archive_item,parent,false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(values.get(position).getName());
        holder.author.setText(values.get(position).getAuthor());
        holder.time.setText(values.get(position).getTimestamp());
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name,time,author;
        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.archiveName);
            time = (TextView) itemView.findViewById(R.id.archiveDate);
            author = (TextView) itemView.findViewById(R.id.archiveAuthor);
        }
    }
}