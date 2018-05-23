package com.softvision.themoviedb.data.model.movie.keywords;

import com.google.gson.annotations.*;

import java.util.*;

import lombok.*;

@Data
public class Keywords {
    @SerializedName ("id")
    @Expose
    private Integer id;
    @SerializedName("keywords")
    @Expose
    private List<Keyword> keywords = null;
}
