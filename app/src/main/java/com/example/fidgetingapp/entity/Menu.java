package com.example.fidgetingapp.entity;

import android.graphics.drawable.Drawable;

public class Menu {
    private String title;
    private Drawable avatar;

    public Menu() {
    }

    public Menu(String title, Drawable avatar) {
        this.title = title;
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Drawable getAvatar() {
        return avatar;
    }

    public void setAvatar(Drawable avatar) {
        this.avatar = avatar;
    }
}
