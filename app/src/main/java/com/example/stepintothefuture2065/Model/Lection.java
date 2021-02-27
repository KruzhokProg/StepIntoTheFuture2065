package com.example.stepintothefuture2065.Model;

import android.content.Intent;

public class Lection {

    private Integer id;
    private String title;
    private String info;
    private Integer image;

    public Lection() { }

    public Lection(Integer id, String title, String info, Integer image) {
        this.id = id;
        this.title = title;
        this.info = info;
        this.image = image;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
