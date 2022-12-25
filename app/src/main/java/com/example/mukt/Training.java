package com.example.mukt;

public class Training {
    int id;
    String name;
    String org_name;
    int duration;
    int image;

    public Training(int id, String name, String org_name, int duration,int image) {
        this.id = id;
        this.name = name;
        this.org_name = org_name;
        this.duration = duration;
        this.image = image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getImage() {
        return image;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrg_name(String org_name) {
        this.org_name = org_name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOrg_name() {
        return org_name;
    }

    public int getDuration() {
        return duration;
    }


}
