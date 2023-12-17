package com.example.playyoutube;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

// Créer la classe VideoAdapter
public class VideoAdapter extends RecyclerView.Adapter<ViewHolder> {
    List<ItemVideo> videoList;


    public VideoAdapter(List<ItemVideo> videoList) {
        this.videoList = videoList;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemVideo video = videoList.get(position);
        holder.title.setText(video.getTitle());

        // Load the thumbnail image with Glide
        Glide.with(holder.itemView.getContext())
                .load(video.getThumbnailUrl())
                .into(holder.thumbnail);

        holder.id.setText(video.getUrl());

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = view.getContext();
                Intent i = new Intent(context, VideoPlayerActivity.class);
                i.putExtra("VIDEO_URL", video.getUrl());
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
