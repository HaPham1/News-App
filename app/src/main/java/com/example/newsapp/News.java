package com.example.newsapp;

public class News {
    private int image, id;
    private String title, description;

    public News(int image, int id, String title, String description) {
        this.image = image;
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
