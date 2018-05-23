package com.softvision.themoviedb.data.model.movie.details;

import com.google.gson.annotations.*;

import java.util.*;

import lombok.*;

@Data
public class Images {
    @SerializedName ("backdrops")
    @Expose
    private List<Object> backdrops = null;
    @SerializedName("posters")
    @Expose
    private List<Object> posters = null;
}
