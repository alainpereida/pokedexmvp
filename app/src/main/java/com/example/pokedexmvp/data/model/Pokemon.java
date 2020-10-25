package com.example.pokedexmvp.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    private int number;
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("url")
    @Expose
    private String url;

    public int getNumber() {
        String[] url = this.url.split("/");
        return Integer.parseInt(url[url.length - 1]);
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
