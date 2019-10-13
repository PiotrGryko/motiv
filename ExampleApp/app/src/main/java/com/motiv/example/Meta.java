package com.motiv.example;

import androidx.annotation.NonNull;
import androidx.fragment.app.*;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;

@Entity(tableName = "meta")
public class Meta {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "code")
    @SerializedName("code")
    private int code;

    @ColumnInfo(name = "success")
    @SerializedName("success")
    private boolean success;

    @ColumnInfo(name = "message")
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
