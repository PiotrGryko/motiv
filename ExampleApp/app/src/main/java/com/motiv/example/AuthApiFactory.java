package com.motiv.example;

import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.motiv.example.dao.LocalStorage;
import java.io.*;
import okhttp3.*;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.*;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.*;

public class AuthApiFactory {

    private AuthApiApi authApiApi;
    private static AuthApi authApi;
    private static AuthApiFactory instance;

    private AuthApiFactory(final LocalStorage localStorage) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").create();
        Retrofit retrofit =
                new Retrofit.Builder()
                        .client(client)
                        .baseUrl("https://private-fe08d8-auth130.apiary-mock.com/")
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
        authApiApi = retrofit.create(AuthApiApi.class);
        authApi = new AuthApi(authApiApi);
    }

    public static AuthApi getInstance(LocalStorage localStorage) {
        if (instance == null) {
            instance = new AuthApiFactory(localStorage);
        }
        return instance.authApi;
    }
}
