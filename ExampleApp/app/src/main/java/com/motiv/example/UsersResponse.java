package com.motiv.example;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import com.squareup.picasso.Picasso;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "usersresponse")
public class UsersResponse {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "metaId")
    @ForeignKey(
        entity = com.motiv.example.Meta.class,
        parentColumns = "id",
        childColumns = "metaId"
    )
    private java.lang.String metaId;

    @Ignore
    @SerializedName("result")
    private java.util.List<com.motiv.example.User> result;

    @Ignore
    @SerializedName("_meta")
    private com.motiv.example.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.util.List<com.motiv.example.User> getResult() {

        return this.result;
    }

    public void setResult(java.util.List<com.motiv.example.User> result) {
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

    public java.lang.String getMetaId() {
        return this.metaId;
    };

    public void setMetaId(java.lang.String metaId) {
        this.metaId = metaId;
    }
}
