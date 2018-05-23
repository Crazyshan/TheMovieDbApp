package com.softvision.themoviedb.data.model.movie.castandcrew;

import com.google.gson.annotations.*;

import java.util.*;

import lombok.*;

@Data
public class CastAndCrew {
    @SerializedName ("id")
    @Expose
    private Integer id;
    @SerializedName("cast")
    @Expose
    private List<Cast> cast = null;
    @SerializedName("crew")
    @Expose
    private List<Crew> crew = null;
}
