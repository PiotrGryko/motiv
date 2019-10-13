package com.motiv.example;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class AuthToken extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("token")
    private java.lang.String token;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getToken() {

        return this.token;
    }

    public void setToken(java.lang.String token) {
        this.token = token;
    }

    public static AuthToken fromJson(String json) {
        return gson.fromJson(json, AuthToken.class);
    }

    public static String toJson(AuthToken object) {
        return gson.toJson(object, AuthToken.class);
    }

    public static String toJsonArray(AuthToken[] array) {
        return gson.toJson(array, AuthToken[].class);
    }

    public static AuthToken[] fromJsonArray(String array) {
        return gson.fromJson(array, AuthToken[].class);
    }
}
