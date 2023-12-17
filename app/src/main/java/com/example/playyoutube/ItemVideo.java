package com.example.playyoutube;

// Importer les packages nécessaires
import android.view.*;
import android.widget.*;
import androidx.recyclerview.widget.*;
import java.util.*;

// Créer la classe ItemVideo
public class ItemVideo {
    String title;
    String url;

    String thumbnailUrl;


    public ItemVideo(String title, String thumbnailUrl, String url) {
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }


    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
