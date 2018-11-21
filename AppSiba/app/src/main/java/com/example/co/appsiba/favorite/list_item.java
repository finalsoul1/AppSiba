package com.example.co.appsiba.favorite;

public class list_item {
    private int favorite_image;
    private String content;

    public int getFavorite_image() {
        return favorite_image;
    }

    public void setFavorite_image(int favorite_image) {
        this.favorite_image = favorite_image;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {

        this.content = content;
    }
    public list_item(int favorite_image, String content) {
        this.favorite_image = favorite_image;
        this.content = content;
    }
}