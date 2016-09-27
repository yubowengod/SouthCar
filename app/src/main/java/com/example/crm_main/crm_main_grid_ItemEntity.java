package com.example.crm_main;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/9/27.
 */

public class crm_main_grid_ItemEntity {

    private ArrayList<String> imageUrls; // 九宫格图片的URL集合

    public crm_main_grid_ItemEntity(ArrayList<String> imageUrls) {
        super();
        this.imageUrls = imageUrls;
    }

    public ArrayList<String> getImageUrls() {
        return imageUrls;
    }

    public void setImageUrls(ArrayList<String> imageUrls) {
        this.imageUrls = imageUrls;
    }


    @Override
    public String toString() {
        return "ItemEntity [" + "imageUrls=" + imageUrls + "]";
    }

}

