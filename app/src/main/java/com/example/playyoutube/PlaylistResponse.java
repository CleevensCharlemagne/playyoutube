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
        private ResourceId resourceId;

        public String getTitle() {
            return title;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }

        public ResourceId getResourceId() { // Ajoutez ceci
            return resourceId;
        }
    }

    public static class ResourceId { // Ajoutez cette classe
        private String videoId;

        public String getVideoId() {
            return videoId;
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
        private Thumbnail high;
        private Thumbnail medium;
        private Thumbnail standard;
        private Thumbnail maxres;

        public Thumbnail getDefault() {
            return defaul;
        }

        public Thumbnail getHigh() {
            return high;
        }

        public Thumbnail getMedium() {
            return medium;
        }

        public Thumbnail getStandard() {
            return standard;
        }

        public Thumbnail getMaxres() {
            return maxres;
        }
    }

    public static class Thumbnail {
        private String url;

        public String getUrl() {
            return url;
        }
    }


}