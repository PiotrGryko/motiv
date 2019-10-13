package com.motiv.example;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class Links extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("edit")
    private com.motiv.example.Link edit;

    @SerializedName("self")
    private com.motiv.example.Link self;

    @SerializedName("avatar")
    private com.motiv.example.Link avatar;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public com.motiv.example.Link getEdit() {

        return this.edit;
    }

    public void setEdit(com.motiv.example.Link edit) {
        this.edit = edit;
    }

    public com.motiv.example.Link getSelf() {

        return this.self;
    }

    public void setSelf(com.motiv.example.Link self) {
        this.self = self;
    }

    public com.motiv.example.Link getAvatar() {

        return this.avatar;
    }

    public void setAvatar(com.motiv.example.Link avatar) {
        this.avatar = avatar;
    }

    public static Links fromJson(String json) {
        return gson.fromJson(json, Links.class);
    }

    public static String toJson(Links object) {
        return gson.toJson(object, Links.class);
    }

    public static String toJsonArray(Links[] array) {
        return gson.toJson(array, Links[].class);
    }

    public static Links[] fromJsonArray(String array) {
        return gson.fromJson(array, Links[].class);
    }
}
