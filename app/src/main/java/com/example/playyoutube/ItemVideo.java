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

    // Constructeur
    public ItemVideo(String title, String url) {
        this.title = title;
        this.url = url;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }
}
