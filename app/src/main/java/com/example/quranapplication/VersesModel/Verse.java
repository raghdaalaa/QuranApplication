package com.example.quranapplication.VersesModel;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Verse {

    @SerializedName("id")

    private Integer id;
    @SerializedName("verse_number")
    private Integer verseNumber;
    @SerializedName("chapter_id")

    private Integer chapterId;
    @SerializedName("text_madani")

    private String textMadani;
    @SerializedName("translations")

    private List<Translation> translations = null;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getVerseNumber() {
        return verseNumber;
    }
    public void setVerseNumber(Integer verseNumber) {
        this.verseNumber = verseNumber;
    }
    public Integer getChapterId() {
        return chapterId;
    }
    public void setChapterId(Integer chapterId) {
        this.chapterId = chapterId;
    }

    public String getTextMadani() {
        return textMadani;
    }

    public void setTextMadani(String textMadani) {
        this.textMadani = textMadani;
    }

    public List<Translation> getTranslations() {
        return translations;
    }
    public void setTranslations(List<Translation> translations) {
        this.translations = translations;
    }
}