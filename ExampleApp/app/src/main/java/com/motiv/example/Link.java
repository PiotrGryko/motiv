package com.motiv.example;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.fragment.app.*;
import com.bumptech.glide.Glide;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import dagger.*;
import dagger.android.*;
import dagger.android.support.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;
import javax.inject.*;

public class Link extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("href")
    private java.lang.String href;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getHref() {

        return this.href;
    }

    public void setHref(java.lang.String href) {
        this.href = href;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public static Link fromJson(String json) {
        return gson.fromJson(json, Link.class);
    }

    public static String toJson(Link object) {
        return gson.toJson(object, Link.class);
    }

    public static String toJsonArray(Link[] array) {
        return gson.toJson(array, Link[].class);
    }

    public static Link[] fromJsonArray(String array) {
        return gson.fromJson(array, Link[].class);
    }
}
