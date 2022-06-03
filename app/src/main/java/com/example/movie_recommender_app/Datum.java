
package com.example.movie_recommender_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("Desc")
    @Expose
    private String desc;

    @SerializedName("titles")
    @Expose
    private String titles;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitles() {
        return titles;
    }

    public void setTitles(String titles) {
        this.titles = titles;
    }

//    public String getTitles(int i) {        // ignore
//        return (String)titles.get(i);
//    }
//
//    public void setTitles(String titles, int i) {
//        this.titles.set(i, titles);
//    }

}
