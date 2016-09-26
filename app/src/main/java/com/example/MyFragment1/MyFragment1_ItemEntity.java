package com.example.MyFragment1;

/**
 * Created by GOD on 2016/9/25.
 */
public class MyFragment1_ItemEntity {
    private String avatar; // 用户头像URL
    private String title; // 标题
    private String content; // 内容
    private String date; // 日期

    public MyFragment1_ItemEntity(String avatar, String title, String content,String date) {
        super();
        this.avatar = avatar;
        this.title = title;
        this.content = content;
        this.date = date;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "ItemEntity [" +
                "avatar=" + avatar + ", " +
                "title=" + title + ", " +
                "content=" + content + ", " +
                "date=" + date + ", " +
                 "]";
    }

}

