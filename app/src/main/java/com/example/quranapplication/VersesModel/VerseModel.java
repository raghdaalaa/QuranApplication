
package com.example.quranapplication.VersesModel;

import java.util.List;
import com.example.quranapplication.VersesModel.Verse;
import com.google.gson.annotations.SerializedName;


public class VerseModel {

    @SerializedName("verses")

    private List<Verse> verses ;

    public List<Verse> getVerses() {
        return verses;
    }

    public void setVerses(List<Verse> verses) {
        this.verses = verses;
    }

}