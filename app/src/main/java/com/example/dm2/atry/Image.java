package com.example.dm2.atry;

import android.graphics.drawable.Drawable;

public class Image {

    Drawable img;
    int id;

    public Drawable getImg(){
        return img;
    }

    public int getId() {
        return id;
    }

    Image( Drawable iM , int iD ){
        img = iM;
        id = iD;
    }



}
