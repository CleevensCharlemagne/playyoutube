package com.example.playyoutube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dans votre activité ou fragment
        RecyclerView recyclerView = findViewById(R.id.rv_videos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // Ajouter des vidéos à videoList
        YouTubeService service = YouTubeClient.getService();
        Call<PlaylistResponse> call = service.getPlaylistVideos
                ("snippet,contentDetails",
                        50,
                        "PLClySGDbKZTTSDanXKN4RhhHoB5bEUcJz",
                        "AIzaSyC9a9nHYJWhgkhMqUEpTHvYNZwDnQ41QdE");
        call.enqueue(new Callback<PlaylistResponse>() {

            @Override
            public void onResponse(Call<PlaylistResponse> call, Response<PlaylistResponse> response) {
                if (response.isSuccessful()) {

                    if (response.body() == null) {
                        Log.d("DEBUG", "response.body() is null");
                        return;
                    }
                    List<ItemVideo> videoList = new ArrayList<>();
                    for (PlaylistResponse.Item item : response.body().getItems()) {
                        if (item.getSnippet().getThumbnails() != null) {
                            PlaylistResponse.Thumbnail thumbnail = null;

                            if (item.getSnippet().getThumbnails().getDefault() != null) {
                                thumbnail = item.getSnippet().getThumbnails().getDefault();
                            } else if (item.getSnippet().getThumbnails().getHigh() != null) {
                                thumbnail = item.getSnippet().getThumbnails().getHigh();
                            } else if (item.getSnippet().getThumbnails().getMedium() != null) {
                                thumbnail = item.getSnippet().getThumbnails().getMedium();
                            } else if (item.getSnippet().getThumbnails().getStandard() != null) {
                                thumbnail = item.getSnippet().getThumbnails().getStandard();
                            } else if (item.getSnippet().getThumbnails().getMaxres() != null) {
                                thumbnail = item.getSnippet().getThumbnails().getMaxres();
                            }

                            if (thumbnail != null && item.getSnippet().getTitle() != null && item.getSnippet().getResourceId() != null) {
                                String title = item.getSnippet().getTitle();
                                String thumbnailUrl = thumbnail.getUrl();
                                String videoId = item.getSnippet().getResourceId().getVideoId(); // Modifiez ceci

                                String url = videoId;
                                // Utilisez l'URL comme vous le souhaitez
                                videoList.add(new ItemVideo(title, thumbnailUrl, url));
                            }


                        }
                    }
                    if (!videoList.isEmpty()) {
                        recyclerView.setAdapter(new VideoAdapter(videoList));
                    } else {
                        Toast.makeText(MainActivity.this, "Video list is empty!!!", Toast.LENGTH_SHORT).show();

                    }
                }
            }

            @Override
            public void onFailure(Call<PlaylistResponse> call, Throwable t) {

                Toast.makeText(MainActivity.this, "Resonse Failure!!!", Toast.LENGTH_SHORT).show();
            }

        });


    }

}