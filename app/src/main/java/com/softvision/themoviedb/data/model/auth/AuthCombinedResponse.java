package com.softvision.themoviedb.data.model.auth;

import lombok.*;

@Data
public class AuthCombinedResponse {
    private LoginResponse loginResponse;
    private SessionResponse sessionResponse;
}
