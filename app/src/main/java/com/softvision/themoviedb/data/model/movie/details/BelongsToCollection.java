package com.softvision.themoviedb.data.model.movie.details;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class BelongsToCollection {
    @SerializedName ("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
}
