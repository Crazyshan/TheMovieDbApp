package com.softvision.themoviedb.data.model.movie.videos;

import com.google.gson.annotations.*;

import java.util.*;

import lombok.*;

@Data
public class Videos {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("results")
    @Expose
    private List<Video> results = null;
}
