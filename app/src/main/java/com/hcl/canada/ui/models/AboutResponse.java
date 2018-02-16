package com.hcl.canada.ui.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AboutResponse {

    @SerializedName("title")
    private String title;
    @SerializedName("rows")
    private List<AboutItem> aboutItems;

    public AboutResponse(String title, List<AboutItem> aboutItems) {
        this.title = title;
        this.aboutItems = aboutItems;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<AboutItem> getAboutItems() {
        return aboutItems;
    }

    public void setAboutItems(List<AboutItem> aboutItems) {
        this.aboutItems = aboutItems;
    }
}
