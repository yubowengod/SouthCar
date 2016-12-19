package com.example.identity_pic.identity_pic_main;

import java.util.ArrayList;

/**
 * Created by GOD on 2016/10/19.
 */
public class identity_pic_main_java_ItemEntity {

    private ArrayList<String> leibie;

    private ArrayList<Integer> leibie_pic;

    public identity_pic_main_java_ItemEntity(ArrayList<String> leibie,ArrayList<Integer> leibie_pic) {
        super();
        this.leibie = leibie;
        this.leibie_pic = leibie_pic;
    }

    public ArrayList<Integer> getleibie_pic() {
        return leibie_pic;
    }

    public ArrayList<String> getleibie() {
        return leibie;
    }

    public void setleibie_pic(ArrayList<Integer> leibie_pic) {
        this.leibie_pic = leibie_pic;
    }

    public void setleibie(ArrayList<String> leibie) {
        this.leibie = leibie;
    }


    @Override
    public String toString() {
        return "ItemEntity [" + "leibie_pic=" + leibie_pic +"," +"leibie=" + leibie + "]";
    }
}
