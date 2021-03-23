package com.example.quranapplication.index_surahs;

public class Surah {

    private String Sur_Name;
    private String Sur_number;
    private int photo_star,photo_speaker;


    public Surah() {
    }

    public Surah(String sur_Name, String sur_number, int photo_star, int photo_speaker) {
        Sur_Name = sur_Name;
        Sur_number = sur_number;
        this.photo_star = photo_star;
        this.photo_speaker = photo_speaker;
    }

    public String getSur_Name() {
        return Sur_Name;
    }

    public void setSur_Name(String sur_Name) {
        Sur_Name = sur_Name;
    }

    public String getSur_number() {
        return Sur_number;
    }

    public void setSur_number(String sur_number) {
        Sur_number = sur_number;
    }

    public int getPhoto_star() {
        return photo_star;
    }

    public void setPhoto_star(int photo_star) {
        this.photo_star = photo_star;
    }

    public int getPhoto_speaker() {
        return photo_speaker;
    }

    public void setPhoto_speaker(int photo_speaker) {
        this.photo_speaker = photo_speaker;
    }
}
