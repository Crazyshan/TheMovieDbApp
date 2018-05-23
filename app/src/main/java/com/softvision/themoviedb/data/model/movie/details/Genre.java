package com.softvision.themoviedb.data.model.movie.details;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class Genre {
    @SerializedName ("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
}
