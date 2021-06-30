package com.example.quranapplication.pojo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Chapter implements Serializable {

    @SerializedName("id")
    private Integer id;
    @SerializedName("chapter_number")
    private Integer chapterNumber;
    @SerializedName("bismillah_pre")
    private Boolean bismillahPre;
    @SerializedName("revelation_place")
    private String revelationPlace;
    @SerializedName("name_arabic")

    private String nameArabic;
    @SerializedName("verses_count")

    private Integer versesCount;
    @SerializedName("translated_name")

    private TranslatedName translatedName;

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

    public Boolean getBismillahPre() {
        return bismillahPre;
    }

    public void setBismillahPre(Boolean bismillahPre) {
        this.bismillahPre = bismillahPre;
    }

    public String getRevelationPlace() {
        return revelationPlace;
    }

    public void setRevelationPlace(String revelationPlace) {
        this.revelationPlace = revelationPlace;
    }

    public String getNameArabic() {
        return nameArabic;
    }

    public void setNameArabic(String nameArabic) {
        this.nameArabic = nameArabic;
    }

    public Integer getVersesCount() {
        return versesCount;
    }

    public void setVersesCount(Integer versesCount) {
        this.versesCount = versesCount;
    }

    public TranslatedName getTranslatedName() {
        return translatedName;
    }

    public void setTranslatedName(TranslatedName translatedName) {
        this.translatedName = translatedName;
    }

}