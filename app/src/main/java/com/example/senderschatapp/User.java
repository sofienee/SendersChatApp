package com.example.senderschatapp;

import android.net.Uri;

public class User {
    private String id;
    private String email;
    private String photo;
    private String nameUser;

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public User(String uid, String email, Uri photoUrl, String displayName) {
    }

    public User(String id, String email, String photo, String nameUser) {
        this.id = id;
        this.email = email;
        this.photo = photo;
        this.nameUser = nameUser;
    }
}
