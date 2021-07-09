package com.example.quranapplication.search;

import com.google.gson.annotations.SerializedName;

    public class Translation {

        @SerializedName("text")

        private String text;

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

