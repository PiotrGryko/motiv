package com.motiv.example;

import androidx.annotation.NonNull;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import io.realm.*;
import java.util.*;
import java.util.concurrent.*;

public class Photo extends RealmObject {

    private static final Gson gson = new Gson();
    @NonNull private java.lang.String id = UUID.randomUUID().toString();

    @SerializedName("thumbnail")
    private java.lang.String thumbnail;

    @SerializedName("_links")
    private com.motiv.example.Links links;

    @SerializedName("album_id")
    private java.lang.String album_id;

    @SerializedName("title")
    private java.lang.String title;

    @SerializedName("url")
    private java.lang.String url;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getThumbnail() {

        return this.thumbnail;
    }

    public void setThumbnail(java.lang.String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public com.motiv.example.Links getLinks() {

        return this.links;
    }

    public void setLinks(com.motiv.example.Links links) {
        this.links = links;
    }

    public java.lang.String getAlbum_id() {

        return this.album_id;
    }

    public void setAlbum_id(java.lang.String album_id) {
        this.album_id = album_id;
    }

    public java.lang.String getTitle() {

        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getUrl() {

        return this.url;
    }

    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    public static Photo fromJson(String json) {
        return gson.fromJson(json, Photo.class);
    }

    public static String toJson(Photo object) {
        return gson.toJson(object, Photo.class);
    }

    public static String toJsonArray(Photo[] array) {
        return gson.toJson(array, Photo[].class);
    }

    public static Photo[] fromJsonArray(String array) {
        return gson.fromJson(array, Photo[].class);
    }
}
