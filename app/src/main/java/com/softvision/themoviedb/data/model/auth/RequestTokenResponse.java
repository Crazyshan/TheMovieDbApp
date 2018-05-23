package com.softvision.themoviedb.data.model.auth;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class RequestTokenResponse {
    @SerializedName ( "expires_at" )
    @Expose
    public String expiresAt;
    @SerializedName ( "request_token" )
    @Expose
    public String requestToken;
    @SerializedName ( "success" )
    @Expose
    private Boolean success;
}
