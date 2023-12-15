package com.example.playyoutube;

import java.util.List;

public class PlaylistResponse {
    private List<Item> items;

    public List<Item> getItems() {
        return items;
    }

    public static class Item {
        private Snippet snippet;
        private ContentDetails contentDetails;

        public Snippet getSnippet() {
            return snippet;
        }

        public ContentDetails getContentDetails() {
            return contentDetails;
        }
    }

    public static class Snippet {
        private String title;
        private Thumbnails thumbnails;

        public String getTitle() {
            return title;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }
    }

    public static class ContentDetails {
        private String duration;

        public String getDuration() {
            return duration;
        }
    }

    public static class Thumbnails {
        private Thumbnail defaul;

        public Thumbnail getDefault() {
            return defaul;
        }
    }

    public static class Thumbnail {
        private String url;

        public String getUrl() {
            return url;
        }
    }
}