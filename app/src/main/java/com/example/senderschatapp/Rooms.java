package com.example.senderschatapp;

public class Rooms {
    private String userid;
    private String sender;
    private String resiver;

    public String getUserid() {
        return userid;
    }

    public String getSender() {
        return sender;
    }

    public String getResiver() {
        return resiver;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setResiver(String resiver) {
        this.resiver = resiver;
    }

    public Rooms() {
    }

    public Rooms(String userid, String sender, String resiver) {
        this.userid = userid;
        this.sender = sender;
        this.resiver = resiver;
    }
}
