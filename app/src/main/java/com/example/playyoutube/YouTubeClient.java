package com.example.playyoutube;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Créer une classe pour gérer la connexion à l'API
public class YouTubeClient {
    private static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    private static Retrofit retrofit = null;

    public static YouTubeService getService() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(YouTubeService.class);
    }
}
