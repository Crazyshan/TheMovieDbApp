package com.softvision.themoviedb.data.model.auth;

import android.annotation.*;
import android.os.*;
import android.support.annotation.*;

import com.google.gson.annotations.*;

import lombok.*;

@Data
public class LoginResponse {

    @SerializedName("expires_at")
    @Expose
    private String expiresAt;
    @SerializedName("request_token")
    @Expose
    private String requestToken;




}
