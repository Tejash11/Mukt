package com.example.mukt;

import android.graphics.Color;
import android.graphics.drawable.Drawable;

public class JobClass1 {

    int image;
    String name;
    int back;
    int color;
    int colorTrans;
    int arrow;

    public JobClass1(int image,String  name,int back,int arrow,int color,int colorTrans){
        this.back = back;
        this.image = image;
        this.name = name;
        this.arrow = arrow;
        this.color = color;
        this.colorTrans = colorTrans;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setColorTrans(int colorTrans) {
        this.colorTrans = colorTrans;
    }

    public int getColor() {
        return color;
    }

    public int getColorTrans() {
        return colorTrans;
    }

    public void setBackColor(int backColor) {
        this.color = backColor;
    }

    public int getBackColor() {
        return color;
    }

    public int getArrow() {
        return arrow;
    }

    public void setArrow(int arrow) {
        this.arrow = arrow;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBack(int back) {
        this.back = back;
    }


    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public int getBack() {
        return back;
    }

}
