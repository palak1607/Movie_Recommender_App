
package com.example.movie_recommender_app;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
public class Datum {

    @SerializedName("Desc")
    @Expose
    private List desc;
    @SerializedName("ReleaseDate")
    @Expose
    private List  releaseDate;
    @SerializedName("titles")
    @Expose
    private List titles;

    public String getDesc(int i) {
        return (String) desc.get(i);
    }

    public void setDesc(String desc, int i) {
        this.desc.set(i, desc);
    }

//    public String getReleaseDate() {
//        return releaseDate;
//    }
//
//    public void setReleaseDate(String releaseDate) {
//        this.releaseDate = releaseDate;
//    }

    public String getTitles(int i) {
        return (String)titles.get(i);
    }

    public void setTitles(String titles, int i) {
        this.titles.set(i, titles);
    }

}
