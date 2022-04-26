package com.example.newsapp;

public class Stories {
    private int image,position;

    public Stories(int image, int position) {
        this.image = image;
        this.position = position;
    }

    public int getImage() {
        return image;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setImage(int image) {
        this.image = image;
    }


}
