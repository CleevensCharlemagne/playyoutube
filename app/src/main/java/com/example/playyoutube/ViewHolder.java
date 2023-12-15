package com.example.playyoutube;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

// Créer la classe VideoViewHolder
public class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView thumbnail;

    public ViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        thumbnail = itemView.findViewById(R.id.thumbnail);
    }
}
