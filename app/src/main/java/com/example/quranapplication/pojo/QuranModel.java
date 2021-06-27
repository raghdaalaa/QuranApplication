package com.example.quranapplication.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.List;



public class QuranModel {

    @SerializedName("chapters")

    private List<Chapter> chapters ;

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

}