package com.example.android.ayu_1202150288_modul3;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.DrawableRes;

public class Water {
    private final String title;
    private final String info;
    private final int imageResource;

    static final String TITLE_KEY = "Title";
    static final String IMAGE_KEY = "Image Resource";

    Water(String title, String info, int imageResource) {
        //ngambil nilai title, info dan image dari class ini
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
    }

    String getTitle() {

        return title;
    }
    String getInfo() {

        return info;
    }
    int getImageResource() {
        return imageResource;
    }

    static Intent starter(Context context, String title, @DrawableRes int imageResId) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(IMAGE_KEY, imageResId);
        return intent;
    }
}