package com.softvision.themoviedb.data.model.movie;

import com.softvision.themoviedb.data.model.movie.castandcrew.*;
import com.softvision.themoviedb.data.model.movie.keywords.*;
import com.softvision.themoviedb.data.model.movie.videos.*;

import lombok.*;

@Data
public class CombinedObject {

    private Videos videos;
    private Keywords keywords;
    private CastAndCrew castAndCrew;

}
