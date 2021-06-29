package com.example.quranapplication.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Chapter implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("chapter_number")
    private Integer chapterNumber;
    @SerializedName("name_arabic")
    private String nameArabic;
    @SerializedName("name_simple")
    private String nameSimple;
    @SerializedName("verses_count")
    private Integer versesCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChapterNumber() {
        return chapterNumber;
    }

    public void setChapterNumber(Integer chapterNumber) {
        this.chapterNumber = chapterNumber;
    }

    public String getNameArabic() {
        return nameArabic;
    }

    public void setNameArabic(String nameArabic) {
        this.nameArabic = nameArabic;
    }

    public String getNameSimple() {
        return nameSimple;
    }

    public void setNameSimple(String nameSimple) {
        this.nameSimple = nameSimple;
    }

    public Integer getVersesCount() {
        return versesCount;
    }

    public void setVersesCount(Integer versesCount) {
        this.versesCount = versesCount;
    }

}