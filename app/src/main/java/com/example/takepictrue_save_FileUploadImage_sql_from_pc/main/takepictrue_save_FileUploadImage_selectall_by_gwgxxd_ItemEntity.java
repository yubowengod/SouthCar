package com.example.takepictrue_save_FileUploadImage_sql_from_pc.main;

/**
 * Created by GOD on 2016/9/27.
 */
public class takepictrue_save_FileUploadImage_selectall_by_gwgxxd_ItemEntity {
    private String avatar; // 头像URL
    private String title; // 名称
    private String content; // 数量
    private String chejian;

    public takepictrue_save_FileUploadImage_selectall_by_gwgxxd_ItemEntity(String avatar, String title, String content, String chejian) {
        super();
        this.avatar = avatar;
        this.title = title;
        this.content = content;
        this.chejian = chejian;
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

    public String getChejian() {
        return chejian;
    }

    public void setChejian(String chejian) {
        this.chejian = chejian;
    }

    @Override
    public String toString() {
        return "ItemEntity [" +
                "avatar=" + avatar + ", " +
                "title=" + title + ", " +
                "content=" + content + ", " +
                "chejian=" + chejian + ", " +
                "]";
    }

}