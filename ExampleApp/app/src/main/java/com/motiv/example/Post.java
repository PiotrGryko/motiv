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

@Entity(tableName = "post")
public class Post {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "resultOwnerId")
    @ForeignKey(
        entity = com.motiv.example.PostsListResponse.class,
        parentColumns = "id",
        childColumns = "resultOwnerId"
    )
    private java.lang.String resultOwnerId;

    @ColumnInfo(name = "linksId")
    @ForeignKey(
        entity = com.motiv.example.Links.class,
        parentColumns = "id",
        childColumns = "linksId"
    )
    private java.lang.String linksId;

    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    private java.lang.String user_id;

    @Ignore
    @SerializedName("_links")
    private com.motiv.example.Links links;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    private java.lang.String title;

    @ColumnInfo(name = "body")
    @SerializedName("body")
    private java.lang.String body;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getUser_id() {

        return this.user_id;
    }

    public void setUser_id(java.lang.String user_id) {
        this.user_id = user_id;
    }

    public com.motiv.example.Links getLinks() {

        return this.links;
    }

    public void setLinks(com.motiv.example.Links links) {
        this.links = links;
    }

    public java.lang.String getTitle() {

        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getBody() {

        return this.body;
    }

    public void setBody(java.lang.String body) {
        this.body = body;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, java.lang.String url) {
        Glide.with(view.getContext()).load(url).into(view);
    }

    public static Post fromJson(String json) {
        return gson.fromJson(json, Post.class);
    }

    public static String toJson(Post object) {
        return gson.toJson(object, Post.class);
    }

    public static String toJsonArray(Post[] array) {
        return gson.toJson(array, Post[].class);
    }

    public static Post[] fromJsonArray(String array) {
        return gson.fromJson(array, Post[].class);
    }

    public java.lang.String getResultOwnerId() {
        return this.resultOwnerId;
    };

    public void setResultOwnerId(java.lang.String resultOwnerId) {
        this.resultOwnerId = resultOwnerId;
    }

    public java.lang.String getLinksId() {
        return this.linksId;
    };

    public void setLinksId(java.lang.String linksId) {
        this.linksId = linksId;
    }
}
