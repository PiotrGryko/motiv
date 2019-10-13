package com.motiv.example;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.squareup.picasso.Picasso;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class PhotosListResponse extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("result")
    private RealmList<com.motiv.example.Photo> result;

    @SerializedName("_meta")
    private com.motiv.example.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public RealmList<com.motiv.example.Photo> getResult() {

        return this.result;
    }

    public void setResult(RealmList<com.motiv.example.Photo> result) {
        this.result = result;
    }

    public com.motiv.example.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.example.Meta meta) {
        this.meta = meta;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {

        Picasso.with(view.getContext()).load(url).into(view);
    }

    public static PhotosListResponse fromJson(String json) {
        return gson.fromJson(json, PhotosListResponse.class);
    }

    public static String toJson(PhotosListResponse object) {
        return gson.toJson(object, PhotosListResponse.class);
    }

    public static String toJsonArray(PhotosListResponse[] array) {
        return gson.toJson(array, PhotosListResponse[].class);
    }

    public static PhotosListResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, PhotosListResponse[].class);
    }
}
