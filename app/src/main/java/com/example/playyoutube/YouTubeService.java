package com.example.playyoutube;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YouTubeService {
    @GET("playlistItems")
    Call<PlaylistResponse> getPlaylistVideos
            (@Query("part") String part,
             @Query("maxResults") int maxResults,
             @Query("playlistId") String playlistId,
             @Query("key") String key);
}
