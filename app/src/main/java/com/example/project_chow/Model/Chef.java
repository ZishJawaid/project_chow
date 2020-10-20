package com.example.project_chow.Model;

import android.media.Image;

public class Chef {
    private String Name, Image, Description, MenuId, Rating, Distance, Time;
    public Chef() {
    }
    public Chef(String name, String image, String description, String menuId, String rating, String distance, String time) {
        Name = name;
        Image = image;
        Description = description;
        MenuId = menuId;
        Rating = rating;
        Distance = distance;
        Time = time;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getImage() {
        return Image;
    }
    public void setImage(String image) {
        Image = image;
    }
    public String getDescription() {
        return Description;
    }
    public void setDescription(String description) {
        Description = description;
    }
    public String getMenuId() {
        return MenuId;
    }
    public void setMenuId(String menuId) {
        MenuId = menuId;
    }

    public String getRating() {
        return Rating;
    }

    public void setRating(String rating) {
        Rating = rating;
    }

    public String getDistance() {
        return Distance;
    }

    public void setDistance(String distance) {
        Distance = distance;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }
}