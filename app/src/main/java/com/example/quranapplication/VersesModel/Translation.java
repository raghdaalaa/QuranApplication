package com.example.quranapplication.VersesModel;


import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Translation {

    @SerializedName("id")

    private Integer id;
    @SerializedName("language_name")

    private String languageName;
    @SerializedName("text")

    private String text;
    @SerializedName("resource_id")

    private Integer resourceId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getResourceId() {
        return resourceId;
    }

    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }


}

