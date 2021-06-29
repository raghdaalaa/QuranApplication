package com.example.quranapplication.VersesModel;
import java.util.List;
import com.google.gson.annotations.SerializedName;


public class Verse {


    @SerializedName("id")

    private int id;
    @SerializedName("verse_number")

    private int verseNumber;
    @SerializedName("chapter_id")

    private int chapterId;
    @SerializedName("text_indopak")

    private String textIndopak;

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

    public String getTextIndopak() {
        return textIndopak;
    }

    public void setTextIndopak(String textIndopak) {
        this.textIndopak = textIndopak;
    }

}
