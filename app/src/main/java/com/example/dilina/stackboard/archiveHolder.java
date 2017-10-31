package com.example.dilina.stackboard;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class archiveHolder extends RecyclerView.ViewHolder{

    private static final String TAG = archiveHolder.class.getSimpleName();

    public TextView titleTextView;
    public TextView authorTextView;
    public TextView timeTextView;


    public archiveHolder(View itemView) {
        super(itemView);
        titleTextView = itemView.findViewById(R.id.archiveName);
        authorTextView = itemView.findViewById(R.id.archiveAuthor);
        timeTextView = itemView.findViewById(R.id.archiveDate);
    }

}