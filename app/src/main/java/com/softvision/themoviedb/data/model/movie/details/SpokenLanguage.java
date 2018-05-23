package com.softvision.themoviedb.data.model.movie.details;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class SpokenLanguage {
    @SerializedName ("iso_639_1")
    @Expose
    private String iso6391;
    @SerializedName("name")
    @Expose
    private String name;
}
