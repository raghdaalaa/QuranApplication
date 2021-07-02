 package com.example.quranapplication.VersesModel;

import java.util.List;

import com.example.quranapplication.VersesModel.Meta;
import com.google.gson.annotations.SerializedName;


public class VerseModel {

    @SerializedName("verses")

    private List<Verse> verses = null;
    @SerializedName("meta")

    private Meta meta;

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

}