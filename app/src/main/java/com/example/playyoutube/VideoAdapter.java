package com.example.playyoutube;

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
                .load(video.getUrl())
                .into(holder.thumbnail);
    }

    @Override
    public int getItemCount() {
        return videoList.size();
    }
}
