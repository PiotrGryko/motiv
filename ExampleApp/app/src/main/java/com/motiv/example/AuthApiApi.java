package com.motiv.example;

import retrofit2.*;
import retrofit2.http.*;

public interface AuthApiApi {

    @POST("auth")
    Call<AuthToken> getToken();
}
