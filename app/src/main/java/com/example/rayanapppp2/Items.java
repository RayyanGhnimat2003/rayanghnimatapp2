package com.example.rayanapppp2;

public class Items {

    private String imageURL, userName;
    private int likes;

    public String getImageURL() {
        return imageURL;
    }

    public String getUserName() {
        return userName;
    }

    public int getLikes() {
        return likes;
    }

    public Items(String imageURL, String userName, int likes) {
        this.imageURL = imageURL;
        this.userName = userName;
        this.likes = likes;
    }
}
