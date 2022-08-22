package com.example.mukt;

import java.util.ArrayList;

public class Post_info {
    int like, share;
    String caption, imagelink, data, time, userid;
    ArrayList<String> tags;
    Float latitude, longitude;

    public Post_info(int like, int share, String caption, String imagelink, String data, String time,
                     String userid, ArrayList<String> tags, Float latitude, Float longitude) {
        this.like = like;
        this.share = share;
        this.caption = caption;
        this.imagelink = imagelink;
        this.data = data;
        this.time = time;
        this.userid = userid;
        this.tags = tags;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getImagelink() {
        return imagelink;
    }

    public void setImagelink(String imagelink) {
        this.imagelink = imagelink;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}


