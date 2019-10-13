package com.motiv.example;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.*;
import androidx.room.*;
import com.bumptech.glide.Glide;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;

@Entity(tableName = "authtoken")
public class AuthToken {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "token")
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

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {
        Glide.with(view.getContext()).load(url).into(view);
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
