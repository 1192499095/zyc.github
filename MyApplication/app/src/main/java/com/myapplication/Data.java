package com.myapplication;

import java.io.Serializable;

public class Data implements Serializable {
    String text;
    int imagesrc;
    String fans;

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }


    public Data() {
    }

    public Data(String text, int imagesrc,String fans) {
        this.text = text;
        this.imagesrc = imagesrc;
        this.fans = fans;

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImagesrc() {
        return imagesrc;
    }

    public void setImagesrc(int imagesrc) {
        this.imagesrc = imagesrc;
    }
}
