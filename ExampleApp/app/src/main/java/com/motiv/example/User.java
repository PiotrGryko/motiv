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

@Entity(tableName = "user")
public class User {

    private static final Gson gson = new Gson();
    @NonNull @PrimaryKey private java.lang.String id = UUID.randomUUID().toString();

    @ColumnInfo(name = "linksId")
    @ForeignKey(
        entity = com.motiv.example.Links.class,
        parentColumns = "id",
        childColumns = "linksId"
    )
    private java.lang.String linksId;

    @ColumnInfo(name = "resultOwnerId")
    @ForeignKey(
        entity = com.motiv.example.UsersResponse.class,
        parentColumns = "id",
        childColumns = "resultOwnerId"
    )
    private java.lang.String resultOwnerId;

    @ColumnInfo(name = "website")
    @SerializedName("website")
    private java.lang.String website;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private java.lang.String address;

    @ColumnInfo(name = "gender")
    @SerializedName("gender")
    private java.lang.String gender;

    @ColumnInfo(name = "phone")
    @SerializedName("phone")
    private java.lang.String phone;

    @Ignore
    @SerializedName("_links")
    private com.motiv.example.Links links;

    @ColumnInfo(name = "dob")
    @SerializedName("dob")
    private java.lang.String dob;

    @ColumnInfo(name = "last_name")
    @SerializedName("last_name")
    private java.lang.String last_name;

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    private java.lang.String first_name;

    @ColumnInfo(name = "email")
    @SerializedName("email")
    private java.lang.String email;

    @ColumnInfo(name = "status")
    @SerializedName("status")
    private java.lang.String status;

    public java.lang.String getId() {

        return this.id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getWebsite() {

        return this.website;
    }

    public void setWebsite(java.lang.String website) {
        this.website = website;
    }

    public java.lang.String getAddress() {

        return this.address;
    }

    public void setAddress(java.lang.String address) {
        this.address = address;
    }

    public java.lang.String getGender() {

        return this.gender;
    }

    public void setGender(java.lang.String gender) {
        this.gender = gender;
    }

    public java.lang.String getPhone() {

        return this.phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public com.motiv.example.Links getLinks() {

        return this.links;
    }

    public void setLinks(com.motiv.example.Links links) {
        this.links = links;
    }

    public java.lang.String getDob() {

        return this.dob;
    }

    public void setDob(java.lang.String dob) {
        this.dob = dob;
    }

    public java.lang.String getLast_name() {

        return this.last_name;
    }

    public void setLast_name(java.lang.String last_name) {
        this.last_name = last_name;
    }

    public java.lang.String getFirst_name() {

        return this.first_name;
    }

    public void setFirst_name(java.lang.String first_name) {
        this.first_name = first_name;
    }

    public java.lang.String getEmail() {

        return this.email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getStatus() {

        return this.status;
    }

    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    public static User fromJson(String json) {
        return gson.fromJson(json, User.class);
    }

    public static String toJson(User object) {
        return gson.toJson(object, User.class);
    }

    public static String toJsonArray(User[] array) {
        return gson.toJson(array, User[].class);
    }

    public static User[] fromJsonArray(String array) {
        return gson.fromJson(array, User[].class);
    }

    public java.lang.String getLinksId() {
        return this.linksId;
    };

    public void setLinksId(java.lang.String linksId) {
        this.linksId = linksId;
    }

    public java.lang.String getResultOwnerId() {
        return this.resultOwnerId;
    };

    public void setResultOwnerId(java.lang.String resultOwnerId) {
        this.resultOwnerId = resultOwnerId;
    }
}
