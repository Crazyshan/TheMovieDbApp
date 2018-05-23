package com.softvision.themoviedb.data.model.movie.details;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class ProductionCountry {
    @SerializedName ("iso_3166_1")
    @Expose
    private String iso31661;
    @SerializedName("name")
    @Expose
    private String name;
}
