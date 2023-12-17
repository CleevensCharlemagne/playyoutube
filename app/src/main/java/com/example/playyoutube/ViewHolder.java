package com.example.playyoutube;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {
    TextView title;
    ImageView thumbnail;

    LinearLayout container;

    TextView id;

    public ViewHolder(View itemView) {
        super(itemView);
        title = itemView.findViewById(R.id.title);
        thumbnail = itemView.findViewById(R.id.thumbnail);
        container = itemView.findViewById(R.id.container);
        id = itemView.findViewById(R.id.id);
    }
}
