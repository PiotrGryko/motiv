package com.motiv.example;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class Meta extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("code")
    private int code;

    @SerializedName("success")
    private boolean success;

    @SerializedName("message")
    private java.lang.String message;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public int getCode() {

        return this.code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public boolean getSuccess() {

        return this.success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public java.lang.String getMessage() {

        return this.message;
    }

    public void setMessage(java.lang.String message) {
        this.message = message;
    }

    public static Meta fromJson(String json) {
        return gson.fromJson(json, Meta.class);
    }

    public static String toJson(Meta object) {
        return gson.toJson(object, Meta.class);
    }

    public static String toJsonArray(Meta[] array) {
        return gson.toJson(array, Meta[].class);
    }

    public static Meta[] fromJsonArray(String array) {
        return gson.fromJson(array, Meta[].class);
    }
}
