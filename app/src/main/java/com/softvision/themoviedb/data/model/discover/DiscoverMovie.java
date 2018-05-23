package com.softvision.themoviedb.data.model.discover;

import com.google.gson.annotations.*;

import java.util.*;

import lombok.*;

@Data
public class DiscoverMovie {
    @SerializedName("page")
    @Expose
    private Integer page;
    @SerializedName("total_results")
    @Expose
    private Integer totalResults;
    @SerializedName("total_pages")
    @Expose
    private Integer totalPages;
    @SerializedName("results")
    @Expose
    private List<DiscoverMovieResult> results = null;
}
