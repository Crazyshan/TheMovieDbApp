package com.softvision.themoviedb.data.model.movie.details;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class ProductionCompany {
    @SerializedName ("id")
    @Expose
    private Integer id;
    @SerializedName("logo_path")
    @Expose
    private String logoPath;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("origin_country")
    @Expose
    private String originCountry;
}
