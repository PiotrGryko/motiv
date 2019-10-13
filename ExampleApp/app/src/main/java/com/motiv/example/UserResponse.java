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

public class UserResponse extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("result")
    private com.motiv.example.User result;

    @SerializedName("_meta")
    private com.motiv.example.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public com.motiv.example.User getResult() {

        return this.result;
    }

    public void setResult(com.motiv.example.User result) {
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

    public static UserResponse fromJson(String json) {
        return gson.fromJson(json, UserResponse.class);
    }

    public static String toJson(UserResponse object) {
        return gson.toJson(object, UserResponse.class);
    }

    public static String toJsonArray(UserResponse[] array) {
        return gson.toJson(array, UserResponse[].class);
    }

    public static UserResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, UserResponse[].class);
    }
}
