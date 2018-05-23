package com.softvision.themoviedb.data.model.movie.keywords;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class Keyword {
    @SerializedName ("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
}
