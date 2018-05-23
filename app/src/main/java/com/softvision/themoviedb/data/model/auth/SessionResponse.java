package com.softvision.themoviedb.data.model.auth;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class SessionResponse {
    @SerializedName ("success")
    @Expose
    private Boolean success;
    @SerializedName("session_id")
    @Expose
    private String sessionId;
}
