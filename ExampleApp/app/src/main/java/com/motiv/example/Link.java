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

@Entity(tableName = "link")
public class Link {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "href")
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
