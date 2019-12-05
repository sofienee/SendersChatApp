package com.example.senderschatapp;

public class Message {
    private String sender;
    private String msg;
    private String urlImg;

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public Message() {
    }

    public Message(String sender, String msg, String urlImg) {
        this.sender = sender;
        this.msg = msg;
        this.urlImg = urlImg;
    }

    @Override
    public String toString() {
        return  sender ;

    }
}
