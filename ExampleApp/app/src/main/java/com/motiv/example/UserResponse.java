package com.motiv.example;

import androidx.annotation.NonNull;
import androidx.room.*;
import com.google.gson.*;
import com.google.gson.annotations.*;
import com.google.gson.reflect.*;
import java.util.*;
import java.util.concurrent.*;

@Entity(tableName = "userresponse")
public class UserResponse {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "resultId")
    @ForeignKey(
        entity = com.motiv.example.User.class,
        parentColumns = "id",
        childColumns = "resultId"
    )
    private java.lang.String resultId;

    @ColumnInfo(name = "metaId")
    @ForeignKey(
        entity = com.motiv.example.Meta.class,
        parentColumns = "id",
        childColumns = "metaId"
    )
    private java.lang.String metaId;

    @Ignore
    @SerializedName("result")
    private com.motiv.example.User result;

    @Ignore
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

    public java.lang.String getResultId() {
        return this.resultId;
    };

    public void setResultId(java.lang.String resultId) {
        this.resultId = resultId;
    }

    public java.lang.String getMetaId() {
        return this.metaId;
    };

    public void setMetaId(java.lang.String metaId) {
        this.metaId = metaId;
    }
}
