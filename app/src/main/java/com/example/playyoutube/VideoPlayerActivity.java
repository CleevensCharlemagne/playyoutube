package com.example.playyoutube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;


import com.pierfrancescosoffritti.youtubeplayer.player.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayer;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerInitListener;
import com.pierfrancescosoffritti.youtubeplayer.player.YouTubePlayerView;

public class VideoPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        YouTubePlayerView playerView = findViewById(R.id.player);
        playerView.initialize(new YouTubePlayerInitListener() {
            @Override
            public void onInitSuccess(@NonNull YouTubePlayer youTubePlayer) {
                youTubePlayer.addListener(new AbstractYouTubePlayerListener() {
                    @Override
                    public void onReady() {
                        // Obtenez l'intention qui a démarré cette activité
                        Intent intent = getIntent();

                        // Récupérez les données
                        String videoId = "";
                        if (intent.hasExtra("VIDEO_URL")) {
                            videoId = intent.getStringExtra("VIDEO_URL");
                        }

                        youTubePlayer.loadVideo(videoId, 0);
                    }
                });
            }

        }, true);


    }
}