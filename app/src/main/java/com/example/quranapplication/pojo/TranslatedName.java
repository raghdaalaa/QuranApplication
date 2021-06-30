package com.example.quranapplication.pojo;


import com.google.gson.annotations.SerializedName;

public class TranslatedName {

        @SerializedName("language_name")

        private String languageName;
        @SerializedName("name")

        private String name;

        public String getLanguageName() {
            return languageName;
        }

        public void setLanguageName(String languageName) {
            this.languageName = languageName;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    }


