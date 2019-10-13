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

@Entity(tableName = "postslistresponse")
public class PostsListResponse {

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
    private java.util.List<com.motiv.example.Post> result;

    @Ignore
    @SerializedName("_meta")
    private com.motiv.example.Meta meta;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.util.List<com.motiv.example.Post> getResult() {

        return this.result;
    }

    public void setResult(java.util.List<com.motiv.example.Post> result) {
        this.result = result;
    }

    public com.motiv.example.Meta getMeta() {

        return this.meta;
    }

    public void setMeta(com.motiv.example.Meta meta) {
        this.meta = meta;
    }

    public static PostsListResponse fromJson(String json) {
        return gson.fromJson(json, PostsListResponse.class);
    }

    public static String toJson(PostsListResponse object) {
        return gson.toJson(object, PostsListResponse.class);
    }

    public static String toJsonArray(PostsListResponse[] array) {
        return gson.toJson(array, PostsListResponse[].class);
    }

    public static PostsListResponse[] fromJsonArray(String array) {
        return gson.fromJson(array, PostsListResponse[].class);
    }

    public java.lang.String getMetaId() {
        return this.metaId;
    };

    public void setMetaId(java.lang.String metaId) {
        this.metaId = metaId;
    }
}
