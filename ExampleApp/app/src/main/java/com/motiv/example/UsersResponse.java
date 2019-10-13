package com.motiv.example;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class UsersResponse extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("result")
    private RealmList<com.motiv.example.User> result;

    @SerializedName("_meta")
    private com.motiv.example.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public RealmList<com.motiv.example.User> getResult() {

        return this.result;
    }

    public void setResult(RealmList<com.motiv.example.User> result) {
        this.result = result;
    }

    public com.motiv.example.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.example.Meta meta) {
        this.meta = meta;
    }

    public static UsersResponse fromJson(String json) {
        return gson.fromJson(json, UsersResponse.class);
    }

    public static String toJson(UsersResponse object) {
        return gson.toJson(object, UsersResponse.class);
    }

    public static String toJsonArray(UsersResponse[] array) {
        return gson.toJson(array, UsersResponse[].class);
    }

    public static UsersResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, UsersResponse[].class);
    }
}
