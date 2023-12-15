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
                "PLcN5mm9xUxrbOVCN9G9EMzlBOwvjS_heN",
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
                        String title = item.getSnippet().getTitle();
                        String url = item.getSnippet().getThumbnails().getDefault().getUrl();
                        if (title != null && url != null) {
                            videoList.add(new ItemVideo(title, url));
                        }
                    }
                    if (!videoList.isEmpty()) {
                        recyclerView.setAdapter(new VideoAdapter(videoList));
                    } else {
                        // Handle the case when the videoList is empty
                    }
                }
            }

            @Override
            public void onFailure(Call<PlaylistResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }

        });
    }

}