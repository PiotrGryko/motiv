package com.motiv.example;

import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import retrofit2.*;
import retrofit2.http.*;

public class AuthApi {

    private static AuthApiApi authApiApi;

    public AuthApi(AuthApiApi authApiApi) {
        this.authApiApi = authApiApi;
    }

    public void getToken(
            final com.motiv.example.OnResponseListener<com.motiv.example.AuthToken>
                    onResponseListener) {
        authApiApi
                .getToken()
                .enqueue(
                        new Callback<com.motiv.example.AuthToken>() {
                            @Override
                            public void onResponse(
                                    Call<com.motiv.example.AuthToken> call,
                                    retrofit2.Response<com.motiv.example.AuthToken> response) {

                                onResponseListener.onSuccess(response.body());
                            }

                            @Override
                            public void onFailure(
                                    Call<com.motiv.example.AuthToken> call, Throwable t) {

                                onResponseListener.onError(new Exception(t.getMessage()));
                            }
                        });
    }
}
