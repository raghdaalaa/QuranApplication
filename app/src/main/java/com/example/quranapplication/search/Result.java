package com.example.quranapplication.search;


import java.util.List;
import com.google.gson.annotations.SerializedName;

    public class Result {

        @SerializedName("verse_id")
        private Integer verseId;
        @SerializedName("text")
        private String text;
        @SerializedName("translations")

        private List<Translation> translations = null;

        public Integer getVerseId() {
            return verseId;
        }

        public void setVerseId(Integer verseId) {
            this.verseId = verseId;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public List<Translation> getTranslations() {
            return translations;
        }

        public void setTranslations(List<Translation> translations) {
            this.translations = translations;
        }

    }
